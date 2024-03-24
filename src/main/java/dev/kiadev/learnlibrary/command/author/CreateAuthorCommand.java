package dev.kiadev.learnlibrary.command.author;

import dev.kiadev.learnlibrary.command.Command;
import dev.kiadev.learnlibrary.model.Author;
import dev.kiadev.learnlibrary.service.LibraryService;

import java.util.Scanner;

public class CreateAuthorCommand implements Command {
    private final LibraryService libraryService;
    private final Scanner scanner;

    public CreateAuthorCommand(LibraryService libraryService, Scanner scanner) {
        this.libraryService = libraryService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Enter author name:");
        String authorName = scanner.nextLine();
        Author author = libraryService.addAuthor(authorName);
        System.out.println("Author created successfully! - " + author.getName());
    }
}
