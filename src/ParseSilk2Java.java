import Read.ReadXMLFile;
import Tags.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ParseSilk2Java {

    ParseSilk2Java (String pathname) throws IOException, SAXException, ParserConfigurationException {
        Document xml = new ReadXMLFile(pathname).getDocument();

        xml.getDocumentElement().normalize();

//        Element rootNode = (Element) xml.getChildNodes().item(0); // get Root node
//        ArrayList<String> tags = new ArrayList<>();
//
//        NodeList tagsChild = rootNode.getChildNodes();
//        for (int index = 0; index < tagsChild.getLength(); index++) {
//            if (! tagsChild.item(index).getNodeName().equals("#text")) {
//                tags.add(tagsChild.item(index).getNodeName());
//            }
//        }

        Prefixes prefixes = new Prefixes(xml);
        Interlinks interlinks = new Interlinks(xml);

        ArrayList<Prefix> listPrefixes = prefixes.getPrefixes();
        ArrayList<Interlink> listInterlinks = interlinks.getInterlinks();

        ArrayList<Input> inputs;
        HashMap<Interlink, ArrayList<Input>> mapInterlinkInputList = new HashMap<>();

        for (Interlink interlink : listInterlinks) {
            interlink.getLinkageRule().getInputs();
            inputs = new ArrayList<>(interlink.getLinkageRule().getInputs());
            mapInterlinkInputList.put(interlink, inputs);
        }

        for (Interlink interlink : listInterlinks) {
            System.out.println("Interlink id " + interlink.getId());
            System.out.println("Source restrict " + " Var " + interlink.getSourceDataset().getVar() + " " +  interlink.getSourceDataset().getRestrictTo());
            System.out.println("Target restrict " + " Var " + interlink.getTargetDataset().getVar() + " " + interlink.getTargetDataset().getRestrictTo());
            for (Input input : mapInterlinkInputList.get(interlink)) {
                System.out.println("\t" + input.getId() + " " + input.getPath());
            }
            System.out.println();
        }
    }
}
