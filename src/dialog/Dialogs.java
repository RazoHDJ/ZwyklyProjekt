package dialog;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.util.Optional;

public class Dialogs {

    public static void potwierdzenieZmianyHaslaDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Zmina hasła");
        alert.setHeaderText("Zmina hasła zakończona sukcesem");
        alert.showAndWait();
    }

    public static void niePodanoWszytkichPotrzebnychDanych(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Dodawanie klienta");
        alert.setHeaderText("Nie można wykonać operacji!");
        alert.setContentText("Nie można wykonać żądanej operacji,\nupewnij się że wszystkie pola zaostały wypełnione");
        alert.showAndWait();
    }

    public static Optional<ButtonType> potwierdzenieWyjscia() {
        Alert potwierdzenie = new Alert((Alert.AlertType.CONFIRMATION));
        potwierdzenie.setTitle("Wyjście z programu");
        potwierdzenie.setHeaderText("Czy na pewno chcesz wyjść z programu?");
        Optional<ButtonType> wynik = potwierdzenie.showAndWait();
        return wynik;
    }

    public static Optional<ButtonType> potwierdzenieAnulowaniaOknoKlient(){
        Alert potwierdzenie = new Alert((Alert.AlertType.CONFIRMATION));
        potwierdzenie.setTitle("Anulowanie Wypożyczenia");
        potwierdzenie.setHeaderText("Czy na pewno chcesz wyjść?");
        potwierdzenie.setContentText("Anulowanie i wyjście z programu spowoduje\nutracenie niezapisanych danych.");
        Optional<ButtonType> wynik = potwierdzenie.showAndWait();
        return  wynik;
    }

    public static Optional<ButtonType> potwierdzenieWylogowania() {
        Alert potwierdzenie = new Alert((Alert.AlertType.CONFIRMATION));
        potwierdzenie.setTitle("Wylogowanie");
        potwierdzenie.setHeaderText("Czy na pewno chcesz się wylogować?");
        Optional<ButtonType> wynik = potwierdzenie.showAndWait();
        return wynik;
    }

    public static void bladPodaniaDaty() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Błędnie wybrano datę");
        alert.showAndWait();
    }
    public static void bladWybraniaSamochoduTableView() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Proszę wybrać samochód, aby przejść dalej");
        alert.showAndWait();
    }

    public static Optional<ButtonType> powrotDoMenu() {
        Alert potwierdzenie = new Alert((Alert.AlertType.CONFIRMATION));
        potwierdzenie.setTitle("Przejście do menu");
        potwierdzenie.setHeaderText("Czy na pewno chcesz wyjść do menu?");
        Optional<ButtonType> wynik = potwierdzenie.showAndWait();
        return wynik;
    }

    public static Optional<ButtonType> potwierdzeniePowrotuDoKlientow(){
        Alert potwierdzenie = new Alert((Alert.AlertType.CONFIRMATION));
        potwierdzenie.setTitle("Informacja");
        potwierdzenie.setHeaderText("Czy na pewno chcesz cofnąć?");
        potwierdzenie.setContentText("Cofnięcie spowoduje utracenie niezapisanych danych.");
        Optional<ButtonType> wynik = potwierdzenie.showAndWait();
        return  wynik;
    }

    public static Optional<ButtonType> potwierdzeniaPrzyPodsumowaniu(){
        Alert potwierdzenie = new Alert((Alert.AlertType.CONFIRMATION));
        potwierdzenie.setTitle("Informacja");
        potwierdzenie.setHeaderText("Czy na pewno chcesz powrócić?");
        potwierdzenie.setContentText("Powrót spowoduje utracenie niezapisanych danych.");
        Optional<ButtonType> wynik = potwierdzenie.showAndWait();
        return  wynik;
    }

}
