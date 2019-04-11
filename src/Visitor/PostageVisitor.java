package Visitor;

import Tags.Aggregate;
import Tags.Compare;
import Tags.Input;
import Tags.TransformInput;

import java.util.ArrayList;

public class PostageVisitor implements Visitor {
    private ArrayList<Input> inputs;

    public PostageVisitor () {
        this.inputs = new ArrayList<>();
    }

    public void visit (Aggregate aggregate) {
        System.out.println(aggregate.show());
    }

    public void visit (Compare compare) {
        System.out.println(compare.show());
    }

    public void visit (TransformInput transformInput) {
        System.out.println(transformInput.show());
    }

    public void visit (Input input) {
        inputs.add(input);
    }

    public ArrayList<Input> getInputs(){
        return this.inputs;
    }
}