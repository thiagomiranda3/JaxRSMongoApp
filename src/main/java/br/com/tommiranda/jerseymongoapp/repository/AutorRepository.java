package br.com.tommiranda.jerseymongoapp.repository;

import br.com.tommiranda.jerseymongoapp.domain.Autor;
import br.com.tommiranda.jerseymongoapp.mapper.AutorMapper;
import br.com.tommiranda.jerseymongoapp.mongoutils.CollectionNames;
import br.com.tommiranda.jerseymongoapp.mongoutils.MongoConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class AutorRepository {

    private final MongoDatabase db = MongoConnection.getConnection();
    private final MongoCollection<Document> collection = db.getCollection(CollectionNames.Autor);

    public Autor findById(String id) {
        Bson query = new BasicDBObject("_id", new ObjectId(id));
        FindIterable<Document> queryResult = collection.find(query);

        for (Document doc : queryResult) {
            return AutorMapper.toAutor(doc);
        }

        return null;
    }

    public List<Autor> getAll() {
        List<Autor> autorList = new ArrayList<>();
        FindIterable<Document> queryResult = collection.find();

        for (Document doc : queryResult) {
            autorList.add(AutorMapper.toAutor(doc));
        }

        return autorList;
    }

    public Boolean add(final Autor autor) {
        Document autorDocument = AutorMapper.toDocument(autor);

        try {
            collection.insertOne(autorDocument);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
