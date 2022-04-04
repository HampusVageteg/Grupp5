package com.grupp5.grupp5sakila.DAO;

import com.grupp5.grupp5sakila.entity.Category;
import com.grupp5.grupp5sakila.util.DatabaseSession;
import org.hibernate.Session;

import java.util.List;

public class CategoryDAO implements DAO<Category> {

    private final DatabaseSession dbSession = new DatabaseSession();

    @Override
    public void create(Category data) {

    }

    @Override
    public List<Category> readAsList() {
        Session session = dbSession.startSession();
        List<Category> categoryList = session.createQuery("SELECT c FROM Category c", Category.class).getResultList();
        dbSession.endSession(session);
        return categoryList;
    }

    @Override
    public void update(Category data) {

    }

    @Override
    public void delete(Category data) {

    }
}
