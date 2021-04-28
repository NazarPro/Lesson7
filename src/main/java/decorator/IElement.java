package decorator;

import org.openqa.selenium.*;

import java.util.List;

public interface IElement {

    void click();

    void submit();

    void sendKeys(CharSequence... keysToSend);

    void clear();

    String getTagName();

    String getAttribute(String name);

    boolean isSelected();

    boolean isEnabled();

    String getText();

    List<WebElement> findElements(By by);

    WebElement findElement(By by);

    boolean isDisplayed();

    Point getLocation();

    Dimension getSize();

    Rectangle getRect();

    String getCssValue(String propertyName);

    <X> X getScreenshotAs(OutputType<X> target);

}