package com.grupp5.grupp5sakila.DAO;

import com.grupp5.grupp5sakila.entity.Address;
import com.grupp5.grupp5sakila.entity.City;
import com.grupp5.grupp5sakila.entity.Film;
import com.grupp5.grupp5sakila.util.DatabaseSession;
import org.hibernate.Session;

import java.util.List;

public class FilmDAO implements DAO<Film>{

    private final DatabaseSession dbSession = new DatabaseSession();

    @Override
    public void create(Film data) {
        Session session = dbSession.startSession();
        session.persist(data);

        dbSession.endSession(session);
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
        Session session = dbSession.startSession();

        Film film = session.get(Film.class, data.getId());

        film.setTitle(data.getTitle());
        film.setDescription(data.getDescription());
        film.setReleaseYear(data.getReleaseYear());
        film.setRentalDuration(data.getRentalDuration());
        film.setRentalRate(data.getRentalRate());
        film.setLength(data.getLength());
        film.setReplacementCost(data.getReplacementCost());
        film.setRating(data.getRating());
        film.setSpecialFeatures(data.getSpecialFeatures());

        session.update(film);

        dbSession.endSession(session);
    }

    @Override
    public void delete(Film data) {
        Session session = dbSession.startSession();
        Film film = session.get(Film.class, data.getId());
        session.delete(film);
        dbSession.endSession(session);
    }
}
