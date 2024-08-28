package erp.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    private Properties properties = new Properties();

    public ConfigLoader() {
        try {
            properties.load(new FileReader("config.properties"));
        } catch (IOException e) {
            System.out.println("Error loading configuration.");
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
