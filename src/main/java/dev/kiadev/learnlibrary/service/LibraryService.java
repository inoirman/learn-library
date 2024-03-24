package dev.kiadev.learnlibrary.service;

import dev.kiadev.learnlibrary.dao.AuthorDao;
import dev.kiadev.learnlibrary.dao.BookDao;
import dev.kiadev.learnlibrary.util.DbConnectionManager;
import dev.kiadev.learnlibrary.model.Author;
import dev.kiadev.learnlibrary.model.Book;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();

    private AuthorDao authorDao;
    private BookDao bookDao;

    public LibraryService() {}

    public LibraryService(DbConnectionManager dbConnection) {
        authorDao = new AuthorDao(dbConnection);
        bookDao = new BookDao(dbConnection);
    }

    public void addBook(String title, Integer author_id) {
        Author author = findAuthorById(author_id);
        Book book = new Book(title, author);
        books.add(book);
        bookDao.create(book);
    }

    public Book findBookByTitle(String title) {
        books = bookDao.findAll();
        return books.stream()
                .filter(book -> book.getTitle().equals(title))
                .findFirst()
                .orElse(null); // Возвращаем null, если книга не найдена
    }

    public Author addAuthor(String name) {
        Author author = new Author(name);
        authors.add(author);
        authorDao.create(author);
        return author;
    }

    public Author findAuthorByName(String name) {
        authors = authorDao.findAll();
        return authors.stream()
                .filter(author -> author.getName().equals(name))
                .findFirst()
                .orElse(null); // Возвращаем null, если автор не найден
    }

    public Author findAuthorById(Integer id) {
        authors = authorDao.findAll();
        return authors.stream()
                .filter(author -> author.getId().equals(id))
                .findFirst()
                .orElse(null); // Возвращаем null, если автор не найден
    }

    public Book findBookById(Integer id) {
        books = bookDao.findAll();
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null); // Возвращаем null, если книга не найдена
    }

    // Методы для тестирования
    public List<Book> findAllBooks() {
        books = bookDao.findAll();
        return books;
    }

    public List<Author> findAllAuthors() {
        authors = authorDao.findAll();
        return authors;
    }
}
