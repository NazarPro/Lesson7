package pages;
import decorator.impl.Button;
import decorator.impl.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SentPage extends BasePage {

    @FindBy(xpath = "//tr[@class='zA yO']")
    protected List<WebElement> listOfLettersOnPage;

    public void clickFirstLetterOfTheListOfLettersOnPage() {
        listOfLettersOnPage.get(0).click();
    }

    public String getRecipientsEmailAddressLabel() {
        var recipientsEmailAddressLabel = new Label(driver.findElement(By.xpath("//span[@class='g2']")));
        return recipientsEmailAddressLabel.getTextPlusGmailDomain();
    }

    public String getLetterSubjectLabel() {
        var letterSubjectLabel = new Label(driver.findElement(By.xpath("//h2[@class='hP']")));
        return letterSubjectLabel.getText();
    }

    public String getLetterText() {
        var letterText = new Label(driver.findElement(By.xpath("//div[@class='a3s aiL ']/div[@dir='ltr']")));
        return letterText.getText();
    }

    public void clickDeleteCurrentMessageButton() {
        var deleteCurrentMessageButton = new Button(driver.findElement(By
                .xpath("//div[@id=':4']//div[@jslog='20283; u014N:cOuCgd,Kr2w4b']")));
        deleteCurrentMessageButton.clickIfElementIsDisplayed();
    }
}
