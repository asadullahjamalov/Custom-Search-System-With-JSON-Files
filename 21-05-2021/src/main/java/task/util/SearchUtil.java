package task.util;

import task.base.Person;

import java.util.Set;

import static task.base.Base.*;
import static task.util.GeneralUtil.checkString;

public class SearchUtil {
    public static void searchBasedOnName() {
        System.out.println("Enter the name (or part of name) of person to search");
        String name = checkString("Name", false);
        int count = 0;
        for (Person person : personList) {
            count++;
            if (person.getName().startsWith(name)) {
                count--;
                System.out.println(person.toString());
            } else if (personList.size() == count) {
                System.out.println("There is not any person with this '" + name +
                        "' name part");
            }
        }
    }

    public static void searchBasedOnSurName() {
        System.out.println("Enter the surname (or part of surname) of person to search");
        String surname = checkString("Surname", false);
        int count = 0;
        for (Person person : personList) {
            count++;
            if (person.getSurname().startsWith(surname)) {
                count--;
                System.out.println(person.toString());
            } else if (personList.size() == count) {
                System.out.println("There is not any person with this '" + surname +
                        "' surname part");
            }
        }
    }

    public static void searchBasedOnFatherName() {
        System.out.println("Enter the father name (or part of father name ) of person to search");
        String fatherName = checkString("Father Name", false);
        int count = 0;
        for (Person person : personList) {
            count++;
            if (person.getFatherName().startsWith(fatherName)) {
                count--;
                System.out.println(person.toString());
            } else if (personList.size() == count) {
                System.out.println("There is not any person with this '" + fatherName +
                        "' father name part");
            }
        }
    }

    public static void searchBasedOnNameInHashMap() {
        System.out.println("Enter the name (or part of name) of person to search");
        String name = checkString("Name", false);
        Set<String> keys = personHashMapKeyName.keySet();
        int count = 0;
        for (String key : keys) {
            count++;
            if (key.startsWith(name)) {
                count--;
                Person person = personHashMapKeyName.get(key);
                System.out.println(person.toString());
            } else if (keys.size() == count) {
                System.out.println("There is not any person with this '" + name +
                        "' name part");
            }
        }
    }

    public static void searchBasedOnSurNameInHashMap() {
        System.out.println("Enter the surname (or part of surname) of person to search");
        String surname = checkString("Surname", false);
        Set<String> keys = personHashMapKeySurname.keySet();
        int count = 0;
        for (String key : keys) {
            count++;
            if (key.startsWith(surname)) {
                count--;
                Person person = personHashMapKeySurname.get(key);
                System.out.println(person.toString());
            } else if (keys.size() == count) {
                System.out.println("There is not any person with this '" + surname +
                        "' surname part");
            }
        }
    }

    public static void searchBasedOnFatherNameInHashMap() {
        System.out.println("Enter the father name (or part of father name ) of person to search");
        String fatherName = checkString("Father Name", false);
        Set<String> keys = personHashMapKeyFatherName.keySet();
        int count = 0;
        for (String key : keys) {
            count++;
            if (key.startsWith(fatherName)) {
                count--;
                Person person = personHashMapKeyFatherName.get(key);
                System.out.println(person.toString());
            } else if (keys.size() == count) {
                System.out.println("There is not any person with this '" + fatherName +
                        "' father name part");
            }
        }
    }

}
