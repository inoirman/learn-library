package dev.kiadev.learnlibrary.command.author;

import dev.kiadev.learnlibrary.command.Command;
import dev.kiadev.learnlibrary.service.LibraryService;

public class ListAllAuthorsCommand implements Command {

    private final LibraryService libraryService;

    public ListAllAuthorsCommand(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @Override
    public void execute() {
        libraryService.findAllAuthors().forEach(author -> System.out.println(author.getId() + " " + author.getName()));
    }
}
