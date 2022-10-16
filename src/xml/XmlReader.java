package xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/** INSTRUCTIONS
 * This XML Reader class is used to parse the XML documents contained within this package. You must also implement the
 * given method at the bottom of the class.
 *
 * If you don't know what XML is... Look it up! You can expect to see a lot of XML very soon
 */

public class XmlReader {

    public List<Student> parseData(String tagName, String path) throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File file = new File(path);

        Document doc = builder.parse(file);
        NodeList nodeList = doc.getDocumentElement().getChildNodes();

        List<Student> list = new ArrayList<>();
        Student student;
        Node node;
        Node cNode;
        NodeList childNodes;
        String content;
        String data;

        for (int i = 0; i < nodeList.getLength(); i++) {
            node = nodeList.item(i);
            if (node instanceof Element) {
                student = new Student();
                student.id = node.getAttributes().getNamedItem(tagName).getNodeValue();
                childNodes = node.getChildNodes();

                for (int j = 0; j < childNodes.getLength(); j++) {
                    cNode = childNodes.item(j);
                    if (cNode instanceof Element) {
                        content = cNode.getLastChild().getTextContent().trim();
                        data = cNode.getNodeName();
                        switch (data) {
                            case "firstName":
                                student.firstName = content;
                                break;
                            case "lastName":
                                student.lastName = content;
                                break;
                            case "score":
                                student.score = convertIntToChar(content);
                                break;
                        }
                    }
                }
                list.add(student);
            }
        }
        return list;
    }

    // You must implement this method
    public char convertIntToChar(String score) {
        char grade = ' ';

        // we use a switch statement to convert the grades
        switch (score) {
            case "90":case "91": case "92": case "93":case "94":case "95":case "96":case "97":case "98":case "99":case "100":
                return 'A';
            case "80":case "81": case "82": case "83":case "84":case "85":case "86":case "87":case "88":case "89":
                return 'B';
            case "70":case "71": case "72": case "73":case "74":case "75":case "76":case "77":case "78":case "79":
                return 'C';
        }


        return grade;
    }

}
