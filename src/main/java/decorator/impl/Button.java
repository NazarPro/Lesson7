package decorator.impl;
import decorator.AbstractElement;
import org.openqa.selenium.WebElement;

public class Button extends AbstractElement {

    public Button(WebElement element) {
        super(element);
    }

    public void clickIfElementIsDisplayed() {
        if(element.isDisplayed()) {
            element.click();
        }
    }

    public void clickIfElementIsEnabled() {
        if(element.isEnabled()) {
            element.click();
        }
    }
}

