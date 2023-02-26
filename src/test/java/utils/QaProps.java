// This is a package named "utils".
package utils;
// This is importing classes from the java.io and java.util packages.
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
// This is a public class named "QaProps".
public class QaProps {
    // This is a private static Properties object named "properties".
    private static Properties properties;

    // This is a private constructor.
    private QaProps() {
    }
    // This is a public static method named "init".
    public static void init() {

        // If properties is null...
        if (properties == null) {
            // Initialize properties.
            properties = new Properties();
// Try to load properties from a file.
            try {
                properties.load(new FileInputStream("src/test/resources/env.properties"));
            } catch (IOException var1) {
                // If there's an exception, throw a RuntimeException.
                throw new RuntimeException(var1);
            }
        }

    }
    // This is a public static method named "getValue" that returns a String
    public static String getValue(String key) {
        // Call the init method.
        init();
        // Return the value of the specified key.
        return properties.getProperty(key);
    }
}