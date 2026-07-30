package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            // Используем ClassLoader для поиска файла в classpath (работает и в IDEA, и в Jenkins)
            InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");

            if (input == null) {
                throw new RuntimeException("config.properties not found in classpath!");
            }

            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Not able to load the file config.properties!");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}