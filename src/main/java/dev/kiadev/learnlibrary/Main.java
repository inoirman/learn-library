package dev.kiadev.learnlibrary;

import dev.kiadev.learnlibrary.service.LibraryService;
import dev.kiadev.learnlibrary.util.DbConnectionManager;
import dev.kiadev.learnlibrary.view.ConsoleInterface;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main( String[] args ) throws SQLException {
        DbConnectionManager dbConnectionManager = new DbConnectionManager();
        LibraryService libraryService = new LibraryService(dbConnectionManager);
        ConsoleInterface consoleInterface = new ConsoleInterface(libraryService);

        while (true) {
            System.out.println("Enter the interface of application: ");
            System.out.println("1. Console");
            System.out.println("2. GUI (in development)");
            System.out.println("0. Exit");
            System.out.println("Your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    consoleInterface.start();
                    break;
                case 2:
                    System.out.println("GUI is in development");
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
