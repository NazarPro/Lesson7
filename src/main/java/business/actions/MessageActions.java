package business.actions;
import pages.HomePage;
import pages.SentPage;
import utilities.PropertiesFileReader;


public class MessageActions {
    int timeOut = Integer.parseInt(PropertiesFileReader.getTimeoutPropertyValue());

    private final HomePage homePage = new HomePage();
    private final SentPage sentPage = new SentPage();

    public void composeAndSendMail(String recipientEmail, String subject, String messageText) {
        homePage.clickComposeMailButton();
        homePage.fillInRecipientEmail(recipientEmail);
        homePage.fillInMessageSubjectText(subject);
        homePage.fillInMessageText(messageText);
        homePage.clickSendMessage();
    }

    public void navigateToSentMailPage() {
        homePage.waitInvisibilityOfElement(timeOut, homePage.getPopupAlertMessageSent());
        homePage.clickSentLettersSideMenuItem();
    }

    public void openLastSentMail() {
        sentPage.clickFirstLetterOfTheListOfLettersOnPage();
        sentPage.waitForPageLoadComplete(timeOut);
    }

    public void deleteCurrentOpenedMail() {
        sentPage.clickDeleteCurrentMessageButton();
        sentPage.waitInvisibilityOfElement(timeOut, sentPage.getDeleteCurrentMessageButton());
    }
}
