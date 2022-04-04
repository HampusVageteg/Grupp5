package com.grupp5.grupp5sakila.DAO;

import com.grupp5.grupp5sakila.entity.Language;
import com.grupp5.grupp5sakila.util.DatabaseSession;
import org.hibernate.Session;

import java.util.List;

public class LanguageDAO implements DAO<Language>{

    private final DatabaseSession dbSession = new DatabaseSession();

    @Override
    public void create(Language data) {

    }

    @Override
    public List<Language> readAsList() {
        Session session = dbSession.startSession();
        List<Language> languageList = session.createQuery("SELECT l FROM Language l", Language.class).getResultList();
        dbSession.endSession(session);
        return languageList;
    }

    @Override
    public void update(Language data) {

    }

    @Override
    public void delete(Language data) {

    }
}
