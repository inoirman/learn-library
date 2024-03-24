package dev.kiadev.learnlibrary.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionManager {
    private String url = "jdbc:postgresql://localhost:5432/learn_library";
    private String user = "kiadev";
    private String password = "secret";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
