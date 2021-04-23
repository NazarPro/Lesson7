package utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DriverManager {
    static final int TIME_OUT = Integer.parseInt(PropertiesFileReader.getTimeoutPropertyValue());
    private static final ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    private DriverManager() {}

    public static WebDriver getDriver() {
        if (Objects.isNull(driverPool.get())) {
            chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(TIME_OUT, TimeUnit.SECONDS);
            driverPool.set(driver);
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        driverPool.get().quit();
        driverPool.remove();
    }
}
