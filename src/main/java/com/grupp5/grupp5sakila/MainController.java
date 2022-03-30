package com.grupp5.grupp5sakila;

import com.grupp5.grupp5sakila.DAO.ActorDAO;
import com.grupp5.grupp5sakila.entity.Actor;
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

    @FXML
    private TableColumn<Actor, String> actorFirstname;

    @FXML
    private TableColumn<Actor, String> actorLastname;

    @FXML
    private TableColumn<Actor, Timestamp> actorlastUpdate;

    @FXML
    private TextField actorFirstnametxt, actorLastnametxt;

    @FXML
    private Tab actorTab;

    @FXML
    private TableView actorTableView;

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

    }

    @FXML
    void updateActor(MouseEvent event) {

    }

    @FXML
    void deleteActor(MouseEvent event) {

    }

}
