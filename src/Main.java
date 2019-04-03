import Read.ReadXMLFile;
import Tags.Interlink;
import Tags.Interlinks;
import Tags.Prefix;
import Tags.Prefixes;
import org.w3c.dom.Document;

import java.util.ArrayList;

public class Main {
    public static void main (String argv[]) {

        try {
            String pathname = "linkSpec.xml";

            Document xml = new ReadXMLFile(pathname).getDocument();

            xml.getDocumentElement().normalize();

            Prefixes prefixes = new Prefixes(xml);
            Interlinks interlinks = new Interlinks(xml);

            ArrayList<Prefix> listPrefixes = prefixes.getPrefixes();
            ArrayList<Interlink> listInterlinks = interlinks.getInterlinks();

            for (Interlink interlink : listInterlinks) {
                System.out.println("Id: " + interlink.getId());
                System.out.println("LinkType: " + interlink.getLinkType());
            }

            for (Prefix prefix : listPrefixes) {
                System.out.println("Id: " + prefix.getId());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
