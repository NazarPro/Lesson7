import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {

    @FindBy(xpath="//div[@class='aic']//descendant::*[@role='button']")
    private WebElement composeMailButton;

    @FindBy(name = "to")
    private WebElement recipientsEmailAddress;

    @FindBy (css = "input.aoT[name='subjectbox']")
    private WebElement subjectTextField;

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement messageTextTextField;

    @FindBy(xpath = "//div[@role='button' and contains(@aria-label,'(Ctrl –Enter)')]")
    private WebElement sendLetterButton;

    @FindBy(xpath = "//div[@role='alert' and @aria-atomic='true']")
    private WebElement popupAlertMessageSent;

    @FindBy(xpath = "//a[contains(@href, '#sent')]")
    private WebElement sentLettersSideMenuItem;

    public HomePage(WebDriver driver) {super(driver);
    }

    public void clickComposeMailButton(){composeMailButton.click();}

    public void fillInRecipientEmail(String recipient){
        recipientsEmailAddress.clear();
        recipientsEmailAddress.sendKeys(recipient);
     }

    public void fillInMessageSubjectText(String subject){
        subjectTextField.clear();
        subjectTextField.sendKeys(subject);

    }
    public void fillInMessageText(String messageText){
        messageTextTextField.clear();
        messageTextTextField.sendKeys(messageText);
    }
    public void clickSendMessage(){ sendLetterButton.click(); }
     public WebElement getPopupAlertMessageSent(){return popupAlertMessageSent;}

    public void clickSentLettersSideMenuItem(){sentLettersSideMenuItem.click();}

}
