package controller;

import aplikacja.SceneMenager;
import dialog.Dialogs;
import hibernate.Pracownicy;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class menuGlownePracownikController implements Initializable {
    private static Pracownicy pracownik;

    @FXML
    public Label osobaZalogowana;
    @FXML
    public Label zalogowanyImie;
    @FXML
    public Label zalogowanyNazwisko;

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        osobaZalogowana.setText(pracownik.getLogin());
        zalogowanyImie.setText(pracownik.getNazwisko());
        zalogowanyNazwisko.setText(pracownik.getNazwisko());
    }

    public void wyloguj(ActionEvent actionEvent) {
        Optional<ButtonType> wynik = Dialogs.potwierdzenieWylogowania();
        if (wynik.get() == ButtonType.OK) {
            SceneMenager.renderScene("logowanie");
        }
    }

    public void exit(ActionEvent actionEvent) {
        Optional<ButtonType> wynik = Dialogs.potwierdzenieWyjscia();
        if (wynik.get() == ButtonType.OK) {
            Platform.exit();
        }
    }

    public static void setPracownik(Pracownicy pracownik) {
        menuGlownePracownikController.pracownik = pracownik;
    }
    public static Pracownicy getPracownik(){return menuGlownePracownikController.pracownik;}

    public void nowyKlient(ActionEvent actionEvent) {
        SceneMenager.renderScene("klienci");
    }

    public void onActionZmienHasloPracownik(ActionEvent actionEvent) {
        SceneMenager.renderScene("zmianaHaslaPracownik");

    }
}
