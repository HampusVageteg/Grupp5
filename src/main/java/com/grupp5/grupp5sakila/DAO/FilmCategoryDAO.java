package com.grupp5.grupp5sakila.DAO;

import com.grupp5.grupp5sakila.entity.FilmCategory;
import com.grupp5.grupp5sakila.util.DatabaseSession;
import org.hibernate.Session;

import java.util.List;

public class FilmCategoryDAO implements DAO<FilmCategory>{

    private final DatabaseSession dbSession = new DatabaseSession();

    @Override
    public void create(FilmCategory data) {
        Session session = dbSession.startSession();
        session.merge(data);
        dbSession.endSession(session);
    }

    @Override
    public List<FilmCategory> readAsList() {
        Session session = dbSession.startSession();
        List<FilmCategory> filmCategories = session.createQuery("SELECT fc FROM FilmCategory fc", FilmCategory.class).getResultList();
        dbSession.endSession(session);
        return filmCategories;
    }

    @Override
    public void update(FilmCategory data) {

    }

    @Override
    public void delete(FilmCategory data) {

    }
}
