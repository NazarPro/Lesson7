package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SentPage extends BasePage {

    @FindBy(xpath = "//tr[@class='zA yO']")
    private List<WebElement> listOfLettersOnPage;

    @FindBy(xpath = "//span[@class='g2']")
    private WebElement recipientsEmailAddress;

    @FindBy(xpath = "//h2[@class='hP']")
    private WebElement letterSubject;

    @FindBy(xpath = "//div[@class='a3s aiL ']/div[@dir='ltr']")
    private WebElement letterText;

    @FindBy(xpath = "//div[@id=':4']//div[@jslog='20283; u014N:cOuCgd,Kr2w4b']")
    private WebElement deleteCurrentMessageButton;


    public void clickFirstLetterOfTheListOfLettersOnPage(){
        listOfLettersOnPage.get(0).click();
    }

    public String getRecipientsEmailAddress(){
        return recipientsEmailAddress.getText() + "@gmail.com";
    }

    public String getLetterSubject(){
        return letterSubject.getText();
    }

    public String getLetterText(){
        return letterText.getText();
    }

    public void clickDeleteCurrentMessageButton() { deleteCurrentMessageButton.click(); }

    public WebElement getDeleteCurrentMessageButton() { return deleteCurrentMessageButton; }
}
