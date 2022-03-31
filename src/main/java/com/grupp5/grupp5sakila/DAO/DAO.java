package com.grupp5.grupp5sakila.DAO;
import com.grupp5.grupp5sakila.entity.Actor;

import java.util.List;

public interface DAO <L>{

    void create(L data);

    List<L> readAsList();

    void update(L data);

    void delete(L data);



}
