package controller;

import aplikacja.SceneMenager;
import dialog.Dialogs;
import hibernate.Klienci;
import hibernate.Pracownicy;
import hibernate.Samochody;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Optional;
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
        samochod = samochodyController.getWybranySamochod();
        klient = klienciController.getKlient();

        setDaneKlienta();
        setDaneSamochodu();

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

        // POSKŁADAĆ TO WSZYSKTO DO SIEBIE I BĘDZIE GUCCI :)

    }

    public void setDaneKlienta() {
        labelImie.setText(klient.getImie());
        labelNazwisko.setText(klient.getNazwisko());
        labelNIP.setText(Integer.toString(klient.getNip()));
        labelTelefon.setText(Integer.toString(klient.getNr_telefonu()));
    }

    public void setDaneSamochodu(){
        labelMarka.setText(samochod.getMarka());
        labelRok.setText(Integer.toString(samochod.getRok()));
        labelMiejsca.setText(Integer.toString(samochod.getIlosc_miejsc()));
        labelSkrzynia.setText(samochod.getTyp());
        labelKolor.setText(samochod.getKolor());
        labelCena.setText(Double.toString(samochod.getCena_za_wynajem()));
    }
}
