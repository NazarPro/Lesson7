package decorator.impl;

import decorator.AbstractElement;
import org.openqa.selenium.WebElement;

public class Label extends AbstractElement {

    public Label(WebElement element) {
        super(element);
    }

    public String getUserNameFromEmailAddress() {
        return element.getText().substring(0, element.getText().indexOf('@'));
    }

    public String getTextPlusGmailDomain() {
        return element.getText() + "@gmail.com";
    }
}
