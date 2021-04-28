import business.actions.LoginActions;
import business.actions.MessageActions;
import business.asserts.MessageAssert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SendMailTest extends BaseTest {

    @DataProvider(name="users", parallel = true)
    public Object[][] getUsers(){
        return DataFileReader.getUerData();
    }

    @Test (dataProvider="users")
    public void testSendMailFromActiveAccount(String login, String password,
                                                                     String recipientEmail, String subject,
                                                                     String messageText) {
        LoginActions loginActions = new LoginActions();
        MessageActions messageActions = new MessageActions();
        MessageAssert messageAssert = new MessageAssert();

        loginActions.loginEmailAccount(login, password);
        log.info("Successful login to account [[[" + login + "]]]");

        messageActions.composeAndSendMail(recipientEmail, subject, messageText);
        messageActions.navigateToSentMailPage();
        messageActions.openLastSentMail();
        log.info("Mail composed by user [[[" + login + "]]] and sent");

        messageAssert.assertSentMailIsCorrect(recipientEmail, subject, messageText);
        log.info("Sent mail by user [[[" + login + "]]] found in Sent section");

        messageActions.deleteCurrentOpenedMail();
        log.info("Sent message by user [[[" + login + "]]] was deleted");
    }
}
