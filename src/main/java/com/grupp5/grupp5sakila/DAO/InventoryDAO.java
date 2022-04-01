package com.grupp5.grupp5sakila.DAO;

import com.grupp5.grupp5sakila.entity.Inventory;
import com.grupp5.grupp5sakila.util.DatabaseSession;
import org.hibernate.Session;

import java.util.List;

public class InventoryDAO implements DAO<Inventory>{

    private final DatabaseSession dbSession = new DatabaseSession();

    @Override
    public void create(Inventory data) {
        Inventory inventory = new Inventory();
        Session session = dbSession.startSession();
        inventory.setStore(data.getStore());
        inventory.setFilm(data.getFilm());

        session.persist(data);

        dbSession.endSession(session);
    }


    @Override
    public List readAsList() {
        Session session = dbSession.startSession();
        List<Inventory> inventoryList = session.createQuery("SELECT i FROM Inventory i", Inventory.class).getResultList();
        dbSession.endSession(session);
        return inventoryList;
    }

    @Override
    public void update(Inventory data) {
        Session session = dbSession.startSession();
        Inventory inventory = session.get(Inventory.class, data.getId());
        inventory.setStore(data.getStore());
        inventory.setFilm(data.getFilm());
        session.update(inventory);
        dbSession.endSession(session);

    }

    @Override
    public void delete(Inventory data) {
        Session session = dbSession.startSession();
        Inventory inventory = session.get(Inventory.class, data.getId());
        session.delete(inventory);
        dbSession.endSession(session);

    }
}
