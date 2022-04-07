module com.grupp5.grupp5sakila {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    //requires javax.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.sql;
    requires java.persistence;

    opens com.grupp5.grupp5sakila to javafx.fxml;
    opens com.grupp5.grupp5sakila.entity;
    opens com.grupp5.grupp5sakila.DAO;

    exports com.grupp5.grupp5sakila.DAO;
    exports com.grupp5.grupp5sakila.entity;
    exports com.grupp5.grupp5sakila;
    exports com.grupp5.grupp5sakila.ui;
    opens com.grupp5.grupp5sakila.ui to javafx.fxml;
}