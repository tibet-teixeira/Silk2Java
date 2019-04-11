package Tags;

import Visitor.*;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class TransformInput implements Visitable{

    private String id;
    private String function;
    private ArrayList<Input> inputList;

    TransformInput (Element transformInput) {
        this.id = transformInput.getAttribute("id");
        this.function = transformInput.getAttribute("function");
        this.inputList = new ArrayList<>();
        NodeList inputs = transformInput.getElementsByTagName("Input");

        for (int index = 0; index < inputs.getLength(); index++) {
            inputList.add(new Input((Element) inputs.item(index)));
        }
    }

    public String show(){
        return "TransformInput " + this.id;
    }

    @Override
    public String toString () {
        String attributes = "TransformInput" + "\n" + this.id + "\n" + this.function;

        for (Input input : this.inputList) {
            attributes += "\n" + input.toString();
        }
        return attributes;
    }

    @Override
    public void accept (Visitor visitor) {
        visitor.visit(this);
    }
}
