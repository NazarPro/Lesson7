import org.testng.Assert;
import org.testng.annotations.DataProvider;
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
    String timeOut = PropertiesFile.getPropertyValue();
    final int TIMEOUT = Integer.parseInt(timeOut);

    public SendMailTest() throws IOException {
    }

    @DataProvider(name="users", parallel = true)
    public Object[][] getUsers() throws ParserConfigurationException, IOException, SAXException {
        File xmlFile = new File("userdata.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        NodeList nList = doc.getElementsByTagName("user");

        Object[][] users = new Object[nList.getLength()][5];

        for(int i = 0; i < nList.getLength(); i++){
                Node nNode = nList.item(i);
                Element element = (Element) nNode;
                users[i][0] = element.getElementsByTagName("login").item(0).getTextContent();
                users[i][1] = element.getElementsByTagName("password").item(0).getTextContent();
                users[i][2] = element.getElementsByTagName("recipientEmail").item(0).getTextContent();
                users[i][3] = element.getElementsByTagName("subject").item(0).getTextContent();
                users[i][4] = element.getElementsByTagName("letterText").item(0).getTextContent();
        }
        return users;
    }

    @Test (dataProvider="users")
    public void testSendMailFromActiveAccountCheckInSentDeleteLetter(String login, String password,
                                                                     String recipientEmail, String subject,
                                                                     String letterText){

        getLoginPage().submitLogin(login);
        getLoginPage().submitPassword(password);
        getHomePage().clickComposeMailButton();
        getHomePage().fillInComposeLetterFormAndSendLetter(recipientEmail, subject, letterText);
        getHomePage().waitInvisibilityOfElement(TIMEOUT, getHomePage().getPopupAlertMessageSent());
        getHomePage().clickSentLettersSideMenuItem();
        getSentPage().clickFirstLetterOfTheListOfLettersOnPage();
        Assert.assertEquals(recipientEmail.substring(0,15), getSentPage().getRecipientsEmailAddress());
        Assert.assertEquals(subject, getSentPage().getLetterSubject());
        Assert.assertEquals(letterText, getSentPage().getLetterText());
        getSentPage().clickDeleteCurrentMessageButton();
    }
}
