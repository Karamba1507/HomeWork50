package com.example.microgram.homework51;

import freemarker.core.Environment;
import lombok.Getter;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
@Getter
@PropertySource("application.properties")
public class DataBaseConnect {
    private Connection connection;
    //private Environment environment;

    public DataBaseConnect() {
        try {
            init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getNewConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=qwerty";
        return DriverManager.getConnection(url);
    }

    private void init() throws SQLException {
        connection = getNewConnection();
    }

    private void close() throws SQLException {
        connection.close();
    }

    public String openConnection() {
        try {
            init();
            return "Connecting to the DB";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}
