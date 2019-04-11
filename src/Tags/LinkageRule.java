package Tags;

import Visitor.PostageVisitor;
import Visitor.Visitable;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class LinkageRule {

    private ArrayList<Visitable> items;

    LinkageRule (Element linkageRule) {

        this.items = new ArrayList<>();

        NodeList aggregates = linkageRule.getElementsByTagName("Aggregate");
        NodeList compares = linkageRule.getElementsByTagName("Compare");
        NodeList transforms = linkageRule.getElementsByTagName("TransformInput");
        NodeList inputs = linkageRule.getElementsByTagName("Input");

        for (int index = 0; index < aggregates.getLength(); index++) {
            items.add(new Aggregate((Element) aggregates.item(index)));
        }

        for (int index = 0; index < compares.getLength(); index++) {
            items.add(new Compare((Element) compares.item(index)));
        }

        for (int index = 0; index < transforms.getLength(); index++) {
            items.add(new TransformInput((Element) transforms.item(index)));
        }

        for (int index = 0; index < inputs.getLength(); index++) {
            items.add(new Input((Element) inputs.item(index)));
        }
    }

    public void showAll () {
        PostageVisitor visitor = new PostageVisitor();
        for (Visitable item : items) {
            item.accept(visitor);
        }
    }
}