package utilities;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;


public class DataFileReader {
    private DataFileReader() {}

    public static Object[][] getUerData() {
        File xmlFile = new File("userdata.xml");
        DocumentBuilderFactory dbFactory;
        dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = null;
        try {
            assert dBuilder != null;
            doc = dBuilder.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert doc != null;
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
}
