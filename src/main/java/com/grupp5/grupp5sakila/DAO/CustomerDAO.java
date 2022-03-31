package com.grupp5.grupp5sakila.DAO;

import com.grupp5.grupp5sakila.entity.Actor;
import com.grupp5.grupp5sakila.entity.Customer;
import com.grupp5.grupp5sakila.util.DatabaseSession;
import org.hibernate.Session;

import java.util.List;

public class CustomerDAO implements DAO<Customer>{

    private final DatabaseSession dbSession = new DatabaseSession();

    @Override
    public void create(Customer data) {

        Session session = dbSession.startSession();

        Customer customer = new Customer();
        customer.setFirstName(data.getFirstName());
        customer.setLastName(data.getLastName());
        customer.setEmail(data.getEmail());

        session.persist(data);

        dbSession.endSession(session);
    }

    @Override
    public List readAsList() {
        Session session = dbSession.startSession();
        List<Customer> customerList = session.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
        dbSession.endSession(session);
        return customerList;
    }

    @Override
    public void update(Customer data) {
        Session session = dbSession.startSession();
        Customer customer = session.get(Customer.class, data.getId());

        customer.setFirstName(data.getFirstName());
        customer.setLastName(data.getLastName());
        customer.setEmail(data.getEmail());
        session.update(customer);
        dbSession.endSession(session);

    }

    @Override
    public void delete(Customer data) {
        Session session = dbSession.startSession();
        Customer customer = session.get(Customer.class, data.getId());
        session.delete(customer);
        dbSession.endSession(session);
    }
}
