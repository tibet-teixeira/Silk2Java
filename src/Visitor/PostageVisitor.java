package Visitor;

import Tags.Aggregate;
import Tags.Compare;
import Tags.Input;
import Tags.TransformInput;

public class PostageVisitor implements Visitor {

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
        System.out.println(input.show());
    }
}