package task.menu;

import java.util.Scanner;

import static task.util.SearchUtil.*;

public class SearchMenu {
    public static void showSearchMenu() {
        OUT:
        while (true) {
            System.out.println("-------------Search Menu-------------");
            System.out.println("Choose one of the choices in the Search Menu: ");
            System.out.println("1)Search based on names");
            System.out.println("2)Search based on surnames");
            System.out.println("3)Search based on father names");
            System.out.println("4)Return to Main Menu");
            System.out.println("Enter your choice: ");

            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            if (choice.matches("[1-4]")) {
                switch (choice) {
                    case "1":
                        searchBasedOnNameInHashMap();
                        break;
                    case "2":
                        searchBasedOnSurNameInHashMap();
                        break;
                    case "3":
                        searchBasedOnFatherNameInHashMap();
                        break;
                    case "4":
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
