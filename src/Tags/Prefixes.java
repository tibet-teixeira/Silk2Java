package Tags;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import java.util.ArrayList;

public class Prefixes {

    private ArrayList<Prefix> listPrefixes;

    public Prefixes (Document doc) {
        NodeList prefixesList = doc.getElementsByTagName("Prefixes");
        Element eElement = (Element) prefixesList.item(0);

        this.listPrefixes = new ArrayList<>();

        NodeList prefixList = eElement.getElementsByTagName("Prefix");

        for (int index = 0; index < prefixList.getLength(); index++) {
            listPrefixes.add(new Prefix((Element) prefixList.item(index)));
        }
    }

    public ArrayList<Prefix> getPrefixes () {
        return this.listPrefixes;
    }
}
