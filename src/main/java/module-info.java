module com.grupp5.grupp5sakila {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.grupp5.grupp5sakila to javafx.fxml;
    exports com.grupp5.grupp5sakila;
}