package com.grupp5.grupp5sakila.DAO;

import com.grupp5.grupp5sakila.entity.City;
import com.grupp5.grupp5sakila.util.DatabaseSession;
import org.hibernate.Session;

import java.util.List;

public class CityDAO implements DAO<City>{

    private final DatabaseSession dbSession = new DatabaseSession();

    @Override
    public void create(City data) {
        Session session = dbSession.startSession();

        session.persist(data);

        dbSession.endSession(session);
    }

    @Override
    public List readAsList() {
        Session session = dbSession.startSession();
        List<City> cityList = session.createQuery("SELECT c FROM City c", City.class).getResultList();
        dbSession.endSession(session);
        return cityList;
    }

    @Override
    public void update(City data) {
        Session session = dbSession.startSession();
        City city = session.get(City.class, data.getId());

        city.setCity(data.getCity());
        city.setAddresses(data.getAddresses());
        city.setLastUpdate(data.getLastUpdate());
        session.update(city);
        dbSession.endSession(session);

    }

    @Override
    public void delete(City data) {
        Session session = dbSession.startSession();
        City city = session.get(City.class, data.getId());
        session.delete(city);
        dbSession.endSession(session);
    }
}
