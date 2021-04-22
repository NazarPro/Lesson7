import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SendMailTest extends BaseTest {
    String timeOut = PropertiesFileReader.getTimeoutPropertyValue();
    final int TIMEOUT = Integer.parseInt(timeOut);

    @DataProvider(name="users", parallel = true)
    public Object[][] getUsers(){
        return DataFileReader.getUerData();
    }

    @Test (dataProvider="users")
    public void testSendMailFromActiveAccountCheckInSentDeleteLetter(String login, String password,
                                                                     String recipientEmail, String subject,
                                                                     String messageText){

        getLoginPage().submitLogin(login);
        getLoginPage().submitPassword(password);
        getHomePage().clickComposeMailButton();
        getHomePage().fillInRecipientEmail(recipientEmail);
        getHomePage().fillInMessageSubjectText(subject);
        getHomePage().fillInMessageText(messageText);
        getHomePage().clickSendMessage();
        getHomePage().waitInvisibilityOfElement(TIMEOUT, getHomePage().getPopupAlertMessageSent());
        getHomePage().clickSentLettersSideMenuItem();
        getSentPage().clickFirstLetterOfTheListOfLettersOnPage();
        getSentPage().waitForPageLoadComplete(TIMEOUT);
        Assert.assertEquals(recipientEmail, getSentPage().getRecipientsEmailAddress());
        Assert.assertEquals(subject, getSentPage().getLetterSubject());
        Assert.assertEquals(messageText, getSentPage().getLetterText());
        getSentPage().clickDeleteCurrentMessageButton();
        getSentPage().waitInvisibilityOfElement(TIMEOUT, getSentPage().getDeleteCurrentMessageButton());
    }
}
