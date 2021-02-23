package nl.han.ica.dea.fedor.dao.Properties;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Database properties.
 */
public class DatabaseProperties {
    private Logger logger = Logger.getLogger(getClass().getName());
    private Properties properties;

    /**
     * Instantiates a new Database properties.
     */
    public DatabaseProperties() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("database.properties"));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Can't access property file database.properties", e);
        }
    }

    /**
     * Driver string.
     *
     * @return the string
     */
    public String driver() {
        return properties.getProperty("driver");
    }

    /**
     * Connection url string.
     *
     * @return the string
     */
    public String connectionURL() {
        return properties.getProperty("connectionURL");
    }

    /**
     * Connection user string.
     *
     * @return the string
     */
    public String connectionUSER(){
        return properties.getProperty("user");
    }

    /**
     * Connection pass string.
     *
     * @return the string
     */
    public String connectionPASS(){
        return properties.getProperty("pass");
    }
}
