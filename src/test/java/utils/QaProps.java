// This code is a Java class that reads properties from a properties file.

// Importing required libraries
package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class QaProps {
    // Declaring required class level variables
    private static Properties properties;

    private QaProps() {
        // Private constructor to prevent instantiation
    }

    public static void init() {
        if (properties == null) {
            // Private constructor to prevent instantiation
            properties = new Properties();
            // Initializing the properties


            try {
                properties.load(new FileInputStream("src/test/resources/env.properties"));
            } catch (IOException var1) {
                throw new RuntimeException(var1);
            }
        }

    }

    public static String getValue(String key) {
        init();
        return properties.getProperty(key);
    }
}