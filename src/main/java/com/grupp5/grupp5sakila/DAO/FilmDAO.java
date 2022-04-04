package com.grupp5.grupp5sakila.DAO;

import com.grupp5.grupp5sakila.entity.City;
import com.grupp5.grupp5sakila.entity.Film;
import com.grupp5.grupp5sakila.util.DatabaseSession;
import org.hibernate.Session;

import java.util.List;

public class FilmDAO implements DAO<Film>{

    private final DatabaseSession dbSession = new DatabaseSession();

    @Override
    public void create(Film data) {

    }

    @Override
    public List<Film> readAsList() {
        Session session = dbSession.startSession();
        List<Film> filmList = session.createQuery("SELECT f FROM Film f", Film.class).getResultList();
        dbSession.endSession(session);
        return filmList;
    }

    @Override
    public void update(Film data) {

    }

    @Override
    public void delete(Film data) {

    }
}
