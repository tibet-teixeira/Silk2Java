package Tags;

import Visitor.Visitable;
import Visitor.Visitor;
import org.w3c.dom.Element;

public class Input implements Visitable {
    private String id;
    private String path;

    Input (Element input) {
        this.id = input.getAttribute("id");
        this.path = input.getAttribute("path");
    }

    public String getId () {
        return id;
    }

    public String getPath () {
        return path;
    }

    public String show(){
        return "Input " + this.path;
    }

    @Override
    public String toString () {
        return "Input" + "\n" + id + "\n" + path;
    }

    @Override
    public void accept (Visitor visitor) {
        visitor.visit(this);
    }
}
