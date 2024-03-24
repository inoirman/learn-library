package dev.kiadev.learnlibrary.model;

import dev.kiadev.learnlibrary.service.LibraryService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthorTest {
    @Test
    void authorCreationTest() {
        Author author = new Author(1L, "John Doe");
        assertEquals(1L, author.getId());
        assertEquals("John Doe", author.getName());
    }

    @Test
    void authorCreationAndBookManagementTest() {
        Author author = new Author(1L, "John Doe");
        Book book = new Book(1L, "Book Title", author, true);

        author.addBook(book);

        assertEquals(1, author.getBooks().size());
        assertTrue(author.getBooks().contains(book));
    }

    @Test
    void testAddAuthor() {
        LibraryService service = new LibraryService();
        Author author = new Author(1L, "John Doe");

        service.addAuthor(author);
        assertTrue(service.findAllAuthors().contains(author));
    }

    @Test
    void testFindAuthorByName() {
        LibraryService service = new LibraryService();
        Author author = new Author(1L, "John Doe");

        service.addAuthor(author);
        assertEquals(author, service.findAuthorByName("John Doe"));
    }
}
