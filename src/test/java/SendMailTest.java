import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class SendMailTest extends BaseTest{

    File xmlFile = new File("userdata.xml");
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(xmlFile);
    NodeList nList = doc.getChildNodes();
    Node nXml = nList.item(0);
    Element element = (Element)nXml;

    final String LOGIN = element.getElementsByTagName("login").item(0).getTextContent();
    final String PWD = element.getElementsByTagName("password").item(0).getTextContent();
    final String RECIPIENT = element.getElementsByTagName("recipientEmail").item(0).getTextContent();
    final String SUBJECT =element.getElementsByTagName("subject").item(0).getTextContent();
    final String LETTER_TEXT = element.getElementsByTagName("letterText").item(0).getTextContent();

    String timeOut = PropertiesFile.getPropertyValue();
    final int TIMEOUT = Integer.parseInt(timeOut);

    public SendMailTest() throws ParserConfigurationException, IOException, SAXException {
    }

    @Test
    public void testSendMailFromActiveAccountCheckInSentDeleteLetter(){

        getLoginPage().submitLogin(LOGIN);
        getLoginPage().submitPassword(PWD);
        getHomePage().clickComposeMailButton();
        getHomePage().fillInComposeLetterFormAndSendLetter(RECIPIENT, SUBJECT, LETTER_TEXT);
        getHomePage().waitInvisibilityOfElement(TIMEOUT, getHomePage().getPopupAlertMessageSent());
        getHomePage().clickSentLettersSideMenuItem();
        getSentPage().clickFirstLetterOfTheListOfLettersOnPage();
        Assert.assertEquals(RECIPIENT.substring(0,10), getSentPage().getRecipientsEmailAddress());
        Assert.assertEquals(SUBJECT, getSentPage().getLetterSubject());
        Assert.assertEquals(LETTER_TEXT, getSentPage().getLetterText());
        getSentPage().clickDeleteCurrentMessageButton();
    }
}
