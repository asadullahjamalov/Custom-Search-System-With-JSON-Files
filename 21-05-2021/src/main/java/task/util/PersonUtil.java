package task.util;

import task.base.Person;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import static task.base.Base.*;
import static task.util.GeneralUtil.*;

public class PersonUtil {
    public static void addPerson() {
        personList.add(addPersonDetails());
    }

    public static void showAllPeople() {
        if (personList.size() > 0) {
            System.out.println("Registered people are: ");
            for (Person person : personList) {
                System.out.println(person.toString());
            }
        } else {
            System.out.println("No people in the list");
        }
    }

    public static void updatePerson() {
        showAllPeople();
        System.out.println("Please enter person ID to update person");
        String id = new Scanner(System.in).nextLine();
        int count = 0;
        for (Person person : personList) {
            count++;
            if (person.getId().equals(id)) {
                Person updatedPerson = updatePersonDetails(person);
                personList.add(updatedPerson);
                personList.remove(person);
                sortPersonList();
                System.out.println("Person updated, successfully");
                break;
            } else if (personList.size() == count) {
                System.out.println("No such person with this ID");
            }
        }
    }

    public static void removePerson() {
        showAllPeople();
        System.out.println("Please enter person ID to remove person");
        String id = new Scanner(System.in).nextLine();
        int count = 0;
        for (Person person : personList) {
            count++;
            if (person.getId().equals(id)) {
                personList.remove(person);
                sortPersonList();
                System.out.println("Person removed, successfully");
                break;
            } else if (personList.size() == count) {
                System.out.println("No such person with this ID");
            }
        }
    }


    public static Person addPersonDetails() {
        String name = checkString("name", true);
        String surname = checkString("surname", true);
        String fatherName = checkString("father name", true);
        String email = checkEmail();
        String phoneNumber = checkPhoneNumber();
        return new Person(name, surname, fatherName, email, phoneNumber);
    }

    public static Person updatePersonDetails(Person person) {
        String id = person.getId();
        String name = changeHelper("name") ? checkString("name", false) : person.getName();
        String surname = changeHelper("surname") ? checkString("surname", false) : person.getSurname();
        String fatherName = changeHelper("father name") ? checkString("father name", false) : person.getFatherName();
        String email = changeHelper("email") ? checkEmail() : person.getEmail();
        String phoneNumber = changeHelper("phone number") ? checkPhoneNumber() : person.getPhoneNumber();
        return new Person(id, name, surname, fatherName, email, phoneNumber);
    }


    public static void sortPersonList() {
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return (int) (p1.getId().compareTo(p2.getId()));
            }
        });
    }


}
