package br.com.tommiranda.jerseymongoapp.repository;

import br.com.tommiranda.jerseymongoapp.domain.Evento;
import br.com.tommiranda.jerseymongoapp.mapper.EventoMapper;
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

public class EventoRepository {

    private final MongoDatabase db = MongoConnection.getConnection();
    private final MongoCollection<Document> collection = db.getCollection(CollectionNames.Evento);

    public Evento findById(String id) {
        Bson query = new BasicDBObject("_id", new ObjectId(id));
        FindIterable<Document> queryResult = collection.find(query);

        for (Document doc : queryResult) {
            return EventoMapper.toEvento(doc);
        }

        return null;
    }

    public List<Evento> getAll() {
        List<Evento> eventoList = new ArrayList<>();
        FindIterable<Document> queryResult = collection.find();

        for (Document doc : queryResult) {
            eventoList.add(EventoMapper.toEvento(doc));
        }

        return eventoList;
    }

    public Boolean add(final Evento evento) {
        Document eventoDocument = EventoMapper.toDocument(evento);

        try {
            collection.insertOne(eventoDocument);
            System.out.println(eventoDocument.get("_id"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean update(final String eventoId, final Evento evento) {
        Bson query = new BasicDBObject("_id", new ObjectId(eventoId));
        Document eventoDocument = EventoMapper.toDocument(evento);

        try {
            collection.replaceOne(query, eventoDocument);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
