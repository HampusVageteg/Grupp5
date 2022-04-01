package com.grupp5.grupp5sakila.DAO;

import com.grupp5.grupp5sakila.entity.Staff;
import com.grupp5.grupp5sakila.entity.Store;
import com.grupp5.grupp5sakila.util.DatabaseSession;
import org.hibernate.Session;

import java.util.List;

public class StaffDAO implements DAO<Staff> {

    private final DatabaseSession dbSession = new DatabaseSession();

    @Override
    public void create(Staff data) {
        Staff staff = new Staff();
        Session session = dbSession.startSession();

        staff.setFirstName(data.getFirstName());
        staff.setLastName(data.getLastName());
        staff.setEmail(data.getEmail());
        staff.setActive(data.getActive());
        staff.setUsername(data.getUsername());
        staff.setPassword(data.getPassword());

        session.persist(data);
        dbSession.endSession(session);
    }

    @Override
    public List readAsList() {
        Session session = dbSession.startSession();
        List<Staff> staffList = session.createQuery("SELECT s FROM Staff s", Staff.class).getResultList();
        dbSession.endSession(session);
        return staffList;
    }

    @Override
    public void update(Staff data) {
        Session session = dbSession.startSession();
        Staff staff = session.get(Staff.class, data.getId());

        staff.setFirstName(data.getFirstName());
        staff.setLastName(data.getLastName());
        staff.setEmail(data.getEmail());
        staff.setActive(data.getActive());
        staff.setUsername(data.getUsername());
        staff.setPassword(data.getPassword());
        session.update(staff);
        dbSession.endSession(session);
    }

    @Override
    public void delete(Staff data) {
        Session session = dbSession.startSession();
        Staff staff = session.get(Staff.class, data.getId());
        session.delete(staff);
        dbSession.endSession(session);
    }
}
