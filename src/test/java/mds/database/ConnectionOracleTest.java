package mds.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionOracleTest {

    @BeforeAll
    static void beforeAll() {
        try {
            Driver mysqlDriver = new oracle.jdbc.OracleDriver();
            DriverManager.registerDriver(mysqlDriver);
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }
    }

    @Test
    void testConnection() {
        String jdbcurl = "jdbc:oracle:thin:@localhost:1521/eis";
        String username = "dbuser";
        String password = "dbuser";
        try {
            Connection connection = DriverManager.getConnection(jdbcurl, username, password);
            System.out.println("Sukses connect database");
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }
    }

    @Test
    void testConnectionClose() {
        String jdbcurl = "jdbc:oracle:thin:@localhost:1521/eis";
        String username = "dbuser";
        String password = "dbuser";
        try {
            Connection connection = DriverManager.getConnection(jdbcurl, username, password);
            System.out.println("Sukses connect database");
            connection.close();
            System.out.println("Sukses close database");
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }
    }
}

