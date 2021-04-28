package pages;
import decorator.impl.TextInputBox;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public void submitLogin(String login) {
        var inputLoginTextInput = new TextInputBox(driver.findElement(By.xpath("//input[@id='identifierId']")));
        inputLoginTextInput.clearSendKeysClickEnter(login);
    }

    public void submitPassword(String password) {
        var inputPasswordTextInput = new TextInputBox(driver.findElement(By
                .xpath("//div[@id='password']//input[@name='password']")));
        inputPasswordTextInput.clearSendKeysClickEnter(password);
    }
}

