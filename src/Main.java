import Read.ReadXMLFile;
import Tags.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class Main {
    public static void main (String argv[]) {

        try {
            String pathname = "linkSpec.xml";

            Document xml = new ReadXMLFile(pathname).getDocument();

            xml.getDocumentElement().normalize();

            Element rootNode = (Element) xml.getChildNodes().item(0); // get Root node
            ArrayList<String> tags = new ArrayList<>();

            NodeList tagsChild = rootNode.getChildNodes();
            for (int index = 0; index < tagsChild.getLength(); index++) {
                if (! tagsChild.item(index).getNodeName().equals("#text")) {
                    tags.add(tagsChild.item(index).getNodeName());
                }
            }

            Prefixes prefixes = new Prefixes(xml);
            Interlinks interlinks = new Interlinks(xml);

            ArrayList<Prefix> listPrefixes = prefixes.getPrefixes();
            ArrayList<Interlink> listInterlinks = interlinks.getInterlinks();
            ArrayList<LinkageRule> listRules = new ArrayList<>();

            for (Interlink inter : listInterlinks) {
                listRules.add(inter.getLinkageRule());
            }

//            System.out.println(listRules.get(0).getAggregateList().get(0).toString());
            System.out.println(listRules.get(0).getCompareList().get(0).toString());
            System.out.println(listRules.get(1).getAggregateList().get(0).toString());
            System.out.println(listRules.get(1).getCompareList().get(0).toString());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
