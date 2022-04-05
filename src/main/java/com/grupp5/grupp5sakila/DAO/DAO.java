package com.grupp5.grupp5sakila.DAO;

import java.util.List;

public interface DAO <L>{

    void create(L data);

    List<L> readAsList();

    void update(L data);

    void delete(L data);



}
