package Visitor;

import Tags.Aggregate;
import Tags.Compare;
import Tags.Input;
import Tags.TransformInput;

public interface Visitor {
    public void visit (Aggregate aggregate);

    public void visit (Compare compare);

    public void visit (TransformInput transformInput);

    public void visit (Input input);
}
