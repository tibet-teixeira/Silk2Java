import Read.ReadXMLFile;
import Tags.*;
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
                DatasetProp source = interlink.getSourceDataset();
                DatasetProp target = interlink.getTargetDataset();
                System.out.println("Id: " + interlink.getId());
                System.out.println("LinkType: " + interlink.getLinkType());
                System.out.println("SourceData: " + source.getDataSource() +
                        " - " + source.getRestrictTo() +
                        " - " + source.getVar());
                System.out.println("TargetData: " + target.getDataSource() +
                        " - " + target.getRestrictTo() +
                        " - " + target.getVar());
                System.out.println("\n\n\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
