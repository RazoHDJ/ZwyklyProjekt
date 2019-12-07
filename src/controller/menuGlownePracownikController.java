package controller;

import aplikacja.SceneMenager;
import dialog.Dialogs;
import hibernate.Pracownicy;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import java.util.Optional;

public class menuGlownePracownikController {
    private static Pracownicy pracownik;

    @FXML
    public Label osobaZalogowana;
    @FXML
    public Label zalogowanyImie;
    @FXML
    public Label zalogowanyNazwisko;

    @FXML
    void initialize() {
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


    public void nowyKlient(ActionEvent actionEvent) {
        SceneMenager.renderScene("klienci");
    }
}
