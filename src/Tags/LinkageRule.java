package Tags;

import Visitor.PostageVisitor;
import Visitor.Visitable;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class LinkageRule {

    private ArrayList<Aggregate> aggregateList;
    private ArrayList<Compare> compareList;
    private ArrayList<Visitable> items;

    public LinkageRule (Element linkageRule) {
        this.aggregateList = new ArrayList<>();
        this.compareList = new ArrayList<>();
        this.items = new ArrayList<>();

        NodeList aggregates = linkageRule.getElementsByTagName("Aggregate");
        NodeList compares = linkageRule.getElementsByTagName("Compare");
        NodeList transforms = linkageRule.getElementsByTagName("TransformInput");

        for (int index = 0; index < aggregates.getLength(); index++) {
            items.add(new Aggregate((Element) aggregates.item(index)));
        }

        for (int index = 0; index < compares.getLength(); index++) {
            items.add(new Compare((Element) compares.item(index)));
        }
        for (int index = 0; index < compares.getLength(); index++) {
            items.add(new Compare((Element) compares.item(index)));
        }
    }

    public void showAll () {
        PostageVisitor visitor = new PostageVisitor();
        for (Visitable item : items) {
            item.accept(visitor);
        }
    }

    public ArrayList<Aggregate> getAggregateList () {
        return aggregateList;
    }

    public ArrayList<Compare> getCompareList () {
        return compareList;
    }
}