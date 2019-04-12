package Tags;

import org.w3c.dom.Element;

public class Filter {
    private String limit;

    Filter (Element filter) {
        this.limit = filter.getAttribute("limit");
    }

    public String getLimit () {
        return limit;
    }
}
