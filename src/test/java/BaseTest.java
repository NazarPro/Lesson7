import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utilities.DriverManager;

public class BaseTest {
    Logger log;
    WebDriver driver;
    private static final String GMAIL_LOGIN_URL = "https://accounts.google.com/signin/v2/identifier?continue=https%3" +
            "A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

    @BeforeTest
    public void setup() {
        DOMConfigurator.configure("log4j.xml");
        log = Logger.getLogger(SendMailTest.class.getName());
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = DriverManager.getDriver();
        driver.get(GMAIL_LOGIN_URL);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.closeDriver();
    }
}
