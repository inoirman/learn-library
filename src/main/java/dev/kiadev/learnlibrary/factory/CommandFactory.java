package dev.kiadev.learnlibrary.factory;

import dev.kiadev.learnlibrary.command.Command;
import dev.kiadev.learnlibrary.command.author.*;
import dev.kiadev.learnlibrary.command.book.*;
import dev.kiadev.learnlibrary.service.LibraryService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandFactory {
    private final Map<String, Command> commands;

    public CommandFactory(LibraryService libraryService, Scanner scanner) {
        commands = new HashMap<>();
        commands.put("createAuthor", new CreateAuthorCommand(libraryService, scanner));
        commands.put("listAuthors", new ListAllAuthorsCommand(libraryService));
        commands.put("listBooks", new ListAllBooksCommand(libraryService));
        commands.put("addBook", new CreateNewBookCommand(libraryService, scanner));
    }

    public Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}
