package com.grupp5.grupp5sakila.DAO;

import com.grupp5.grupp5sakila.entity.Payment;
import com.grupp5.grupp5sakila.util.DatabaseSession;
import org.hibernate.Session;

import java.util.List;

public class PaymentDAO implements DAO<Payment>{

    private final DatabaseSession dbSession = new DatabaseSession();

    @Override
    public void create(Payment data) {
        Session session = dbSession.startSession();

        session.persist(data);
        dbSession.endSession(session);

    }

    @Override
    public List<Payment> readAsList() {
        Session session = dbSession.startSession();
        List<Payment> paymentList = session.createQuery("SELECT p FROM Payment p", Payment.class).getResultList();
        dbSession.endSession(session);

        return paymentList;
    }

    @Override
    public void update(Payment data) {
        Session session = dbSession.startSession();
        Payment payment = session.get(Payment.class, data.getId());

        payment.setAmount(data.getAmount());

        session.update(payment);
        dbSession.endSession(session);

    }

    @Override
    public void delete(Payment data) {
        Session session = dbSession.startSession();
        Payment payment = session.get(Payment.class, data.getId());
        session.delete(payment);
        dbSession.endSession(session);

    }
}
