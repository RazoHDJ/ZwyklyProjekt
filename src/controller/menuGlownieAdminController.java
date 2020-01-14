package controller;

import aplikacja.SceneMenager;
import dialog.Dialogs;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class menuGlownieAdminController implements Initializable {
    
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }

    public void onActionDodawaniePracownika(ActionEvent actionEvent) {
        SceneMenager.renderScene("dodawaniePracownika");
    }

    public void onActionDodawanieSamochodu(ActionEvent actionEvent) {
        SceneMenager.renderScene("dodawanieSamochodu");
    }


    public void onActionWypozyczenia(ActionEvent actionEvent) {
        SceneMenager.renderScene("wypozyczenia");
    }

    public void onActionWyloguj(ActionEvent actionEvent) {
        Optional<ButtonType> wynik = Dialogs.potwierdzenieWylogowania();
        if (wynik.get() == ButtonType.OK) {
            SceneMenager.renderScene("logowanie");
        }
    }

    public void onActionWyjscie(ActionEvent actionEvent) {
        Optional<ButtonType> wynik = Dialogs.potwierdzenieWyjscia();
        if (wynik.get() == ButtonType.OK) {
            Platform.exit();
        }
    }
}
