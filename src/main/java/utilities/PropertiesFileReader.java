package utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileReader {
    private PropertiesFileReader() { throw new IllegalStateException("Utility class"); }

    public static String getTimeoutPropertyValue() {
        Properties properties = new Properties();
        try(InputStream stream = new FileInputStream("settings.properties"))
            {
                properties.load(stream);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("timeout");
    }
}