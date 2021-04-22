import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Objects;

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DriverManager {
    static String timeOut;

    static {
        timeOut = PropertiesFileReader.getTimeoutPropertyValue();
    }

    final static int TIMEOUT = Integer.parseInt(timeOut);

    private static final ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (Objects.isNull(driverPool.get())) {
            chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
            driverPool.set(driver);
        }
        return driverPool.get();
    }

    public static void closeDriver(){
        driverPool.get().quit();
        driverPool.set(null);
    }
}
