package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpdateList {
//    private int total;
    private List<Deployment> deploymentList;

    public UpdateList() {
//        this. = deploymentName;
        this.deploymentList = new ArrayList<>();
    }

//    public String getDeploymentName() {
//        return deploymentName;
//    }
//
//    public void setDeploymentName(String deploymentName) {
//        this.deploymentName = deploymentName;
//    }

    public List<Deployment> getDeploymentList() {
        return deploymentList;
    }

    public void setDeploymentList(List<Deployment> deploymentSet) {
        this.deploymentList = deploymentSet;
    }

    public Deployment getDeploymentInstance(String deploymentName) {
        return this.deploymentList.stream().filter(o -> o.getDeploymentName().equals(deploymentName)).findAny().orElse(null);
    }

    public void updateDeployment(String deploymentName, String nameSpace) {
        Deployment deployment = getDeploymentInstance(deploymentName);
        if (deployment != null) {
            deployment.getNameSpace().add(nameSpace);
        } else {
            deploymentList.add(new Deployment(deploymentName));
            Deployment newDeployment = deploymentList.get(deploymentList.size() - 1);
            newDeployment.getNameSpace().add(nameSpace);
        }
    }

    public String printList() {
        String s ="";
        for (Deployment d: deploymentList) {
            s+="{\n{\n"
            + "deploymentName " + d.getDeploymentName() + "\n"
            + "namespaces:" + Arrays.toString(d.getNameSpace().toArray())
            + "},";
        }
        return s;
    }

    @Override
    public String toString() {
        return "UpdateList{" +
                "deploymentList=" + printList()
                +
                '}';
    }
}
