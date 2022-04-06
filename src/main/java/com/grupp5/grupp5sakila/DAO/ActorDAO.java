package com.grupp5.grupp5sakila.DAO;

import com.grupp5.grupp5sakila.entity.Actor;
import com.grupp5.grupp5sakila.util.DatabaseSession;
import org.hibernate.Session;

import java.util.List;

public class ActorDAO implements DAO<Actor>{

    private final DatabaseSession dbSession = new DatabaseSession();


    @Override
    public void create(Actor data) {

        Session session = dbSession.startSession();
        session.persist(data);
        dbSession.endSession(session);
    }

    @Override
    public List readAsList() {
        Session session = dbSession.startSession();
        List<Actor> actorList = session.createQuery("SELECT a FROM Actor a", Actor.class).getResultList();
        dbSession.endSession(session);
        return actorList;
    }

    @Override
    public void update(Actor data) {
        Session session = dbSession.startSession();
        Actor actor = session.get(Actor.class, data.getId());

        actor.setFirstName(data.getFirstName());
        actor.setLastName(data.getLastName());
        session.update(actor);
        dbSession.endSession(session);
    }

    @Override
    public void delete(Actor data) {
        Session session = dbSession.startSession();
        Actor actor = session.get(Actor.class, data.getId());
        session.delete(actor);
        dbSession.endSession(session);

    }
}
