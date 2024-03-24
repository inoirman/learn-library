package dev.kiadev.learnlibrary.dao;

import dev.kiadev.learnlibrary.model.Author;
import dev.kiadev.learnlibrary.util.DbConnectionManager;
import dev.kiadev.learnlibrary.model.Book;


import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private DbConnectionManager dbConnection;

    public BookDao(DbConnectionManager dbConnection) {
        this.dbConnection = dbConnection;
    }

    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        String SQL = "SELECT b.*, a.* FROM books b INNER JOIN authors a ON b.author_id = a.id";

        try (
                Connection conn = dbConnection.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SQL);
        ) {
            while (rs.next()) {
                Author author = new Author(rs.getInt("author_id"), rs.getString("name"));


                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(author);
                books.add(book);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return books;
    }

    public Book create(Book book) {
        String SQL = "INSERT INTO books (title, author_id) VALUES (?,?) RETURNING id;";

        try (
                Connection conn = dbConnection.connect();
                PreparedStatement statement = conn.prepareStatement(SQL)) {

            statement.setString(1, book.getTitle());
            statement.setLong(2, book.getAuthor().getId());
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                book.setId(rs.getInt("id"));
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return book;
    }
}