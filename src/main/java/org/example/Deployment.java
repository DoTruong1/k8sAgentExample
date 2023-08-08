package org.example;

import java.util.HashSet;
import java.util.Set;

public class Deployment {
    private String deploymentName;
    private Set<String> nameSpace;
    public Deployment(String deploymentName) {
        this.deploymentName = deploymentName;
        this.nameSpace = new HashSet<>();
    }
    public String getDeploymentName() {
        return deploymentName;
    }

    public void setDeploymentName(String deploymentName) {
        this.deploymentName = deploymentName;
    }

    public Set<String> getNameSpace() {
        return nameSpace;
    }



    public void setNameSpace(Set<String> nameSpace) {
        this.nameSpace = nameSpace;
    }
}
