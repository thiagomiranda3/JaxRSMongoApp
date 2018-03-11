package br.com.tommiranda.jerseymongoapp.mongoutils;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public abstract class MongoConnection {

    private static MongoClient mongoClient;
    private static final String mongoUri = "mongodb://localhost:27017";

    private MongoConnection() {
    }

    public static MongoClient getMongoClient() {
        if (mongoClient == null)
            mongoClient = new MongoClient(new MongoClientURI(mongoUri));

        return mongoClient;
    }

    public static MongoDatabase getConnection() {
        return getMongoClient().getDatabase("JerseyMongoApp");
    }
}
