import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {


    WebDriver driver;
    private static final String GMAIL_LOGIN_URL = "https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

    @BeforeMethod
    public void testsSetUp() {
        driver = DriverManager.getDriver();
        driver.get(GMAIL_LOGIN_URL);
    }

    public HomePage getHomePage() {return new HomePage(DriverManager.getDriver());}
    public LoginPage getLoginPage() {return new LoginPage(DriverManager.getDriver());}
    public SentPage getSentPage() {return new SentPage(DriverManager.getDriver());}



    @AfterMethod
    public void tearDown() {
        DriverManager.closeDriver();
    }
}
