package pl.sda.mongo;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import pl.sda.mongo.domain.BookFactory;
import pl.sda.mongo.mongodb.MongoClientConnectivity;
import pl.sda.mongo.mongodb.MongoCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShopApp {
    public static void main(String[] args) {

        MongoClientConnectivity mongoClientConnectivity = new MongoClientConnectivity();
        mongoClientConnectivity.open();

//        MongoClient mongoClient = mongoClientConnectivity.getMongoClient();
//        MongoDatabase library = mongoClient.getDatabase("library");
//        MongoCollection<Document> books = library.getCollection("books");

//
//
//        library.listCollectionNames()
//                .forEach((Block<? super String>)System.out::println);


        MongoCollection<Document> books = new MongoCollections(mongoClientConnectivity).getCollection("books");

        BookFactory bookFactory = new BookFactory();

        books.insertMany(Arrays.asList(
                bookFactory.create("Zbrodnia i Kara",
                        "Fiodor Dostojewski",
                        Arrays.asList("zbrodnia","kara")
                        ),
                bookFactory.create(
                        "JUnit",
                        "Ktoś mądry",
                        Arrays.asList("code quality","software development")
                ),
                bookFactory.create(
                        "Kubuś Puchatek",
                        "Christopher XXX",
                        Arrays.asList("miodek")
                )
        ));

        for(Document aBook : books.find()){
            System.out.println(aBook);
        }

       // books.find().forEach((Block <? super String> ));

        mongoClientConnectivity.close();
    }
}
