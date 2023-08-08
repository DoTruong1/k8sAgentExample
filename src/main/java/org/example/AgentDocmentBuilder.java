package org.example;

import org.bson.Document;

public class AgentDocmentBuilder {
    private AgentDocument agentDocument;

    public AgentDocmentBuilder(AgentDocument agentDocument) {
        this.agentDocument = agentDocument;
    }

    public Document getDocumentFromAgentDocument() {
        Document document = new Document();
        document.append("name", this.agentDocument.getName())
                .append("uptoDateList", this.agentDocument.getUpToDateList())
                .append("outDatedList", this.agentDocument.getOutDateList());
        return document;
    }
}
