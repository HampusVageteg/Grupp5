package com.grupp5.grupp5sakila;

import com.grupp5.grupp5sakila.DAO.ActorDAO;
import com.grupp5.grupp5sakila.DAO.CustomerDAO;
import com.grupp5.grupp5sakila.entity.Actor;
import com.grupp5.grupp5sakila.entity.Customer;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


import java.sql.Timestamp;

public class MainController {

    ActorDAO acDAO = new ActorDAO();
    CustomerDAO cusDAO = new CustomerDAO();

    @FXML
    private TableView<Actor> actorTableView = new TableView<>();

     @FXML
     private TableView<Customer> customerTableView = new TableView<>();

    @FXML
    private TableColumn<Actor, String> actorFirstname;

    @FXML
    private TableColumn<Actor, String> actorLastname;

    @FXML
    private TableColumn<Actor, Timestamp> actorlastUpdate;

    @FXML
    private TableColumn<Customer, String> customerFirstname;

    @FXML
    private TableColumn<Customer, String> customerLastname;

    @FXML
    private TableColumn<Customer, String> customerEmail;

    @FXML
    private TableColumn<Customer, Timestamp> customerLastUpdate;



    @FXML
    private TextField actorFirstnametxt, actorLastnametxt;

    @FXML
    private TextField customerFirstnametxt, customerLastnametxt, customerEmailtxt;

    @FXML
    private Tab actorTab;

  /*  @FXML
    private TableView actorTableView;*/


    @FXML
    void getActors(MouseEvent event) {
        actorFirstname.setCellValueFactory(new PropertyValueFactory<Actor, String>("firstName"));
        actorLastname.setCellValueFactory(new PropertyValueFactory<Actor, String>("lastName"));
        actorlastUpdate.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

        actorTableView.getItems().addAll(acDAO.readAsList());
    }

    @FXML
    void addActor(MouseEvent event) {
        Actor actor = new Actor();

        actor.setFirstName(actorFirstnametxt.getText());
        actor.setLastName(actorLastnametxt.getText());

        acDAO.create(actor);
        actorTableView.setItems(FXCollections.observableArrayList(acDAO.readAsList()));
    }

    @FXML
    void editCurrentActor(MouseEvent event) {
        Actor actor = actorTableView.getSelectionModel().getSelectedItem();
        actorFirstnametxt.setText(actor.getFirstName());
        actorLastnametxt.setText(actor.getLastName());
    }

    @FXML
    void updateActor(MouseEvent event) {

        Actor actor = new Actor();
        actor.setId(actorTableView.getSelectionModel().getSelectedItem().getId());
        actor.setFirstName(actorFirstnametxt.getText());
        actor.setLastName(actorLastnametxt.getText());
        acDAO.update(actor);
        actorTableView.setItems(FXCollections.observableArrayList(acDAO.readAsList()));
    }

    @FXML
    void deleteActor(MouseEvent event) {
        Actor actor = actorTableView.getSelectionModel().getSelectedItem();
        acDAO.delete(actor);
        actorTableView.setItems(FXCollections.observableArrayList(acDAO.readAsList()));

    }

    @FXML
    void addCustomer(MouseEvent event) {

    }

    @FXML
    void editCurrentCustomer(MouseEvent event) {

    }

    @FXML
    void updateCustomer(MouseEvent event) {

    }


    @FXML
    void getCustomers(MouseEvent event) {
        customerFirstname.setCellValueFactory(new PropertyValueFactory<Customer, String>("firstName"));
        customerLastname.setCellValueFactory(new PropertyValueFactory<Customer, String>("lastName"));
        customerEmail.setCellValueFactory(new PropertyValueFactory<Customer, String>("email"));
        customerLastUpdate.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

        customerTableView.getItems().addAll(cusDAO.readAsList());
    }

    @FXML
    void deleteCustomer(MouseEvent event) {

    }

}
