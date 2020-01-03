import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class MySQLConnector {
    private final static Logger LOGGER = Logger.getLogger(MySQLConnector.class.getName());

    public Connection create(String username, String password, String dbname, String hostname) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s/%s?user=%s&password=%s", hostname, dbname, username, password));

        } catch (
                SQLException ex) {
            // handle any errors
            LOGGER.severe(String.format("SQLException: %s", ex.getMessage()));
            LOGGER.severe(String.format("SQLState: %s", ex.getSQLState()));
            LOGGER.severe(String.format("VendorError: %s", ex.getErrorCode()));
        }

        return connection;
    }

}
