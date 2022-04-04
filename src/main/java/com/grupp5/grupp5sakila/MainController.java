package com.grupp5.grupp5sakila;

import com.grupp5.grupp5sakila.DAO.*;
import com.grupp5.grupp5sakila.entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

public class MainController {

    ActorDAO acDAO = new ActorDAO();
    CustomerDAO cusDAO = new CustomerDAO();
    AddressDAO adDAO = new AddressDAO();
    StoreDAO storeDAO = new StoreDAO();
    CityDAO cityDAO = new CityDAO();
    StaffDAO staffDAO = new StaffDAO();
    RentalDAO rentalDAO = new RentalDAO();
    InventoryDAO inventoryDAO = new InventoryDAO();
    PaymentDAO payDAO = new PaymentDAO();
    CountryDAO countryDAO = new CountryDAO();
    LanguageDAO languageDAO = new LanguageDAO();
    CategoryDAO categoryDAO = new CategoryDAO();
    FilmDAO filmDAO = new FilmDAO();

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
    private TableColumn<Category, Integer> categoryIdCol;

    @FXML
    private TableColumn<Category, Timestamp> categoryLastUpdateCol;

    @FXML
    private TableColumn<Category, String> categoryNameCol;

    @FXML
    private TableView<Category> categoryTableView;


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
    private TableColumn<City, Integer> cityCol;

    @FXML
    private TableColumn<City, Integer> cityCountryIdCol;

    @FXML
    private TableColumn<City, Integer> cityIdCol;

    @FXML
    private TableColumn<City, Timestamp> cityLastUpdateCol;

    @FXML
    private TableView<City> cityTableView;

    @FXML
    private TableColumn<Country, Integer> countryCol;

    @FXML
    private TableColumn<Country, Integer> countryIdCol;

    @FXML
    private TableColumn<Country, Timestamp> countryLastUpdateCol;

    @FXML
    private TableView<Country> countryTableView;

    @FXML
    private TableColumn<Film, String> filmDescCol;

    @FXML
    private TableColumn<Film, Timestamp> filmLastUpdateCol;

    @FXML
    private TableColumn<Film, Integer> filmLengthCol;

    @FXML
    private TableColumn<Film, String> filmRatingCol;

    @FXML
    private TableColumn<Film, Integer> filmReleaseYearCol;

    @FXML
    private TableColumn<Film, Integer> filmRentalDurCol;

    @FXML
    private TableColumn<Film, Double> filmRentalRateCol;

    @FXML
    private TableColumn<Film, Double> filmReplCostCol;

    @FXML
    private TableColumn<Film, String> filmSpecFeaCol;

    @FXML
    private TableView<Film> filmTableView;

    @FXML
    private TableColumn<Film, String> filmTitleCol;

    @FXML
    private TextField filmRatingtxt, filmReleaseYeartxt, filmRentalDurtxt, filmRentalRatetxt, filmReplacementtxt, filmTitletxt, filmLengthtxt, filmSpecialtxt, filmDescripttxt;

    @FXML
    private TableColumn<Inventory, Integer> inventoryFilmIdCol;

    @FXML
    private TableColumn<Inventory, Integer> inventoryIdCol;

    @FXML
    private TableColumn<Inventory, Timestamp> inventoryLastUpdateCol;

    @FXML
    private TableColumn<Inventory, Integer> inventoryStoreIdCol;

    @FXML
    private TableView<Inventory> inventoryTableView;


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
    private TableColumn<Language, Integer> languageIdCol;

    @FXML
    private TableColumn<Language, Timestamp> languageLastUpdateCol;

    @FXML
    private TableColumn<Language, String> languageNameCol;

    @FXML
    private TableView<Language> languageTableView;


    @FXML
    private TableView<Rental> rentalTableView;
    @FXML
    private TableColumn<Rental, Timestamp> rentalDate;

    @FXML
    private TextField rentalDatetxt;

    @FXML
    private TableColumn<Rental, Timestamp> rentalLastupdate;

    @FXML
    private DatePicker rentalRentalDate;

    @FXML
    private TableColumn<Rental, LocalDate> rentalReturndate;

    @FXML
    private TableColumn<Payment, Double> paymentAmount;

    @FXML
    private TableColumn<Payment, Timestamp> paymentDate;

    @FXML
    private TableColumn<Payment, Timestamp> paymentLastUpdate;

    @FXML
    private TableView<Payment> paymentTableView;


    @FXML
    private TableColumn<Payment, Integer> paymentCustIdCol;

    @FXML
    private TableColumn<Payment, Integer> paymentIdCol;

    @FXML
    private TableColumn<Payment, Integer> paymentRentalIdCol;

    @FXML
    private TableColumn<Payment, Integer> paymentStaffIdCol;

    @FXML
    private TextField amounttxt;

    @FXML
    private TableColumn<Staff, Boolean> staffActive;

    @FXML
    private TextField staffActivetxt;

    @FXML
    private TableColumn<Staff, String> staffEmail;

    @FXML
    private TextField staffEmailtxt;

    @FXML
    private TableColumn<Staff, String> staffFirstName;

    @FXML
    private TextField staffFirstnametxt;

    @FXML
    private TableColumn<Staff, String> staffLastName;

    @FXML
    private TextField staffLastnametxt;

    @FXML
    private TableColumn<Staff, Timestamp> staffLastupdate;

    @FXML
    private TableColumn<Staff, String> staffPassword;

    @FXML
    private TextField staffPasswordtxt;

    @FXML
    private TableView<Staff> staffTableView;

    @FXML
    private TableColumn<Staff, String> staffUsername;

    @FXML
    private TextField staffUsernametxt;

    @FXML
    private TableColumn<Store, Integer> storeAddressIdCol;

    @FXML
    private TableColumn<Store, Integer> storeIdCol;

    @FXML
    private TableColumn<Store, Timestamp> storeLastUpdateCol;

    @FXML
    private TableColumn<Store, Integer> storeManagerStaffIdCol;

    @FXML
    private TableView<Store> storeTableView;


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
        Address address = new Address(addresstext.getText(), addressDistrictText.getText(), addressPostcodeText.getText(), addressPhoneText.getText(), cityChoiceBox.getValue());
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
        Customer customer = new Customer(customerFirstnametxt.getText(), customerLastnametxt.getText(), customerEmailtxt.getText(), addressChoice.getValue(), storeChoice.getValue());
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

        customerAdressList.addAll(adDAO.readAsList());
        customerStoreList.addAll(storeDAO.readAsList());
        addressChoice.setItems(customerAdressList);
        storeChoice.setItems(customerStoreList);
        customerTableView.setItems(FXCollections.observableList(cusDAO.readAsList()));
    }

    @FXML
    void deleteCustomer(MouseEvent event) {
        Customer customer = customerTableView.getSelectionModel().getSelectedItem();
        cusDAO.delete(customer);
        customerTableView.setItems(FXCollections.observableArrayList(cusDAO.readAsList()));
    }


    @FXML
    void addFilm(MouseEvent event) {
        Film film = new Film(filmTitletxt.getText(),
                filmDescripttxt.getText(),
                Integer.parseInt(filmReleaseYeartxt.getText()),
                Integer.parseInt(filmLengthtxt.getText()),
                Double.parseDouble(filmRentalRatetxt.getText()),
                Integer.parseInt(filmRentalDurtxt.getText()),
                Double.parseDouble(filmReplacementtxt.getText()),
                filmRatingtxt.getText(),
                filmSpecialtxt.getText());
        film.setLanguage(new Language(1));
        filmDAO.create(film);
        filmTableView.setItems(FXCollections.observableArrayList(filmDAO.readAsList()));
    }

    @FXML
    void getFilms(MouseEvent event) {
        filmTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        filmDescCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        filmReleaseYearCol.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));
        filmRentalDurCol.setCellValueFactory(new PropertyValueFactory<>("rentalDuration"));
        filmRentalRateCol.setCellValueFactory(new PropertyValueFactory<>("rentalRate"));
        filmLengthCol.setCellValueFactory(new PropertyValueFactory<>("length"));
        filmReplCostCol.setCellValueFactory(new PropertyValueFactory<>("replacementCost"));
        filmRatingCol.setCellValueFactory(new PropertyValueFactory<>("rating"));
        filmSpecFeaCol.setCellValueFactory(new PropertyValueFactory<>("specialFeatures"));
        filmLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

        filmTableView.setItems(FXCollections.observableArrayList(filmDAO.readAsList()));
    }

    @FXML
    void deleteFilm(MouseEvent event) {
        Film film = filmTableView.getSelectionModel().getSelectedItem();
        filmDAO.delete(film);
        filmTableView.setItems(FXCollections.observableArrayList(filmDAO.readAsList()));
    }
    @FXML
    void updateFilm(MouseEvent event) {
        Film film = new Film();
        film.setId(filmTableView.getSelectionModel().getSelectedItem().getId());
        film.setTitle(filmTitletxt.getText());
        film.setDescription(filmDescripttxt.getText());
        film.setReleaseYear(Integer.valueOf(filmReleaseYeartxt.getText()));
        film.setRentalDuration(Integer.valueOf(filmRentalDurtxt.getText()));
        film.setRentalRate(Double.valueOf(filmRentalRatetxt.getText()));
        film.setLength(Integer.valueOf(filmLengthtxt.getText()));
        film.setReplacementCost(Double.valueOf(filmReplacementtxt.getText()));
        film.setRating(filmRatingtxt.getText());
        film.setSpecialFeatures(filmSpecialtxt.getText());
        filmDAO.update(film);
        filmTableView.setItems(FXCollections.observableArrayList(filmDAO.readAsList()));
    }
    @FXML
    void editCurrentFilm(MouseEvent event){
        Film film = filmTableView.getSelectionModel().getSelectedItem();
        filmTitletxt.setText(film.getTitle());
        filmDescripttxt.setText(film.getDescription());
        filmReleaseYeartxt.setText(String.valueOf(film.getReleaseYear()));
        filmLengthtxt.setText(String.valueOf(film.getLength()));
        filmRentalDurtxt.setText(String.valueOf(film.getRentalDuration()));
        filmRentalRatetxt.setText(String.valueOf(film.getRentalRate()));
        filmReplacementtxt.setText(String.valueOf(film.getReplacementCost()));
        filmRatingtxt.setText(film.getRating());
        filmSpecialtxt.setText(film.getSpecialFeatures());

    }
    @FXML
    void getRental(MouseEvent event) {
        rentalDate.setCellValueFactory(new PropertyValueFactory<>("rentalDate"));
        rentalReturndate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        rentalLastupdate.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        rentalTableView.setItems(FXCollections.observableArrayList(rentalDAO.readAsList()));
    }
    @FXML
    void addRental(MouseEvent event) {

    }

    @FXML
    void updateRental(MouseEvent event) {

    }

    @FXML
    void editCurrentRental(MouseEvent event) {

    }

    @FXML
    void deleteRental(MouseEvent event) {

    }

    @FXML
    void getPayment(MouseEvent event) {
        paymentAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        paymentDate.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        paymentLastUpdate.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        paymentCustIdCol.setCellValueFactory(new PropertyValueFactory<>("customer"));
        paymentStaffIdCol.setCellValueFactory(new PropertyValueFactory<>("staff"));
        paymentRentalIdCol.setCellValueFactory(new PropertyValueFactory<>("rental"));
        paymentIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        paymentTableView.setItems(FXCollections.observableArrayList(payDAO.readAsList()));

    }

    @FXML
    void addPayment(MouseEvent event) {
        Payment payment = new Payment(Double.parseDouble(amounttxt.getText()));
        payDAO.create(payment);
        paymentTableView.setItems(FXCollections.observableArrayList(payDAO.readAsList()));

    }

    @FXML
    void deletePayment(MouseEvent event) {

    }

    @FXML
    void editCurrentPayment(MouseEvent event) {
        Payment payment = paymentTableView.getSelectionModel().getSelectedItem();
        amounttxt.setText(String.valueOf(payment.getAmount()));


    }

    @FXML
    void updatePayment(MouseEvent event) {
        Payment payment = new Payment();
        payment.setId(paymentTableView.getSelectionModel().getSelectedItem().getId());
        payment.setAmount(Double.valueOf(amounttxt.getText()));

        payDAO.update(payment);
        paymentTableView.setItems(FXCollections.observableArrayList(payDAO.readAsList()));

    }

    @FXML
    void getStaff(MouseEvent event) {
        staffFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        staffLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        staffEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        staffActive.setCellValueFactory(new PropertyValueFactory<>("active"));
        staffUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        staffPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        staffLastupdate.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

        staffTableView.setItems(FXCollections.observableArrayList(staffDAO.readAsList()));

    }

    @FXML
    void addStaff(MouseEvent event) {

    }

    @FXML
    void deleteStaff(MouseEvent event) {

    }

    @FXML
    void editCurrentStaff(MouseEvent event) {

    }


    @FXML
    void updateStaff(MouseEvent event) {

    }

    @FXML
    void getStores(MouseEvent event) {
        storeIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        storeManagerStaffIdCol.setCellValueFactory(new PropertyValueFactory<>("managerStaff"));
        storeAddressIdCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        storeLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

        storeTableView.setItems(FXCollections.observableArrayList(storeDAO.readAsList()));

    }

    @FXML
    void addStore(MouseEvent event) {

    }

    @FXML
    void deleteStore(MouseEvent event) {

    }

    @FXML
    void editCurrentStore(MouseEvent event) {

    }

    @FXML
    void updateStore(MouseEvent event) {

    }

    @FXML
    void getInventory(MouseEvent event) {
        inventoryIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        inventoryFilmIdCol.setCellValueFactory(new PropertyValueFactory<>("film"));
        inventoryStoreIdCol.setCellValueFactory(new PropertyValueFactory<>("store"));
        inventoryLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

        inventoryTableView.setItems(FXCollections.observableArrayList(inventoryDAO.readAsList()));
    }

    @FXML
    void addInventory(MouseEvent event) {

    }

    @FXML
    void deleteInventory(MouseEvent event) {

    }

    @FXML
    void editCurrentInventory(MouseEvent event) {

    }

    @FXML
    void updateInventory(MouseEvent event) {
    }

    @FXML
    void getCity(MouseEvent event) {
        cityIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        cityCol.setCellValueFactory(new PropertyValueFactory<>("city"));
        cityCountryIdCol.setCellValueFactory(new PropertyValueFactory<>("country"));
        cityLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

        cityTableView.setItems(FXCollections.observableArrayList(cityDAO.readAsList()));

    }

    @FXML
    void addCity(MouseEvent event) {

    }

    @FXML
    void deleteCity(MouseEvent event) {

    }

    @FXML
    void editCurrentCity(MouseEvent event) {

    }

    @FXML
    void updateCity(MouseEvent event) {

    }

    @FXML
    void getCountry(MouseEvent event) {
        countryIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
        countryLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

        countryTableView.setItems(FXCollections.observableArrayList(countryDAO.readAsList()));
    }

    @FXML
    void getLanguage(MouseEvent event) {
        languageIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        languageNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        languageLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

        languageTableView.setItems(FXCollections.observableArrayList(languageDAO.readAsList()));

    }

    @FXML
    void getCategory(MouseEvent event) {
        categoryIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        categoryNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

        categoryTableView.setItems(FXCollections.observableArrayList(categoryDAO.readAsList()));

    }
}
