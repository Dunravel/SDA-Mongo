package pl.sda.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import pl.sda.mongo.mongodb.MongoClientConnectivity;

public class ShopApp {
    public static void main(String[] args) {

        MongoClientConnectivity mongoClientConnectivity = new MongoClientConnectivity();
        mongoClientConnectivity.open();

        MongoClient mongoClient = mongoClientConnectivity.getMongoClient();
        MongoDatabase library = mongoClient.getDatabase("library");


        mongoClientConnectivity.close();
    }
}
