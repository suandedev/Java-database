package mds.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementOracleTest {
    @Test
    void testCreateStatement() throws SQLException {
        Connection connection = ConnectionUtilOracle.getDataSourceOracle().getConnection();

        Statement statement = connection.createStatement();

        statement.close();

        connection.close();
    }

    @Test
    void testExecuteUpdate() throws SQLException {
        Connection connection = ConnectionUtilOracle.getDataSourceOracle().getConnection();
        Statement statement = connection.createStatement();

        String sql = """
                INSERT INTO customers(id, name, email)
                VALUES ('Made3', 'Made', 'Made2@gmail.com')
                """;
        int update = statement.executeUpdate(sql);
        System.out.println("Success "+ update);
        statement.close();
        connection.close();
    }

    @Test
    void testExecuteDelete() throws SQLException {
        Connection connection = ConnectionUtilOracle.getDataSourceOracle().getConnection();
        Statement statement = connection.createStatement();

        String sql = """
                DELETE FROM customers WHERE email='Made2@gmail.com'
                """;
        int update = statement.executeUpdate(sql);
        System.out.println("Success "+ update);
        statement.close();
        connection.close();
    }

    @Test
    void testExecuteQuery() throws SQLException {
        Connection connection = ConnectionUtilOracle.getDataSourceOracle().getConnection();
        Statement statement = connection.createStatement();

        String sql = """
                SELECT * FROM customers
                """;
        ResultSet result = statement.executeQuery(sql);
        System.out.println(result);
        statement.close();
        connection.close();
    }
}
