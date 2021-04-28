package business.asserts;
import org.testng.Assert;
import pages.SentPage;

public class MessageAssert {
    private final SentPage sentPage = new SentPage();

    public void assertSentMailIsCorrect(String recipientEmail, String subject, String messageText) {
        Assert.assertEquals(recipientEmail, sentPage.getRecipientsEmailAddressLabel());
        Assert.assertEquals(subject, sentPage.getLetterSubjectLabel());
        Assert.assertEquals(messageText, sentPage.getLetterText());
    }
}
