package controller;

import aplikacja.SceneMenager;
import dialog.Dialogs;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class menuGlownePracownikController {
    public void onActionNoweWypozyczenie(ActionEvent actionEvent) {
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
}
