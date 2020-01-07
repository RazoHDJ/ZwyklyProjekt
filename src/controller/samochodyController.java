package controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import dialog.Dialogs;
import hibernate.Samochody;
import hibernate.Wypozyczenia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class samochodyController implements Initializable {
    LocalDate dzisiejszaData = LocalDate.now();
    public DatePicker dataZwr;
    public DatePicker dataWyp;
    public RadioButton radioButtonManual;
    public ToggleGroup skrzynie;
    public RadioButton radioButtonAutomat;
    @FXML
    private TableView<Samochody> tableView;
    @FXML
    private TableColumn<String, Samochody> tableMarka;
    @FXML
    private TableColumn<Integer, Samochody> tableRok;
    @FXML
    private TableColumn<String, Samochody> tableMiejsca;
    @FXML
    private TableColumn<String, Samochody> tableSkrzynia;
    @FXML
    private TableColumn<String, Samochody> tableKolor;
    @FXML
    private TableColumn<Double, Samochody> tableCena;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

        dataWyp.setValue(dzisiejszaData);
        dataZwr.setValue(dzisiejszaData);

//        Configuration configuration = new Configuration().configure("hibernate/hibernate.cfg.xml");
//        configuration.addAnnotatedClass(Samochody.class);
//        configuration.addAnnotatedClass(Wypozyczenia.class);
//        SessionFactory factory = configuration.buildSessionFactory();
//        Session session = factory.openSession();
//
//
//        tableCena.setCellValueFactory(new PropertyValueFactory<>("cena_za_wynajem"));
//        tableKolor.setCellValueFactory(new PropertyValueFactory<>("kolor"));
//        tableMarka.setCellValueFactory(new PropertyValueFactory<>("marka"));
//        tableMiejsca.setCellValueFactory(new PropertyValueFactory<>("ilosc_miejsc"));
//        tableRok.setCellValueFactory(new PropertyValueFactory<>("rok"));
//        tableSkrzynia.setCellValueFactory(new PropertyValueFactory<>("typ"));
//
//        Criteria criteria = session.createCriteria(Samochody.class);
//        List<Samochody> samochodyList = criteria.list();
//        for (Samochody current : samochodyList) {
//            tableView.getItems().add(current);
//        }
//        session.close();
//        factory.close();

    }

    public void onActionButtonSzukaj(ActionEvent actionEvent) {
        LocalDate wypozyczenie = null;
        LocalDate zwrot = null;

        if (dataWyp.getValue().isEqual(dataZwr.getValue()) || dataWyp.getValue().isAfter(dataZwr.getValue())) {
            Dialogs.bladPodaniaDaty();
        } else {
            wypozyczenie = dataWyp.getValue();
            zwrot = dataZwr.getValue();

        }


//        System.out.println("Data wypożyczenia: " + wypozyczenie);
//        System.out.println("Data zwrotu: " + zwrot);
//        System.out.println(wypozyczenie.getDayOfMonth());
//        System.out.println(wypozyczenie.getMonth().getValue());
//        System.out.println(wypozyczenie.getYear());

    }

}
