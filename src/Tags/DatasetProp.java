package Tags;

import org.w3c.dom.Element;

public class DatasetProp {
    private String dataSource;
    private String var;
    private String restrictTo;

    public DatasetProp (Element sourceData) {
        this.dataSource = sourceData.getAttribute("dataSource");
        this.var = sourceData.getAttribute("var");
        this.restrictTo = sourceData.getElementsByTagName("RestrictTo")
                .item(0).getTextContent();
    }

    public String getDataSource () {
        return dataSource;
    }

    public String getVar () {
        return var;
    }

    public String getRestrictTo () {
        return restrictTo;
    }
}
