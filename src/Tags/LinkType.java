package Tags;

import org.w3c.dom.Element;

public class LinkType {
    private String linkType;

    public LinkType (Element linkType) {
        this.linkType = linkType.getTextContent();
    }

    public String getLinkType () {
        return linkType;
    }
}
