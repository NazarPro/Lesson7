import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {
    private PropertiesFile() {throw new IllegalStateException("Utility class");}

    public static String getPropertyValue() throws IOException {
        Properties properties = new Properties();
        try(InputStream stream = new FileInputStream("settings.properties"))
            {
                properties.load(stream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return properties.getProperty("timeout");
    }
}