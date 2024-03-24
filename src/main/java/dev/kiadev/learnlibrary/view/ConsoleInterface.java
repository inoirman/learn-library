package dev.kiadev.learnlibrary.view;

import dev.kiadev.learnlibrary.factory.CommandFactory;
import dev.kiadev.learnlibrary.service.LibraryService;

import java.util.Scanner;

public class ConsoleInterface {

    private final CommandFactory commandFactory;
    private static final Scanner scanner = new Scanner(System.in);

    public ConsoleInterface(LibraryService libraryService) {
        this.commandFactory = new CommandFactory(libraryService, scanner);
    }

    public void start() {



        while (true) {
            System.out.println("\n1. Авторы");
            System.out.println("2. Книги");
            System.out.println("0. Выход");
            System.out.print("Выберите категорию: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showAuthorsMenu();
                    break;
                case 2:
                    showBooksMenu();
                    break;
                case 0:
                    return;
            }
        }
    }

    private void showAuthorsMenu() {
        while (true) {
            System.out.println("\n1. Список авторов");
            System.out.println("2. Добавить автора");
            System.out.println("0. Назад");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 2:
                    commandFactory.getCommand("addAuthor").execute();
                    break;
                case 1:
                    commandFactory.getCommand("listAuthors").execute();
                    break;
                case 0:
                    return;
            }
        }
    }

    private void showBooksMenu() {
        while (true) {
            System.out.println("\n1. Список книг");
            System.out.println("2. Добавить книгу");
            System.out.println("0. Назад");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 2:
                    commandFactory.getCommand("addBook").execute();
                    break;
                case 1:
                    commandFactory.getCommand("listBooks").execute();
                    break;
                case 0:
                    return;
            }
        }

    }

//
//    private static void addBook() {
//        System.out.println("Enter the title of the book");
//        String title = scanner.next();
//        System.out.println("Enter the author of the book");
//        String author = scanner.next();
//        libraryService.addBook(title, 1);
//        System.out.println("Book added successfully");
//
//    }
//
//    private static void addAuthor() {
//        System.out.println("Enter the name of the author");
//        String name = scanner.next();
//        libraryService.addAuthor(name);
//        System.out.println("Author added successfully");
//
//    }
//
//    private static void listBooks() {
//        libraryService.findAllBooks().forEach(System.out::println);
//
//    }
//
//    private static void listAuthors() {
//        libraryService.findAllAuthors().forEach(System.out::println);
//
//    }

//    public static void main(String[] args) {
//        start();
//    }

}
