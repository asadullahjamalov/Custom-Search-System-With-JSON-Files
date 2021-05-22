package task.menu;

import java.io.IOException;
import java.util.Scanner;

import static task.base.Base.personList;
import static task.menu.PersonMenu.showPersonMenu;
import static task.menu.SearchMenu.showSearchMenu;
import static task.util.GeneralUtil.readJSONToList;
import static task.util.GeneralUtil.synchronizeHashMaps;


public class MainMenu {

    public static void showMainMenu() throws IOException {
        readJSONToList();

        OUT:
        while (true) {
            System.out.println("-------------Main Menu-------------");
            System.out.println("Choose one of the choices in the Main Menu: ");
            System.out.println("1)Person Menu");
            System.out.println("2)Search Menu");
            System.out.println("3)Exit");
            System.out.println("Enter your choice: ");

            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            if (choice.matches("[1-3]")) {
                switch (choice) {
                    case "1":
                        showPersonMenu();
                        break;
                    case "2":
                        synchronizeHashMaps();
                        showSearchMenu();
                        break;
                    case "3":
                        break OUT;
                }
            } else {
                System.out.println("There is not such choice," +
                        " please enter between 1-3");
                continue;
            }


        }

    }

}
