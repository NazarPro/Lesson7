import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{

    @FindBy(xpath="//div[@class='aic']//descendant::*[@role='button']")
    private WebElement composeMailButton;

    @FindBy(name = "to")
    private WebElement recipientsEmailAddress;

    @FindBy (css = "input.aoT[name='subjectbox']")
    private WebElement subjectTextField;

    @FindBy(xpath = "//div[@aria-label='Текст повідомлення']")
    private WebElement messageTextTextField;

    @FindBy(xpath = "//div[@class='dC']/div[contains(@aria-label, 'Надіслати')]")
    private WebElement sendLetterButton;

    @FindBy(xpath = "//div[@role='alert' and @aria-atomic='true']")
    private WebElement popupAlertMessageSent;

    @FindBy(xpath = "//a[contains(@href, '#sent')]")
    private WebElement sentLettersSideMenuItem;

    public HomePage(WebDriver driver) {super(driver);
    }

    public WebElement getComposeMailButton(){return composeMailButton;}
    public void clickComposeMailButton(){composeMailButton.click();}

    public WebElement getRecipientsEmailAddress(){return recipientsEmailAddress;}

    public void fillInComposeLetterFormAndSendLetter(String recipient, String subject, String messageText){
        recipientsEmailAddress.clear();
        recipientsEmailAddress.sendKeys(recipient);
        subjectTextField.clear();
        subjectTextField.sendKeys(subject);
        messageTextTextField.clear();
        messageTextTextField.sendKeys(messageText);
        sendLetterButton.click();
     }

     public WebElement getPopupAlertMessageSent(){return popupAlertMessageSent;}

    public void clickSentLettersSideMenuItem(){sentLettersSideMenuItem.click();}

}
