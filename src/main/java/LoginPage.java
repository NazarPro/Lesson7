import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(tagName="input")
    private WebElement inputLoginTextField;

    @FindBy(xpath="//div[@id='password']//input[@name='password']")
    private WebElement inputPasswordTextField;

    public LoginPage(WebDriver driver) {super(driver);
    }

    public void submitLogin(String login) {
        inputLoginTextField.clear();
        inputLoginTextField.sendKeys(login, Keys.ENTER);
    }

    public void submitPassword(String password) {
        inputPasswordTextField.clear();
        inputPasswordTextField.sendKeys(password, Keys.ENTER);
    }

}
