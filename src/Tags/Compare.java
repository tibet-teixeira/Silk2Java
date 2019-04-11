package Tags;

import Visitor.*;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class Compare implements Visitable {
    private String id;
    private String metric;
    private String threshold;
    private String required;
    private String weight;
    private ArrayList<Input> inputList;
    private ArrayList<TransformInput> transformInputList;

    Compare (Element compare) {
        this.id = compare.getAttribute("id");
        this.metric = compare.getAttribute("metric");
        this.threshold = compare.getAttribute("threshold");
        this.required = compare.getAttribute("required");
        this.weight = compare.getAttribute("weight");
        this.inputList = new ArrayList<>();
        this.transformInputList = new ArrayList<>();
        NodeList inputs = compare.getElementsByTagName("Input");
        NodeList tranforms = compare.getElementsByTagName("TransformInput");

        for (int index = 0; index < inputs.getLength(); index++) {
            inputList.add(new Input((Element) inputs.item(index)));
        }

        for (int index = 0; index < tranforms.getLength(); index++) {
            transformInputList.add(new TransformInput((Element) tranforms.item(index)));
        }
    }

    public String getId () {
        return id;
    }

    public String getMetric () {
        return metric;
    }

    public String getThreshold () {
        return threshold;
    }

    public String getRequired () {
        return required;
    }

    public String getWeight () {
        return weight;
    }

    public ArrayList<Input> getInputList () {
        return inputList;
    }

    public ArrayList<TransformInput> getTransformInputList () {
        return transformInputList;
    }

    public String show(){
        return "Compare " + this.id;
    }

    @Override
    public String toString () {
        String attributes = "Compare" + "\n" + this.id + "\n" + this.required + "\n" + this.metric + "\n" + this.weight + "\n" + this.threshold;

        for (Input input : this.inputList) {
            attributes += "\n" + input.toString();
        }

        for (TransformInput transformInput : this.transformInputList) {
            attributes += "\n" + transformInput.toString();
        }
        return attributes;
    }

    @Override
    public void accept (Visitor visitor) {
        visitor.visit(this);
    }

}
