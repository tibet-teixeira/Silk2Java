package Tags;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class Interlinks {

    private ArrayList<Interlink> listInterlinks;

    public Interlinks (Document doc) {
        NodeList interlinksList = doc.getElementsByTagName("Interlinks");
        Element eElement = (Element) interlinksList.item(0);

        this.listInterlinks = new ArrayList<>();
        NodeList interlinkList = eElement.getElementsByTagName("Interlink");

        for (int index = 0; index < interlinkList.getLength(); index++) {
            listInterlinks.add(new Interlink((Element) interlinkList.item(index)));
        }
    }

    public ArrayList<Interlink> getInterlinks() {
        return this.listInterlinks;
    }
}
