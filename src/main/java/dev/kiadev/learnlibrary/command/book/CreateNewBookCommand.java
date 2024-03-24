package dev.kiadev.learnlibrary.command.book;

import dev.kiadev.learnlibrary.command.Command;
import dev.kiadev.learnlibrary.model.Author;
import dev.kiadev.learnlibrary.service.LibraryService;

import java.util.List;
import java.util.Scanner;

public class CreateNewBookCommand implements Command {
    private final LibraryService libraryService;
    private final Scanner scanner;

    public CreateNewBookCommand(LibraryService libraryService, Scanner scanner) {
        this.libraryService = libraryService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Choose author id or enter 0 to create new author:");
        List<Author> authors = libraryService.findAllAuthors();
        authors.forEach(author -> System.out.println(author.getId() + " - " + author.getName()));
        int authorId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Author selectedAuthor;
        if (authorId == 0) {
            System.out.println("Enter author name:");
            String authorName = scanner.nextLine();
            selectedAuthor = libraryService.addAuthor(authorName);
        } else {
            selectedAuthor = libraryService.findAuthorById(authorId);
        }

        System.out.println("Enter book title:");
        String bookTitle = scanner.nextLine();
        libraryService.addBook(bookTitle, selectedAuthor.getId());

        System.out.println("Book created successfully! - " + bookTitle + " by " + selectedAuthor.getName());

    }
}
