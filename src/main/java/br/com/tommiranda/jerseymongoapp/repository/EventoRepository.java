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

    private final EventoMapper mapper;
    private final MongoDatabase db;
    private final MongoCollection<Document> collection;

    public EventoRepository() {
        this.mapper = new EventoMapper();
        this.db = MongoConnection.getConnection();
        this.collection = db.getCollection(CollectionNames.Evento);
    }

    public Evento findById(String id) {
        Bson query = new BasicDBObject("_id", new ObjectId(id));
        FindIterable<Document> queryResult = collection.find(query);

        for (Document doc : queryResult)
            return mapper.toEvento(doc);

        return null;
    }

    public List<Evento> getAll() {
        List<Evento> eventoList = new ArrayList<>();
        FindIterable<Document> queryResult = collection.find();

        for (Document doc : queryResult)
            eventoList.add(mapper.toEvento(doc));

        return eventoList;
    }

    public Evento add(final Evento evento) {
        Document eventoDocument = mapper.toDocument(evento);

        try {
            collection.insertOne(eventoDocument);

            return mapper.toEvento(eventoDocument);
        } catch (Exception e) {
            throw e;
        }
    }

    public Boolean update(final String eventoId, final Evento evento) {
        Bson query = new BasicDBObject("_id", new ObjectId(eventoId));
        Document eventoDocument = mapper.toDocument(evento);

        try {
            return collection.replaceOne(query, eventoDocument).getModifiedCount() > 0;
        } catch (Exception e) {
            throw e;
        }
    }
}
