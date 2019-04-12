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

        Prefixes prefixes = new Prefixes(xml);
        Interlinks interlinks = new Interlinks(xml);

        ArrayList<Prefix> listPrefixes = prefixes.getPrefixes();
        ArrayList<Interlink> listInterlinks = interlinks.getInterlinks();

        ArrayList<Input> inputs;
        HashMap<Interlink, ArrayList<Input>> mapInterlinkInputList = new HashMap<>();

        for (Interlink interlink : listInterlinks) {
            System.out.println("Interlink id: " + interlink.getId());
            ArrayList<Input> listInputs = interlink.getMapVariableDatasetInputs().get("b");

            for (Input input : listInputs) {
                System.out.println("\t" + input.getPath());
            }
        }


    }
}
