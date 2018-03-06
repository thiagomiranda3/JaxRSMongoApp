package br.com.tommiranda.jerseymongoapp;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoConnection {

    private static MongoClient mongoClient;

    private MongoConnection() {
    }

    public static MongoClient GetConnection() {
        if (mongoClient == null) {
            mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        }

        return mongoClient;
    }
}
