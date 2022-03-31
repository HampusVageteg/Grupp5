package com.grupp5.grupp5sakila.DAO;

import com.grupp5.grupp5sakila.entity.Address;
import com.grupp5.grupp5sakila.entity.Customer;
import com.grupp5.grupp5sakila.util.DatabaseSession;
import org.hibernate.Session;

import java.util.List;

public class AddressDAO implements DAO<Address>{

    private final DatabaseSession dbSession = new DatabaseSession();

    @Override
    public void create(Address data) {

    }

    @Override
    public List readAsList() {
        Session session = dbSession.startSession();
        List<Address> addressList = session.createQuery("SELECT a FROM Address a", Address.class).getResultList();
        dbSession.endSession(session);
        return addressList;

    }

    @Override
    public void update(Address data) {

    }

    @Override
    public void delete(Address data) {

    }
}
