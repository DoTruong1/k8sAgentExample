package org.example;

public class AgentDocument {
    private String name;
    private UpdateList upToDateList;
    private UpdateList outDateList;

    public AgentDocument(String name) {
        this.name = name;
        this.upToDateList = new UpdateList();
        this.outDateList = new UpdateList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UpdateList getUpToDateList() {
        return upToDateList;
    }

    public void setUpToDateList(UpdateList upToDateList) {
        this.upToDateList = upToDateList;
    }

    public UpdateList getOutDateList() {
        return outDateList;
    }

    public void setOutDateList(UpdateList outDateList) {
        this.outDateList = outDateList;
    }

    @Override
    public String toString() {
        return "AgentDocument {" +
                "   \n\tame='" + name + '\'' + "," +
                "   \n\tupToDateList=" + upToDateList.toString() + "," +
                "   \n\toutDateList=" + outDateList.toString() + "\n" +
                "}\n";
    }
}
