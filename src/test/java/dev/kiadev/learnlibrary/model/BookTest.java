package dev.kiadev.learnlibrary.model;

import dev.kiadev.learnlibrary.service.LibraryService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    void bookCreationAndAccessorsTest() {
        Author author = new Author(1L, "John Doe");
        Book book = new Book(1L, "Book Title", author, true);

        assertEquals(1L, book.getId());
        assertEquals("Book Title", book.getTitle());
        assertEquals(author, book.getAuthor());
        assertTrue(book.isAvailable());

        book.setAvailable(false);
        assertFalse(book.isAvailable());
    }

    @Test
    void testAddBook() {
        LibraryService service = new LibraryService();
        Author author = new Author(1L, "John Doe");
        Book book = new Book(1L, "Book Title", author, true);

        service.addBook(book);
        assertTrue(service.findAllBooks().contains(book));
    }

    @Test
    void testFindBookByTitle() {
        LibraryService service = new LibraryService();
        Author author = new Author(1L, "John Doe");
        Book book = new Book(1L, "Book Title", author, true);

        service.addBook(book);
        assertEquals(book, service.findBookByTitle("Book Title"));
    }
}