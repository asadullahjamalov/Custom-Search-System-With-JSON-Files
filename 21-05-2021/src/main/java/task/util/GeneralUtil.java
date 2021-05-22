package task.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import task.base.Person;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static task.base.Base.*;

public class GeneralUtil {
    public static String idGenerator() {
        return UUID.randomUUID().toString();
    }

    public static String checkString(String info, boolean successMessage) {
        System.out.println("Enter the " + info);
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String data = scanner.nextLine();
            if (data.matches("[A-Za-z]+")) {
                if (successMessage) {
                    System.out.println(info + " was added");
                }
                return data;
            } else {
                System.out.println("Please enter " + info + " in correct format");
            }
        }

    }

    public static long checkLong(String info) {
        System.out.println("Enter the " + info);
        while (true) {
            String data = new Scanner(System.in).next();
            if (data.matches("([1-9][0-9]+)")) {
                return Long.parseLong(data);
            } else {
                System.out.println("Please enter corresponding " + info);
            }
        }
    }

    public static String checkEmail() {
        System.out.println("Enter the email");
        OUT:
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String data = scanner.nextLine();
            for (Person person : personList) {
                if (person.getEmail().equals(data)) {
                    System.out.println("This email is already exist. " +
                            "Please, select other email.");
                    continue OUT;
                }
            }
            if (data.matches("[A-Za-z[.]_0-9]+[@][A-Za-z[.]_0-9]+[.][a-z]{2,4}")) {
                System.out.println("Email was added");
                return data;
            } else {
                System.out.println("Please enter email in correct format");
            }
        }

    }

    public static String checkPhoneNumber() {
        System.out.println("Enter the phone number (+YYY-YY-YYY-YY-YY)");
        OUT:
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String data = scanner.nextLine();
            for (Person person : personList) {
                if (person.getPhoneNumber().equals(data)) {
                    System.out.println("This phone number is already exist. " +
                            "Please, select other phone number.");
                    continue OUT;
                }
            }
            if (data.matches("[+][0-9]{3}[-][0-9]{2}[-][0-9]{3}[-][0-9]{2}[-][0-9]{2}")) {
                System.out.println("Phone number was added");
                return data;
            } else {
                System.out.println("Please enter email in correct format (+YYY-YY-YYY-YY-YY)");
            }
        }
    }

    public static boolean changeHelper(String info) {
        System.out.println("Do you want to change " + info + "? (Y/N)");
        OUT:
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String data = scanner.nextLine();
            if (data.equalsIgnoreCase("yes") || data.equalsIgnoreCase("y")) {
                return true;
            } else if (data.equalsIgnoreCase("no") || data.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Please, enter corresponding answer (Y/N)");
                continue OUT;
            }
        }
    }

    public static void readJSONToList() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<LinkedList<Person>> reference = new TypeReference<>() {};
        personList = mapper.readValue(Path.of("people.json").toFile(), reference);
    }

    public static void writeObjectToJSON() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
        writer.writeValue(Path.of("people.json").toFile(), personList);
    }

    public static void synchronizeHashMaps() {
        personHashMapKeyName.clear();
        personHashMapKeySurname.clear();
        personHashMapKeyFatherName.clear();
        for (Person person : personList) {
            personHashMapKeyName.put(person.getName(), person);
            personHashMapKeySurname.put(person.getSurname(), person);
            personHashMapKeyFatherName.put(person.getFatherName(), person);
        }
    }



}
