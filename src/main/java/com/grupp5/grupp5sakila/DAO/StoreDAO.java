package com.grupp5.grupp5sakila.DAO;

import com.grupp5.grupp5sakila.entity.Store;
import com.grupp5.grupp5sakila.util.DatabaseSession;
import org.hibernate.Session;

import java.util.List;

public class StoreDAO implements DAO<Store>{

    private final DatabaseSession dbSession = new DatabaseSession();

    @Override
    public void create(Store data) {
        Store store = new Store();
        Session session = dbSession.startSession();

        store.setManagerStaff(data.getManagerStaff());
        store.setAddress(data.getAddress());

        session.persist(data);
        dbSession.endSession(session);
    }

    @Override
    public List readAsList() {
        Session session = dbSession.startSession();
        List<Store> storeList = session.createQuery("SELECT s FROM Store s", Store.class).getResultList();
        dbSession.endSession(session);
        return storeList;
    }

    @Override
    public void update(Store data) {
        Session session = dbSession.startSession();
        Store store = session.get(Store.class, data.getId());

        store.setManagerStaff(data.getManagerStaff());
        store.setAddress(data.getAddress());
        session.update(store);
        dbSession.endSession(session);
    }

    @Override
    public void delete(Store data) {
        Session session = dbSession.startSession();
        Store store = session.get(Store.class, data.getId());
        session.delete(store);
        dbSession.endSession(session);
    }
}
