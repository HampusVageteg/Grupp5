package com.grupp5.grupp5sakila.DAO;

import com.grupp5.grupp5sakila.entity.Rental;
import com.grupp5.grupp5sakila.util.DatabaseSession;
import org.hibernate.Session;

import java.util.List;

public class RentalDAO implements DAO<Rental>{

    private final DatabaseSession dbSession = new DatabaseSession();

    @Override
    public void create(Rental data) {

        Session session = dbSession.startSession();
        session.persist(data);
        dbSession.endSession(session);
    }

    @Override
    public List<Rental> readAsList() {
        Session session = dbSession.startSession();
        List<Rental> rentalList = session.createQuery("SELECT r FROM Rental r", Rental.class).getResultList();
        dbSession.endSession(session);
        return rentalList;
    }

    @Override
    public void update(Rental data) {

        Session session = dbSession.startSession();
        Rental rental = session.get(Rental.class, data.getId());

        rental.setRentalDate(data.getRentalDate());
        rental.setReturnDate(data.getReturnDate());
        session.update(rental);
        dbSession.endSession(session);

    }

    @Override
    public void delete(Rental data) {
        Session session = dbSession.startSession();
        Rental rental = session.get(Rental.class, data.getId());
        session.delete(rental);
        dbSession.endSession(session);

    }
}
