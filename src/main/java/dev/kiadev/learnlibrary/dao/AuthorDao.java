package dev.kiadev.learnlibrary.dao;

import dev.kiadev.learnlibrary.util.DbConnectionManager;
import dev.kiadev.learnlibrary.model.Author;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao {
    private DbConnectionManager dbConnection;

    public AuthorDao(DbConnectionManager dbConnection) {
        this.dbConnection = dbConnection;
    }

    public List<Author> findAll() {
        List<Author> authors = new ArrayList<>();
        String SQL = "SELECT id, name FROM authors";

        try (
                Connection conn = dbConnection.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SQL);
        ) {
            while (rs.next()) {
                Author author = new Author();
                author.setId(rs.getInt("id"));
                author.setName(rs.getString("name"));
                authors.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    public Author create(Author author) {
        String SQL = "INSERT INTO authors (name) VALUES (?) RETURNING id;";

        try (
                Connection conn = dbConnection.connect();
                PreparedStatement statement = conn.prepareStatement(SQL)) {

            statement.setString(1, author.getName());
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                author.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return author;
    }
}