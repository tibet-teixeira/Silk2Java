package Tags;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class LinkageRule {

    private ArrayList<Aggregate> aggregateList;
    private ArrayList<Compare> compareList;

    public LinkageRule (Element linkageRule) {
        this.aggregateList = new ArrayList<>();
        this.compareList = new ArrayList<>();
        NodeList aggregates = linkageRule.getElementsByTagName("Aggregate");
        NodeList compares = linkageRule.getElementsByTagName("Compare");

        for (int index = 0; index < aggregates.getLength(); index++) {
            aggregateList.add(new Aggregate((Element) aggregates.item(index)));
        }

        for (int index = 0; index < compares.getLength(); index++) {
            compareList.add(new Compare((Element) compares.item(index)));
        }
    }

    public ArrayList<Aggregate> getAggregateList () {
        return aggregateList;
    }

    public ArrayList<Compare> getCompareList () {
        return compareList;
    }
}