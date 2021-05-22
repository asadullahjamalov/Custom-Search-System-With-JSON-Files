package task.menu;

import java.io.IOException;
import java.util.Scanner;

import static task.util.GeneralUtil.synchronizeHashMaps;
import static task.util.GeneralUtil.writeObjectToJSON;
import static task.util.PersonUtil.*;

public class PersonMenu {
    public static void showPersonMenu() throws IOException {
        OUT:
        while (true) {
            System.out.println("-------------Person Menu-------------");
            System.out.println("Choose one of the choices in the Person Menu: ");
            System.out.println("1)Add new Person");
            System.out.println("2)Show all People");
            System.out.println("3)Edit Person");
            System.out.println("4)Remove Person");
            System.out.println("5)Return to Main Menu");
            System.out.println("Enter your choice: ");

            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            if (choice.matches("[1-5]")) {
                switch (choice) {
                    case "1":
                        addPerson();
                        writeObjectToJSON();
                        break;
                    case "2":
                        showAllPeople();
                        break;
                    case "3":
                        updatePerson();
                        writeObjectToJSON();
                        break;
                    case "4":
                        removePerson();
                        writeObjectToJSON();
                        break;
                    case "5":
                        synchronizeHashMaps();
                        break OUT;

                }
            } else {
                System.out.println("There is not such choice," +
                        " please enter between 1-4");
                continue;
            }
        }
    }
}

