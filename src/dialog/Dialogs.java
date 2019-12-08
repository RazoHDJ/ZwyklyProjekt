package dialog;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Dialogs {

    public static void potwierdzenieZmianyHaslaDialog(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Zmina hasła");
        alert.setHeaderText("Zmina hasła zakończona sukcesem");
        alert.showAndWait();
    }


    public static Optional<ButtonType> potwierdzenieWyjscia(){
        Alert potwierdzenie = new Alert((Alert.AlertType.CONFIRMATION));
        potwierdzenie.setTitle("Wyjście z programu");
        potwierdzenie.setHeaderText("Czy na pewno chcesz wyjść z programu?");
        Optional<ButtonType> wynik = potwierdzenie.showAndWait();
        return wynik;
    }
    public static Optional<ButtonType> potwierdzenieWylogowania(){
        Alert potwierdzenie = new Alert((Alert.AlertType.CONFIRMATION));
        potwierdzenie.setTitle("Wylogowanie");
        potwierdzenie.setHeaderText("Czy na pewno chcesz się wylogować?");
        Optional<ButtonType> wynik = potwierdzenie.showAndWait();
        return wynik;
    }
}
