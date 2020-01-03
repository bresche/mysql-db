import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

public class App {
    private final static Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            LOGGER.severe(String.format("driver class not found: %s", ex.getMessage()));
        }

        Connection connection = new MySQLConnector().create("user","pw","db","host");

        try {
            connection.nativeSQL("SELECT version()");
        } catch (SQLException e) {
            LOGGER.severe(String.format("Error while test connection :%s", e.getMessage()));
        }

    }
}
