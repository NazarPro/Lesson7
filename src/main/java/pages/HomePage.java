package pages;
import decorator.impl.Button;
import decorator.impl.TextInputBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@role='alert' and @aria-atomic='true']")
    private WebElement popupAlertMessageSent;

    @FindBy(xpath = "//a[contains(@href, '#sent')]")
    private WebElement sentLettersSideMenuItem;

    public void clickComposeMailButton() {
        var composeMailButton = new Button(driver.findElement(By
                .xpath("//div[@class='aic']//descendant::*[@role='button']")));
        composeMailButton.clickIfElementIsEnabled();
    }

    public void fillInRecipientEmail(String recipient) {
        var recipientsEmailAddressTextInput = new TextInputBox(driver.findElement(By.name("to")));
        recipientsEmailAddressTextInput.clearAndSendKeys(recipient);
     }

    public void fillInMessageSubjectText(String subject) {
        var subjectTextInput = new TextInputBox(driver.findElement(By.cssSelector("input.aoT[name='subjectbox']")));
        subjectTextInput.clearAndSendKeys(subject);
    }

    public void fillInMessageText(String messageText) {
        var messageTextTextInput = new TextInputBox(driver.findElement(By.xpath("//div[@role='textbox']")));
        messageTextTextInput.clearAndSendKeys(messageText);
    }

    public void clickSendMessage() {
        var sendLetterButton = new Button(driver.findElement(By
                .xpath("//div[@role='button' and contains(@aria-label,'(Ctrl –Enter)')]")));
        sendLetterButton.click();
    }

    public WebElement getPopupAlertMessageSent() {
        return popupAlertMessageSent;
    }

    public void clickSentLettersSideMenuItem() {
        sentLettersSideMenuItem.click();
    }
}
