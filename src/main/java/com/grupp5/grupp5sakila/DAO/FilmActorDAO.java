package com.grupp5.grupp5sakila.DAO;

import com.grupp5.grupp5sakila.entity.FilmActor;
import com.grupp5.grupp5sakila.util.DatabaseSession;
import org.hibernate.Session;

import java.util.List;

public class FilmActorDAO implements DAO<FilmActor>{

    private final DatabaseSession dbSession = new DatabaseSession();

    @Override
    public void create(FilmActor data) {
        Session session = dbSession.startSession();
        System.out.println("Hej");
        session.merge(data);
        System.out.println("asdasd");
        dbSession.endSession(session);

    }

    @Override
    public List<FilmActor> readAsList() {
        Session session = dbSession.startSession();
        List<FilmActor> filmActors = session.createQuery("SELECT fa FROM FilmActor fa", FilmActor.class).getResultList();
        dbSession.endSession(session);
        return filmActors;
    }

    @Override
    public void update(FilmActor data) {
        Session session = dbSession.startSession();
        FilmActor filmActor = session.get(FilmActor.class, data.getId());

        filmActor.setFilm(data.getFilm());
        filmActor.setActor(data.getActor());

        session.update(filmActor);
        dbSession.endSession(session);
    }

    @Override
    public void delete(FilmActor data) {

    }
}
