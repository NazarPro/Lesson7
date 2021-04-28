package decorator.impl;

import decorator.AbstractElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TextInputBox extends AbstractElement {

    public TextInputBox(WebElement element) {
        super(element);
    }

    public void clearAndSendKeys(CharSequence... keysToSend) {
        element.clear();
        element.sendKeys(keysToSend);
    }

    public void clearSendKeysClickEnter(CharSequence... keysToSend) {
        element.clear();
        element.sendKeys(keysToSend);
        element.sendKeys(Keys.ENTER);
    }
}
