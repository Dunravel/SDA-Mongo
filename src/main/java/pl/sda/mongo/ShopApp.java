package pl.sda.mongo;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import pl.sda.mongo.mongodb.MongoClientConnectivity;

public class ShopApp {
    public static void main(String[] args) {

        MongoClientConnectivity mongoClientConnectivity = new MongoClientConnectivity();
        mongoClientConnectivity.open();

        MongoClient mongoClient = mongoClientConnectivity.getMongoClient();
        MongoDatabase library = mongoClient.getDatabase("library");

        library.createCollection("books");
        library.listCollectionNames()
                .forEach((Block<? super String>)System.out::println);

        MongoCollection<Document> books = library.getCollection("books");

        mongoClientConnectivity.close();
    }
}
