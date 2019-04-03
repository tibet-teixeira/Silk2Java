package Tags;

import org.w3c.dom.Element;

public class Interlink {
    private String id;
    private LinkType linkType;
//    private SourceDataset source;
//    private TargetDataset target;
//    private LinkageRule linkageRule;

    public Interlink (Element interlink) {
        this.linkType = new LinkType((Element) interlink.getElementsByTagName("LinkType").item(0));
        this.id = interlink.getAttribute("id");
//        System.out.println(this.linkType);
//        this.source = interlink.getAttribute("SourceDataset");
//        this.target = interlink.getAttribute("TargetDataset");
//        this.linkageRule = interlink.getAttribute("LinkageRule");

    }

    public String getLinkType () {
        return linkType.getLinkType();
    }

    public String getId () {
        return id;
    }
}
