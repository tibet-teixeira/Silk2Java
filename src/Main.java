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
            String pathname = "linkSpec2.xml";

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

            for(String tag:tags){
                System.out.println(tag);
            }

            Prefixes prefixes = new Prefixes(xml);
            Interlinks interlinks = new Interlinks(xml);

            ArrayList<Prefix> listPrefixes = prefixes.getPrefixes();
            ArrayList<Interlink> listInterlinks = interlinks.getInterlinks();

//            for (Interlink interlink : listInterlinks) {
//                DatasetProp source = interlink.getSourceDataset();
//                DatasetProp target = interlink.getTargetDataset();
//                System.out.println("Id: " + interlink.getId());
//                System.out.println("LinkType: " + interlink.getLinkType());
//                System.out.println("SourceData: " + source.getDataSource() +
//                        " - " + source.getRestrictTo() +
//                        " - " + source.getVar());
//                System.out.println("TargetData: " + target.getDataSource() +
//                        " - " + target.getRestrictTo() +
//                        " - " + target.getVar());
//                System.out.println("\n");
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
