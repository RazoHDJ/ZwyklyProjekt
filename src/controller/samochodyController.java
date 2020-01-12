package controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import aplikacja.SceneMenager;
import dialog.Dialogs;
import hibernate.Samochody;
import hibernate.Wypozyczenia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class samochodyController implements Initializable {


    private static LocalDate dataWypozyczenia;
    private static LocalDate dataZwrotu;

    private static Samochody wybranySamochod = null;
    public int liczbaMiejsc = 0;
    public int rodzajSkrzyniBiegów = 0; //0 reprezentuje dowolną skrzynię biegów
    public MenuButton menuButton;
    public MenuItem menuItemWE;
    public MenuItem menuItem4;
    public MenuItem menuItem5;
    public MenuItem menuItem6;
    public MenuItem menuItem8;
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
        dataZwr.setValue(dzisiejszaData.plusDays(1));

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
        tableView.getItems().clear();

        if (dataWyp.getValue().isEqual(dataZwr.getValue()) || dataWyp.getValue().isAfter(dataZwr.getValue())) {
            Dialogs.bladPodaniaDaty();
        } else {
            dataWypozyczenia = dataWyp.getValue();
            dataZwrotu = dataZwr.getValue();

            if (radioButtonManual.isSelected()) rodzajSkrzyniBiegów = 1;
            else if (radioButtonAutomat.isSelected()) rodzajSkrzyniBiegów = 2;
            else rodzajSkrzyniBiegów = 0;

//        System.out.println("Data wypożyczenia: " + wypozyczenie);
//        System.out.println("Data zwrotu: " + zwrot);
//        System.out.println(wypozyczenie.getDayOfMonth());
//        System.out.println(wypozyczenie.getMonth().getValue());
//        System.out.println(wypozyczenie.getYear());


            Configuration configuration = new Configuration().configure("hibernate/hibernate.cfg.xml");
            configuration.addAnnotatedClass(Samochody.class);
            configuration.addAnnotatedClass(Wypozyczenia.class);
            SessionFactory factory = configuration.buildSessionFactory();
            Session session = factory.openSession();


            tableCena.setCellValueFactory(new PropertyValueFactory<>("cena_za_wynajem"));
            tableKolor.setCellValueFactory(new PropertyValueFactory<>("kolor"));
            tableMarka.setCellValueFactory(new PropertyValueFactory<>("marka"));
            tableMiejsca.setCellValueFactory(new PropertyValueFactory<>("ilosc_miejsc"));
            tableRok.setCellValueFactory(new PropertyValueFactory<>("rok"));
            tableSkrzynia.setCellValueFactory(new PropertyValueFactory<>("typ"));

            Criteria criteria = session.createCriteria(Samochody.class);
            List<Samochody> samochodyList = criteria.list();
            for (Samochody current : samochodyList) {

                if (liczbaMiejsc != 0) {
                    if (liczbaMiejsc != current.getIlosc_miejsc()) {
                        continue;
                    }
                }

                if (rodzajSkrzyniBiegów != 0) {
                    if (rodzajSkrzyniBiegów == 2 && current.getTyp().equals("manualna")) {
                        continue;
                    } else if (rodzajSkrzyniBiegów == 1 && current.getTyp().equals("automatyczna")) {
                        continue;
                    }
                }

                tableView.getItems().add(current);
            }
            session.close();
            factory.close();

        }
    }


    public void onActionMenu(ActionEvent actionEvent) {
        menuButton.setText(((MenuItem) actionEvent.getSource()).getText());
        if (menuButton.getText().equals("--")) {
            liczbaMiejsc = 0;
        } else {
            liczbaMiejsc = Integer.parseInt(menuButton.getText());
        }
    }

    public void onActionRadioButtonManual(ActionEvent actionEvent) {
        if (radioButtonAutomat.isSelected()) {
            radioButtonAutomat.setSelected(false);
        }
    }

    public void onActionRadioButtonAutomat(ActionEvent actionEvent) {
        if (radioButtonManual.isSelected()) {
            radioButtonManual.setSelected(false);
        }
    }

    public void onActionMenuPracownik(ActionEvent actionEvent) {
        Optional<ButtonType> wynik = Dialogs.powrotDoMenu();
        if (wynik.get() == ButtonType.OK) {
            SceneMenager.renderScene("menuGlownePracownik");
        }
    }

    public void onActionCofnij(ActionEvent actionEvent) {
        Optional<ButtonType> wynik = Dialogs.potwierdzeniePowrotuDoKlientow();
        if (wynik.get() == ButtonType.OK) {
            SceneMenager.renderScene("klienci");
        }
    }

    public void onActionDalej(ActionEvent actionEvent) {
        if (tableView.getSelectionModel().isEmpty()) {
            Dialogs.bladWybraniaSamochoduTableView();
        } else {
            wybranySamochod = tableView.getSelectionModel().getSelectedItem();

            SceneMenager.renderScene("podsumowanie");

            //sprawdanie czy wybiera sie poprawyny samochód z tabeli
//            System.out.println("Oto wybrany samochód\n" + wybranySamochod.getId_samochodu() + " | " + wybranySamochod.getMarka() + " | " + wybranySamochod.getRok() + " | " + wybranySamochod.getIlosc_miejsc() + " | " + wybranySamochod.getTyp() + " | " + wybranySamochod.getKolor() + " | " + wybranySamochod.getCena_za_wynajem());
        }
    }

    public DatePicker getDataZwr() {
        return dataZwr;
    }

    public DatePicker getDataWyp() {
        return dataWyp;
    }

    public static Samochody getWybranySamochod() {
        return wybranySamochod;
    }

    public static LocalDate getDataWypozyczenia() {
        return dataWypozyczenia;
    }

    public static LocalDate getDataZwrotu() {
        return dataZwrotu;
    }
}
