package pl.sda.mongo.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

public class MongoCollections {
    private final MongoClientConnectivity mongoClientConnectivity;
    private MongoClient mongoClient;

    public MongoCollections(MongoClientConnectivity mongoClientConnectivity) {

        this.mongoClientConnectivity = mongoClientConnectivity;
    }


    public MongoCollection<Document> getCollection(String name) {
        mongoClient = mongoClientConnectivity.getMongoClient();
        MongoDatabase library = mongoClient.getDatabase("library");
        MongoCollection<Document> books = library.getCollection(name);
        return books;
    }

    void createCollection(String collectionName){
        aDatabase().createCollection(collectionName);

    }

    public MongoIterable<String> collections(){
        return aDatabase().listCollectionNames();
    }

    private MongoDatabase aDatabase() {
        return mongoClient.getDatabase("library");
    }
}
