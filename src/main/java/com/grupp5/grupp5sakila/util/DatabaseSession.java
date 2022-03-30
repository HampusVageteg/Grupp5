package com.grupp5.grupp5sakila.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DatabaseSession {

    private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public Session startSession() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session;
    }

    public void endSession(Session session) {

        Transaction transaction = null;
        try (session) {
            transaction = session.getTransaction();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                System.err.println("Rollback");
            }
        }
        session.close();
    }
}
