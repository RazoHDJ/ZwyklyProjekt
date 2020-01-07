package controller;

import hibernate.Klienci;
import hibernate.Pracownicy;
import hibernate.Samochody;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class podsumowanieController implements Initializable {

    private Pracownicy pracownik;
    private Samochody samochod;
    private Klienci klient;


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
//        samochod = samochodyController.
    }

    @FXML
    void onActionKlienci(ActionEvent event) {

    }

    @FXML
    void onActionPotwierdzenie(ActionEvent event) {

    }

    @FXML
    void onActionSamochody(ActionEvent event) {

    }
}
