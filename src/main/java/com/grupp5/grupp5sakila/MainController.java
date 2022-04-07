package com.grupp5.grupp5sakila;

import com.grupp5.grupp5sakila.DAO.*;
import com.grupp5.grupp5sakila.entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

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
    FilmActorDAO filmActorDAO = new FilmActorDAO();

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
    private Tab rentalInfoTab;

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
    private ChoiceBox<Actor> filmActorBox;

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
    private TableColumn<FilmActor, Integer> filmActorFilmIdCol;

    @FXML
    private TableColumn<FilmActor, Timestamp> filmActorLastupdateCol;

    @FXML
    private TableView<FilmActor> filmActorTableView;

    @FXML
    private TableColumn<FilmActor, Integer> filmActoractorIdCol;

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
    private ChoiceBox<Film> inventoryFilmBox;

    @FXML
    private ChoiceBox<Store> inventoryStoreBox;


    @FXML
    private ChoiceBox<Address> addressChoice;

    @FXML
    private ChoiceBox<Store> storeChoice;

    @FXML
    private TextField searchbar;

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
    private TableColumn<Rental, Integer> rentalCustomerIdCol;

    @FXML
    private TableColumn<Rental, Integer> rentalIdCol;

    @FXML
    private TableColumn<Rental, Integer> rentalInventoryIdCol;

    @FXML
    private TableColumn<Rental, Integer> rentalStaffIdCol;

    @FXML
    private TableView<Rental> rentalTableView;

    @FXML
    private TableColumn<Rental, Timestamp> rentalDate;

    @FXML
    private TextField rentalDatetxt;

    @FXML
    private TableColumn<Rental, Timestamp> rentalLastupdate;

    @FXML
    private DatePicker rentalReturnDate;

    @FXML
    private DatePicker rentalDateP;

    @FXML
    private TableColumn<Rental, LocalDate> rentalReturndate;

    @FXML
    private DatePicker rentalDatePicker;

    @FXML
    private ChoiceBox<Customer> rentalCustomerBox;

    @FXML
    private ChoiceBox<Inventory> rentalInventoryBox;

    @FXML
    private ChoiceBox<Staff> rentalStaffBox;

    @FXML
    private TableColumn<Film, String> rentalTitleCol;

    @FXML
    private TableColumn<Film, String> rentalDescCol;

    @FXML
    private TableColumn<Film, Integer> rentalDurCol;

    @FXML
    private TableColumn<Film, Integer> rentalLengthCol;

    @FXML
    private TableColumn<Film, Double> rentalRateCol;

    @FXML
    private TableColumn<Film, String> rentalRatingCol;

    @FXML
    private TableColumn<Film, Integer> rentalReleaseYCol;

    @FXML
    private TableView<Film> rentalFilmTableView;

    @FXML
    private TableColumn<Film, Double> rentalReplCostCol;
    
    @FXML
    private TableColumn<Film, String> rentalSpecCol;

    @FXML
    private TextField rentalSearchBar;

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
    private ChoiceBox<Address> staffAddressBox;

    @FXML
    private ChoiceBox<Store> staffStoreBox;

    @FXML
    private TableColumn<Staff, Integer> staffIdCol;

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

    @FXML
    private ChoiceBox<Staff> storeManagerStaffBox;

    @FXML
    private ChoiceBox<Address> storeAddressBox;


  /*  @FXML
    private TableView actorTableView;*/

    ObservableList<Address> customerAdressList = FXCollections.observableArrayList();
    ObservableList<Store> customerStoreList = FXCollections.observableArrayList();
    ObservableList<City> cityList = FXCollections.observableArrayList();
    ObservableList<Staff> staffList = FXCollections.observableArrayList();
    ObservableList<Address> storeAddressList = FXCollections.observableArrayList();
    ObservableList<Address> staffAddressList = FXCollections.observableArrayList();
    ObservableList<Store> staffStoreList = FXCollections.observableArrayList();
    ObservableList<Film> inventoryFilmList = FXCollections.observableArrayList();
    ObservableList<Store> inventoryStoreList = FXCollections.observableArrayList();
    ObservableList<Actor> filmActorList = FXCollections.observableArrayList();
    ObservableList<Customer> rentalCustomerList = FXCollections.observableArrayList();
    ObservableList<Inventory> rentalInventoryList = FXCollections.observableArrayList();
    ObservableList<Staff> rentalStaffList = FXCollections.observableArrayList();

    @FXML
    void searchFilmList(KeyEvent event) {
        List<Film> listOfFilms = filmDAO.searchFilmList(searchbar.getText());

        filmTableView.setItems(FXCollections.observableArrayList(listOfFilms));
    }

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
    void mergeFilmAndActor(MouseEvent event) {
        FilmActor filmActor = new FilmActor();
        filmActor.setFilm(filmTableView.getSelectionModel().getSelectedItem());
        filmActor.setActor(filmActorBox.getValue());
        filmActorDAO.create(filmActor);
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
    void getFilmActor(MouseEvent event) {
        filmActoractorIdCol.setCellValueFactory(new PropertyValueFactory<>("actor"));
        filmActorFilmIdCol.setCellValueFactory(new PropertyValueFactory<>("film"));
        filmActorLastupdateCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

        filmActorTableView.setItems(FXCollections.observableArrayList(filmActorDAO.readAsList()));
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
        filmActorList.addAll(acDAO.readAsList());
        filmActorBox.setItems(filmActorList);

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
    void editCurrentFilm(MouseEvent event) {
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
        rentalIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        rentalDate.setCellValueFactory(new PropertyValueFactory<>("rentalDate"));
        rentalInventoryIdCol.setCellValueFactory(new PropertyValueFactory<>("inventory"));
        rentalCustomerIdCol.setCellValueFactory(new PropertyValueFactory<>("customer"));
        rentalReturndate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        rentalStaffIdCol.setCellValueFactory(new PropertyValueFactory<>("staff"));
        rentalLastupdate.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        rentalTableView.setItems(FXCollections.observableArrayList(rentalDAO.readAsList()));
    }

    @FXML
    void fillRentalFilmTableView(MouseEvent event) {
        rentalTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        rentalDescCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        rentalReleaseYCol.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));
        rentalDurCol.setCellValueFactory(new PropertyValueFactory<>("rentalDuration"));
        rentalRateCol.setCellValueFactory(new PropertyValueFactory<>("rentalRate"));
        rentalLengthCol.setCellValueFactory(new PropertyValueFactory<>("length"));
        rentalReplCostCol.setCellValueFactory(new PropertyValueFactory<>("replacementCost"));
        rentalRatingCol.setCellValueFactory(new PropertyValueFactory<>("rating"));
        rentalSpecCol.setCellValueFactory(new PropertyValueFactory<>("specialFeatures"));
        rentalFilmTableView.setItems(FXCollections.observableArrayList(filmDAO.readAsList()));

        rentalCustomerList.addAll(cusDAO.readAsList());
        rentalCustomerBox.setItems(rentalCustomerList);
        rentalStaffList.addAll(staffDAO.readAsList());
        rentalStaffBox.setItems(rentalStaffList);
    }

    // Denna metod används för att hyra en film
    @FXML
    void addRentalFilm(MouseEvent event) {
        Rental rental = new Rental();
        Inventory inventory = new Inventory(rentalFilmTableView.getSelectionModel().getSelectedItem(), rentalStaffBox.getValue().getStore());

        rental.setRentalDate(rentalDatePicker.getValue());
        rental.setInventory(inventory);
        rental.setCustomer(rentalCustomerBox.getValue());
        rental.setReturnDate(rentalDatePicker.getValue().plusDays(rental.getInventory().getFilm().getRentalDuration()));
        rental.setStaff(rentalStaffBox.getValue());

        rentalDAO.create(rental);

        rentalFilmTableView.setItems(FXCollections.observableArrayList(filmDAO.readAsList()));
    }

    @FXML
    void updateRental(MouseEvent event) {
        Rental rental = new Rental();
        rental.setId(rentalTableView.getSelectionModel().getSelectedItem().getId());
        rental.setRentalDate(rentalDateP.getValue());
        rental.setReturnDate(rentalReturnDate.getValue());

        rentalDAO.update(rental);
        rentalTableView.setItems(FXCollections.observableArrayList(rentalDAO.readAsList()));
    }

    @FXML
    void editCurrentRental(MouseEvent event) {
        Rental rental = rentalTableView.getSelectionModel().getSelectedItem();
        rentalDateP.setValue(rental.getRentalDate());
        rentalReturnDate.setValue(rental.getReturnDate());
    }

    @FXML
    void deleteRental(MouseEvent event) {
        Rental rental = rentalTableView.getSelectionModel().getSelectedItem();
        rentalDAO.delete(rental);
        rentalTableView.setItems(FXCollections.observableArrayList(rentalDAO.readAsList()));
    }

    @FXML
    void rentalSearchFilmList(KeyEvent event) {
        List<Film> listOfFilms = filmDAO.searchFilmList(rentalSearchBar.getText());

        rentalFilmTableView.setItems(FXCollections.observableArrayList(listOfFilms));
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
        // Ska verkligen en payment kunna tas bort? Detta görs nog snarare via Rental.
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
        staffIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        staffFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        staffLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        staffEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        staffActive.setCellValueFactory(new PropertyValueFactory<>("active"));
        staffUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        staffPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        staffLastupdate.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

        staffTableView.setItems(FXCollections.observableArrayList(staffDAO.readAsList()));

        staffAddressList.addAll(adDAO.readAsList());
        staffAddressBox.setItems(staffAddressList);
        staffStoreList.addAll(storeDAO.readAsList());
        staffStoreBox.setItems(staffStoreList);

    }

    @FXML
    void addStaff(MouseEvent event) {
        Staff staff = new Staff(staffFirstnametxt.getText(), staffLastnametxt.getText(), staffAddressBox.getValue(), staffEmailtxt.getText(), staffStoreBox.getValue(), staffUsernametxt.getText(), staffPasswordtxt.getText());
        //Staff staff = new Staff();

//        staff.setFirstName(staffFirstnametxt.getText());
//        staff.setLastName(staffLastnametxt.getText());
//        staff.setAddress(staffAddressBox.getValue());
//        staff.setEmail(staffEmailtxt.getText());
//        staff.setUsername(staffUsernametxt.getText());
//        staff.setPassword(staffPasswordtxt.getText());
//        Store store = new Store(staff, staff.getAddress());
//        staff.setStore(store);

        staffDAO.create(staff);
        staffTableView.setItems(FXCollections.observableArrayList(staffDAO.readAsList()));
    }

    @FXML
    void deleteStaff(MouseEvent event) {
        Staff staff = staffTableView.getSelectionModel().getSelectedItem();
        staffDAO.delete(staff);
        staffTableView.setItems(FXCollections.observableArrayList(staffDAO.readAsList()));
    }

    @FXML
    void editCurrentStaff(MouseEvent event) {
        Staff staff = staffTableView.getSelectionModel().getSelectedItem();
        staffFirstnametxt.setText(staff.getFirstName());
        staffLastnametxt.setText(staff.getLastName());
        staffEmailtxt.setText(staff.getEmail());
        staffActivetxt.setText(String.valueOf(staff.getActive()));
        staffUsernametxt.setText(staff.getUsername());
        staffPasswordtxt.setText(staff.getPassword());

    }


    @FXML
    void updateStaff(MouseEvent event) {
        Staff staff = new Staff();
        staff.setId(staffTableView.getSelectionModel().getSelectedItem().getId());
        staff.setFirstName(staffFirstnametxt.getText());
        staff.setLastName(staffLastnametxt.getText());
        staff.setEmail(staffEmailtxt.getText());
        staff.setActive(Boolean.valueOf(staffActivetxt.getText()));
        staff.setUsername(staffUsernametxt.getText());
        staff.setPassword(staffPasswordtxt.getText());
        staff.setAddress(staffAddressBox.getValue());
        //Todo Se över denna box.
        staff.setStoreid(staffStoreBox.getValue());

        staffDAO.update(staff);
        staffTableView.setItems(FXCollections.observableArrayList(staffDAO.readAsList()));
    }

    @FXML
    void getStores(MouseEvent event) {
        storeIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        storeManagerStaffIdCol.setCellValueFactory(new PropertyValueFactory<>("managerStaff"));
        storeAddressIdCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        storeLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

        storeTableView.setItems(FXCollections.observableArrayList(storeDAO.readAsList()));

        staffList.addAll(staffDAO.readAsList());
        storeManagerStaffBox.setItems(staffList);
        storeAddressList.addAll(adDAO.readAsList());
        storeAddressBox.setItems(storeAddressList);

    }

    @FXML
    void addStore(MouseEvent event) {
        Store store = new Store(storeManagerStaffBox.getValue(), storeAddressBox.getValue());
        storeDAO.create(store);
        storeTableView.setItems(FXCollections.observableArrayList(storeDAO.readAsList()));
    }

    @FXML
    void deleteStore(MouseEvent event) {
        Store store = storeTableView.getSelectionModel().getSelectedItem();
        storeDAO.delete(store);
        storeTableView.setItems(FXCollections.observableArrayList(storeDAO.readAsList()));
    }

    @FXML
    void editCurrentStore(MouseEvent event) {
        Store store = storeTableView.getSelectionModel().getSelectedItem();
        storeManagerStaffBox.setValue(store.getManagerStaff());
        storeAddressBox.setValue(store.getAddress());
    }

    @FXML
    void updateStore(MouseEvent event) {
        Store store = new Store();
        store.setId(storeTableView.getSelectionModel().getSelectedItem().getId());
        store.setManagerStaff(storeManagerStaffBox.getValue());
        store.setAddress(storeAddressBox.getValue());

        storeDAO.update(store);
        storeTableView.setItems(FXCollections.observableArrayList(storeDAO.readAsList()));
    }

    @FXML
    void getInventory(MouseEvent event) {
        inventoryIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        inventoryFilmIdCol.setCellValueFactory(new PropertyValueFactory<>("film"));
        inventoryStoreIdCol.setCellValueFactory(new PropertyValueFactory<>("store"));
        inventoryLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

        inventoryTableView.setItems(FXCollections.observableArrayList(inventoryDAO.readAsList()));

        inventoryFilmList.addAll(filmDAO.readAsList());
        inventoryStoreList.addAll(storeDAO.readAsList());
        inventoryFilmBox.setItems(inventoryFilmList);
        inventoryStoreBox.setItems(inventoryStoreList);
    }

    @FXML
    void addInventory(MouseEvent event) {
        Inventory inventory = new Inventory(inventoryFilmBox.getValue(), inventoryStoreBox.getValue());
        inventoryDAO.create(inventory);
        inventoryTableView.setItems(FXCollections.observableArrayList(inventoryDAO.readAsList()));
    }

    @FXML
    void deleteInventory(MouseEvent event) {
        // Detta görs via Film tabellen när en film tas bort.
    }

    @FXML
    void editCurrentInventory(MouseEvent event) {
        Inventory inventory = inventoryTableView.getSelectionModel().getSelectedItem();
        inventoryFilmBox.setValue(inventory.getFilm());
        inventoryStoreBox.setValue(inventory.getStore());
    }

    @FXML
    void updateInventory(MouseEvent event) {
        Inventory inventory = new Inventory();
        inventory.setId(inventoryTableView.getSelectionModel().getSelectedItem().getId());
        inventory.setFilm(inventoryFilmBox.getValue());
        inventory.setStore(inventoryStoreBox.getValue());

        inventoryDAO.update(inventory);
        inventoryTableView.setItems(FXCollections.observableArrayList(inventoryDAO.readAsList()));
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
