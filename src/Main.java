import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main (String argv[]) throws ParserConfigurationException, SAXException, IOException {

        String pathname = "linkSpec.xml";
        new ParseSilk2Java(pathname);
    }
}
