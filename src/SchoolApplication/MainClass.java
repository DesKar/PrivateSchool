package SchoolApplication;

import java.util.Scanner;

public class MainClass {

    static Scanner input = new Scanner(System.in);
    public static Database db = null;

    public static void main(String[] args) {

        Printing.printWelcomeMessage();
        MainMenu.chooseDb();
        String option = null;
        do {
            option = MainMenu.chooseOptionL1();
        } while (!option.equals("-q"));

    }
}
