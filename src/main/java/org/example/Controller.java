package org.example;

import com.mongodb.ConnectionString;
//import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.InsertOneModel;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import com.mongodb.client.MongoClient;

import java.util.Arrays;
import java.util.HashMap;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Controller {
    private HashMap<String, Data> hashMap = new HashMap<>() {{
        put("abm", new Data("abm", new Revision("abm:123456")));
        put("py", new Data("py", new Revision("py:123456")));

    }};
    private HashMap<String, AgentDocument> data = new HashMap<>();
    public void testBuild() {
//        MongoClientURI mongoClientURI = new MongoClientURI("mongodb://dotruong1910:asd123qwe@localhost:27017/");
        ConnectionString connectionString = new ConnectionString("mongodb://dotruong1910:asd123qwe@localhost:27017/");
//        MongoClient mongoClient = new MongoClient(mongoClientURI);
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .build();
        MongoClient mongoClient = MongoClients.create(clientSettings);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
        String deploymentName = "abm";
        String latest="abm:123456";
        if (!data.containsKey(deploymentName)) {
            data.put(deploymentName, new AgentDocument(deploymentName));
        }
        if (latest.equals(hashMap.get(deploymentName).getRevision().getLatest())) {
            data.get(deploymentName).getUpToDateList().updateDeployment(deploymentName, "testNs");
        } else {
            data.get(deploymentName).getOutDateList().updateDeployment(deploymentName, "testNsOUT");
        }
        MongoCollection<AgentDocument> agentDocumentMongoCollection = mongoDatabase.getCollection("test", AgentDocument.class);
        AgentDocmentBuilder agentDocmentBuilder = new AgentDocmentBuilder(data.get("abm"));
        agentDocumentMongoCollection.insertOne(data.get("abm"));
    }
}
