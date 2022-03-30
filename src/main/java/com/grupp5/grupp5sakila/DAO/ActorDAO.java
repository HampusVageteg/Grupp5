package com.grupp5.grupp5sakila.DAO;

import com.grupp5.grupp5sakila.entity.Actor;
import com.grupp5.grupp5sakila.util.DatabaseSession;
import org.hibernate.Session;

import java.util.List;

public class ActorDAO implements DAO<Actor>{

    private final DatabaseSession dbSession = new DatabaseSession();


    @Override
    public void create(Actor data) {

        Actor actor = new Actor();


        Session session = dbSession.startSession();

        actor.setFirstName(data.getFirstName());
        actor.setLastName(data.getLastName());

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
    public void update(int id) {
        Session session = dbSession.startSession();


    }

    @Override
    public void delete(int id) {

    }
}
