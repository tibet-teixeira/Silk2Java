package Tags;

import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.HashMap;

public class Interlink {
    private String id;
    private LinkType linkType;
    private DatasetProp sourceDataset;
    private DatasetProp targetDataset;
    private LinkageRule linkageRule;
    private HashMap<String, ArrayList<Input>> mapVariableDatasetInputs;
    private Filter filter;

    Interlink (Element interlink) {
        this.id = interlink.getAttribute("id");
        this.mapVariableDatasetInputs = new HashMap<>();

        this.linkType = new LinkType((Element) interlink.getElementsByTagName("LinkType")
                .item(0));
        this.sourceDataset = new DatasetProp((Element) interlink.getElementsByTagName("SourceDataset")
                .item(0));
        this.targetDataset = new DatasetProp((Element) interlink.getElementsByTagName("TargetDataset")
                .item(0));
        this.linkageRule = new LinkageRule((Element) interlink.getElementsByTagName("LinkageRule")
                .item(0));
        this.filter = new Filter((Element) interlink.getElementsByTagName("Filter")
                .item(0));

        mapVariableDatasetInputs.put(this.sourceDataset.getVar(),
                getListInputsPerVariable(this.sourceDataset.getVar(), this.linkageRule.getInputs()));
        mapVariableDatasetInputs.put(this.targetDataset.getVar(),
                getListInputsPerVariable(this.targetDataset.getVar(), this.linkageRule.getInputs()));
    }

    public HashMap<String, ArrayList<Input>> getMapVariableDatasetInputs () {
        return mapVariableDatasetInputs;
    }

    public String getLinkType () {
        return linkType.getLinkType();
    }

    public String getId () {
        return this.id;
    }

    public DatasetProp getSourceDataset () {
        return this.sourceDataset;
    }

    public DatasetProp getTargetDataset () {
        return this.targetDataset;
    }

    public LinkageRule getLinkageRule () {
        return linkageRule;
    }

    private static ArrayList<Input> getListInputsPerVariable (String variable, ArrayList<Input> listInputs) {
        ArrayList<Input> listInputsPerVariable = new ArrayList<>();

        for (Input input : listInputs) {
            if (hasVariable(variable, input))
                listInputsPerVariable.add(input);
        }
        return listInputsPerVariable;
    }

    private static boolean hasVariable (String variable, Input input) {
        return input.getPath().contains("?" + variable);
    }
}
