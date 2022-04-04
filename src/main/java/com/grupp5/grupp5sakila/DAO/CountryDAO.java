package com.grupp5.grupp5sakila.DAO;

import com.grupp5.grupp5sakila.entity.City;
import com.grupp5.grupp5sakila.entity.Country;
import com.grupp5.grupp5sakila.util.DatabaseSession;
import org.hibernate.Session;

import java.util.List;

public class CountryDAO implements DAO<Country> {

    private final DatabaseSession dbSession = new DatabaseSession();

    @Override
    public void create(Country data) {

    }

    @Override
    public List<Country> readAsList() {
        Session session = dbSession.startSession();
        List<Country> countryList = session.createQuery("SELECT c FROM Country c", Country.class).getResultList();
        dbSession.endSession(session);
        return countryList;
    }

    @Override
    public void update(Country data) {

    }

    @Override
    public void delete(Country data) {

    }
}
