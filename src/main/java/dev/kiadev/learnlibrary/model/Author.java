package dev.kiadev.learnlibrary.model;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private Integer id;
    private String name;
    private List<Book> books = new ArrayList<>();

    public Author() {

    }

    public Author(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Author(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        this.books.add(book);
        book.setAuthor(this);
    }
}
