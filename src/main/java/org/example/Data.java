package org.example;

public class Data {
    private String envType;
    private Revision revision;

    public Data(String envType, Revision revision) {
        this.envType = envType;
        this.revision = revision;
    }

    public String getEnvType() {
        return envType;
    }

    public void setEnvType(String envType) {
        this.envType = envType;
    }

    public Revision getRevision() {
        return revision;
    }

    public void setRevision(Revision revision) {
        this.revision = revision;
    }
}
