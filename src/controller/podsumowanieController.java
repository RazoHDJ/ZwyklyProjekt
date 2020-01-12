package controller;

import aplikacja.SceneMenager;
import dialog.Dialogs;
import hibernate.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class podsumowanieController implements Initializable {

    private Pracownicy pracownik;
    private Samochody samochod;
    private Klienci klient;
    private LocalDate dataWypozyczenia;
    private LocalDate dataZawrotu;

    public Label labelDataWypozyczenia;
    public Label labelDataZwrotu;
    @FXML
    private Label labelImie;
    @FXML
    private Label labelNazwisko;
    @FXML
    private Label labelNIP;
    @FXML
    private Label labelTelefon;
    @FXML
    private Label labelMarka;
    @FXML
    private Label labelRok;
    @FXML
    private Label labelMiejsca;
    @FXML
    private Label labelSkrzynia;
    @FXML
    private Label labelKolor;
    @FXML
    private Label labelCena;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pracownik = menuGlownePracownikController.getPracownik();
        samochod = samochodyController.getWybranySamochod();
        klient = klienciController.getKlient();

        setDaneKlienta();
        setDaneSamochodu();
        setDaty();

    }

    @FXML
    void onActionKlienci(ActionEvent event) {
        Optional<ButtonType> wynik = Dialogs.potwierdzeniaPrzyPodsumowaniu();
        if (wynik.get() == ButtonType.OK) {
            SceneMenager.renderScene("klienci");
        }
    }

    @FXML
    void onActionSamochody(ActionEvent event) {
        Optional<ButtonType> wynik = Dialogs.potwierdzeniaPrzyPodsumowaniu();
        if (wynik.get() == ButtonType.OK) {
            SceneMenager.renderScene("samochody");
        }
    }

    @FXML
    void onActionPotwierdzenie(ActionEvent event) {
        Wypozyczenia noweWypożyczenie = new Wypozyczenia(dataWypozyczenia, dataZawrotu);
        List<Wypozyczenia> wypozyczeniaList = new ArrayList<>();

        wypozyczeniaList = pracownik.getWypozyczeniaList();
        wypozyczeniaList.add(noweWypożyczenie);
        pracownik.setWypozyczeniaList(wypozyczeniaList);


        wypozyczeniaList = klient.getWypozyczeniaList();
        wypozyczeniaList.add(noweWypożyczenie);
        klient.setWypozyczeniaList(wypozyczeniaList);

        wypozyczeniaList = samochod.getWypozyczeniaList();
        wypozyczeniaList.add(noweWypożyczenie);
        samochod.setWypozyczeniaList(wypozyczeniaList);

        Configuration configuration = new Configuration().configure("hibernate/hibernate.cfg.xml");
        configuration.addAnnotatedClass(Klienci.class);
        configuration.addAnnotatedClass(Pracownicy.class);
        configuration.addAnnotatedClass(Samochody.class);
        configuration.addAnnotatedClass(Wypozyczenia.class);
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(noweWypożyczenie);
        session.merge(klient);
        session.merge(samochod);
        session.merge(pracownik);

        transaction.commit();

        session.close();
        factory.close();

    }

    public void setDaneKlienta() {
        labelImie.setText(klient.getImie());
        labelNazwisko.setText(klient.getNazwisko());
        labelNIP.setText(Integer.toString(klient.getNip()));
        labelTelefon.setText(Integer.toString(klient.getNr_telefonu()));
    }

    public void setDaneSamochodu() {
        labelMarka.setText(samochod.getMarka());
        labelRok.setText(Integer.toString(samochod.getRok()));
        labelMiejsca.setText(Integer.toString(samochod.getIlosc_miejsc()));
        labelSkrzynia.setText(samochod.getTyp());
        labelKolor.setText(samochod.getKolor());
        labelCena.setText(Double.toString(samochod.getCena_za_wynajem()));
    }

    private void setDaty() {

        dataWypozyczenia = samochodyController.getDataWypozyczenia();
        dataZawrotu = samochodyController.getDataZwrotu();
        labelDataWypozyczenia.setText(String.valueOf(dataWypozyczenia));
        labelDataZwrotu.setText(String.valueOf(dataZawrotu));

    }

    public void setDataWypozyczenia(LocalDate dataWypozyczenia) {
        this.dataWypozyczenia = dataWypozyczenia;
    }

    public void setDataZawrotu(LocalDate dataZawrotu) {
        this.dataZawrotu = dataZawrotu;
    }
}
