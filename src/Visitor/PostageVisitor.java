package Visitor;

import Tags.Aggregate;
import Tags.Compare;
import Tags.TransformInput;

import java.util.ArrayList;

public class PostageVisitor implements Visitor {
    private ArrayList<Object> items;

    public PostageVisitor () {
        this.items = new ArrayList<>();
    }

    public void visit (Aggregate aggregate) {
        System.out.println(aggregate.toString());
        this.items.add(aggregate);
    }

    public void visit (Compare compare) {
        System.out.println(compare.toString());
        this.items.add(compare);
    }

    public void visit (TransformInput transformInput) {
        System.out.println(transformInput.toString());
        this.items.add(transformInput);
    }
}