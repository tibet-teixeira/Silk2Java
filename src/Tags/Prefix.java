package Tags;

import org.w3c.dom.Element;

public class Prefix {
    private String id;
    private String namespace;

    Prefix (Element prefix) {
        this.id = prefix.getAttribute("id");
        this.namespace = prefix.getAttribute("namespace");
    }

    public String getId () {
        return this.id;
    }

    public String getNamespace () {
        return this.namespace;
    }
}
