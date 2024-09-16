package mds.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolOracleTest {
    @Test
    void testHikariCP() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("oracle.jdbc.OracleDriver");
        config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/eis");
        config.setUsername("dbuser");
        config.setPassword("dbuser");

        config.setMaximumPoolSize(10);
        config.getMinimumIdle();
        config.setIdleTimeout(60_000);
        config.setMaxLifetime(10 * 60_000);

        try {
            HikariDataSource dataSource = new HikariDataSource(config);
            Connection connection = dataSource.getConnection();
            connection.close();
            dataSource.close();
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }
    }

    @Test
    void testUtil() throws SQLException {
        Connection connection = ConnectionUtilOracle.getDataSourceOracle().getConnection();
    }
}
