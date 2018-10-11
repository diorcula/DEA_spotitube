package nl.han.ica.dea.fedor.datasources.Properties;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseProperties {
    private Logger logger = Logger.getLogger(getClass().getName());
    private Properties properties;

    public DatabaseProperties() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("database.properties"));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Can't access property file database.properties", e);
        }
    }

    public String driver() {
        return properties.getProperty("driver");
    }

    public String connectionURL() {
        return properties.getProperty("connectionURL");
    }
    public String connectionUSER(){
        return properties.getProperty("user");
    }
    public String connectionPASS(){
        return properties.getProperty("pass");
    }
}
