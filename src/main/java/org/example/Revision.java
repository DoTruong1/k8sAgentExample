package org.example;

public class Revision {
    private String latest;

    public Revision(String latest) {
        this.latest = latest;
    }

    public String getLatest() {
        return latest;
    }

    public void setLatest(String latest) {
        this.latest = latest;
    }
}
