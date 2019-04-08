package Tags;

import org.w3c.dom.Element;

public class Input {
    private String id;
    private String path;

    public Input (Element input) {
        this.id = input.getAttribute("path");
        this.path = input.getAttribute("id");
    }

    public String getId () {
        return id;
    }

    public String getPath () {
        return path;
    }

    @Override
    public String toString () {
        return "Input" + "\n" + id + "\n" + path;
    }
}
