package dev.kiadev.learnlibrary.command.book;

import dev.kiadev.learnlibrary.command.Command;
import dev.kiadev.learnlibrary.service.LibraryService;

public class ListAllBooksCommand implements Command {
    private final LibraryService libraryService;

    public ListAllBooksCommand(LibraryService libraryService) {
        this.libraryService = libraryService;
    }


    @Override
    public void execute() {
        libraryService
                .findAllBooks()
                .forEach(book -> System
                        .out
                        .println(book.getId() + " " + book.getTitle() + " (" + book.getAuthor().getName() + ")"));
    }
}
