package Tags;

import Visitor.Visitable;
import Visitor.Visitor;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class Aggregate implements Visitable {
    private String id;
    private String type;
    private String required;
    private String weight;
    private ArrayList<Compare> compareList;

    public Aggregate (Element aggregate) {
        this.id = aggregate.getAttribute("id");
        this.type = aggregate.getAttribute("type");
        this.required = aggregate.getAttribute("required");
        this.weight = aggregate.getAttribute("weight");
        this.compareList = new ArrayList<>();
        NodeList compares = aggregate.getElementsByTagName("Compare");

        for (int index = 0; index < compares.getLength(); index++) {
            compareList.add(new Compare((Element) compares.item(index)));
        }
    }

    public String getId () {
        return id;
    }

    public String getType () {
        return type;
    }

    public String getRequired () {
        return required;
    }

    public String getWeight () {
        return weight;
    }

    public ArrayList<Compare> getCompareList () {
        return compareList;
    }

    @Override
    public void accept (Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString () {
        String attributes = "Aggregate" + "\n" + this.id + "\n" + this.required + "\n" + this.type + "\n" + this.weight;

        for (Compare compare : this.compareList) {
            attributes += "\n" + compare.toString();
        }
        return attributes;
    }
}
