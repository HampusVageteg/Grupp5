package com.grupp5.grupp5sakila;

import com.grupp5.grupp5sakila.DAO.*;
import com.grupp5.grupp5sakila.entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


import java.sql.Timestamp;

public class MainController {

    ActorDAO acDAO = new ActorDAO();
    CustomerDAO cusDAO = new CustomerDAO();
    AddressDAO adDAO = new AddressDAO();
    StoreDAO storeDAO = new StoreDAO();
    CityDAO cityDAO = new CityDAO();
    StaffDAO staffDAO = new StaffDAO();
    RentalDAO rentalDAO = new RentalDAO();
    InventoryDAO inventoryDAO = new InventoryDAO();


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
    private TableColumn<Address, String> address;

    @FXML
    private TableColumn<Address, String> addressDistrict;

    @FXML
    private TextField addressDistrictText, addressPhoneText, addressPostcodeText, addresstext;

    @FXML
    private TableColumn<Address, Timestamp> addressLastUpdate;

    @FXML
    private TableColumn<Address, String> addressPhone;

    @FXML
    private TableColumn<Address, String> addressPostcode;

    @FXML
    private Tab addressTab;

    @FXML
    private TableView<Address> addressTableView;


    @FXML
    private TableColumn<Customer, String> customerFirstname;

    @FXML
    private TableColumn<Customer, String> customerLastname;

    @FXML
    private TableColumn<Customer, String> customerEmail;

    @FXML
    private TableColumn<Customer, Timestamp> customerLastUpdate;

    @FXML
    private TableColumn<Customer, Timestamp> customerCreated;

    @FXML
    private ChoiceBox<Address> addressChoice;

    @FXML
    private ChoiceBox<Store> storeChoice;

    @FXML
    private ChoiceBox<City> cityChoiceBox;



    @FXML
    private TextField actorFirstnametxt, actorLastnametxt;

    @FXML
    private TextField customerFirstnametxt, customerLastnametxt, customerEmailtxt;

    @FXML
    private Tab actorTab;

  /*  @FXML
    private TableView actorTableView;*/

    ObservableList<Address> customerAdressList = FXCollections.observableArrayList();
    ObservableList<Store> customerStoreList = FXCollections.observableArrayList();
    ObservableList<City> cityList = FXCollections.observableArrayList();

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
    void addAddress(MouseEvent event) {
        Address address = new Address(addresstext.getText(),addressDistrictText.getText(),addressPostcodeText.getText(), addressPhoneText.getText(), cityChoiceBox.getValue());
        adDAO.create(address);
        addressTableView.setItems(FXCollections.observableArrayList(adDAO.readAsList()));
    }

    @FXML
    void deleteAddress(MouseEvent event) {
        Address address = addressTableView.getSelectionModel().getSelectedItem();
        adDAO.delete(address);
        addressTableView.setItems(FXCollections.observableArrayList(adDAO.readAsList()));
    }

    @FXML
    void editCurrentAddress(MouseEvent event) {
        Address address = addressTableView.getSelectionModel().getSelectedItem();
        addresstext.setText(address.getAddress());
        addressDistrictText.setText(address.getDistrict());
        addressPostcodeText.setText(address.getPostalCode());
        addressPhoneText.setText(address.getPhone());

    }

    @FXML
    void getAddresses(MouseEvent event) {
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        addressDistrict.setCellValueFactory(new PropertyValueFactory<>("district"));
        addressPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        addressPostcode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        addressLastUpdate.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

        addressTableView.getItems().addAll(adDAO.readAsList());
        cityList.addAll(cityDAO.readAsList());
        cityChoiceBox.setItems(cityList);
    }

    @FXML
    void updateAddress(MouseEvent event) {

        Address address = new Address();
        address.setId(addressTableView.getSelectionModel().getSelectedItem().getId());
        address.setAddress(addresstext.getText());
        address.setDistrict(addressDistrictText.getText());
        address.setPhone(addressPhoneText.getText());
        address.setPostalCode(addressPostcodeText.getText());
        adDAO.update(address);
        addressTableView.setItems(FXCollections.observableArrayList(adDAO.readAsList()));
    }

    @FXML
    void addCustomer(MouseEvent event) {
        Customer customer = new Customer(customerFirstnametxt.getText(),customerLastnametxt.getText(),customerEmailtxt.getText(), addressChoice.getValue(), storeChoice.getValue());
        cusDAO.create(customer);
        customerTableView.setItems(FXCollections.observableArrayList(cusDAO.readAsList()));
    }

    @FXML
    void editCurrentCustomer(MouseEvent event) {
        Customer customer = customerTableView.getSelectionModel().getSelectedItem();
        customerFirstnametxt.setText(customer.getFirstName());
        customerLastnametxt.setText(customer.getLastName());
        customerEmailtxt.setText(customer.getEmail());
    }

    @FXML
    void updateCustomer(MouseEvent event) {
        Customer customer = new Customer();
        customer.setId(customerTableView.getSelectionModel().getSelectedItem().getId());
        customer.setFirstName(customerFirstnametxt.getText());
        customer.setLastName(customerLastnametxt.getText());
        customer.setEmail(customerEmailtxt.getText());
        cusDAO.update(customer);
        customerTableView.setItems(FXCollections.observableArrayList(cusDAO.readAsList()));
    }


    @FXML
    void getCustomers(MouseEvent event) {
        customerFirstname.setCellValueFactory(new PropertyValueFactory<Customer, String>("firstName"));
        customerLastname.setCellValueFactory(new PropertyValueFactory<Customer, String>("lastName"));
        customerEmail.setCellValueFactory(new PropertyValueFactory<Customer, String>("email"));
        customerLastUpdate.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        customerCreated.setCellValueFactory(new PropertyValueFactory<>("createDate"));

        customerTableView.getItems().addAll(cusDAO.readAsList());
        customerAdressList.addAll(adDAO.readAsList());
        customerStoreList.addAll(storeDAO.readAsList());
        addressChoice.setItems(customerAdressList);
        storeChoice.setItems(customerStoreList);
    }

    @FXML
    void deleteCustomer(MouseEvent event) {
        Customer customer = customerTableView.getSelectionModel().getSelectedItem();
        cusDAO.delete(customer);
        customerTableView.setItems(FXCollections.observableArrayList(cusDAO.readAsList()));
    }

}
