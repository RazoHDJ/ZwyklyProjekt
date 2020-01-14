package controller;

import aplikacja.SceneMenager;
import dialog.Dialogs;
import hibernate.Pracownicy;
import hibernate.Samochody;
import hibernate.Wypozyczenia;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class dodawanieSamochoduController implements Initializable {
    public MenuButton iloscMiejsc;
    public MenuButton rodzajSkrzyni;
    public TextField marka;
    public TextField rocznik;
    public TextField cena;
    public TextField kolor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void onActionIloscMiejsc(ActionEvent actionEvent) {
        iloscMiejsc.setText(((MenuItem) actionEvent.getSource()).getText());
    }

    public void onActionRodzajSkrzyni(ActionEvent actionEvent) {
        rodzajSkrzyni.setText(((MenuItem) actionEvent.getSource()).getText());
    }

    public void onActionAnuluj(ActionEvent actionEvent) {
        Optional<ButtonType> wynik = Dialogs.anulowanieDodawaniaSamochodu();
        if (wynik.get() == ButtonType.OK) {
            SceneMenager.renderScene("menuGlowneAdmin");
        }
    }

    public void onActionDodaj(ActionEvent actionEvent) {
        if (sprawdzenieCzyPodanoWszystkieDane()) {

            Configuration configuration = new Configuration().configure("hibernate/hibernate.cfg.xml");
            configuration.addAnnotatedClass(Samochody.class);
            configuration.addAnnotatedClass(Wypozyczenia.class);
            SessionFactory factory = configuration.buildSessionFactory();
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            session.save(new Samochody(marka.getText(), rodzajSkrzyni.getText(), Integer.parseInt(rocznik.getText()), kolor.getText(), Integer.parseInt(iloscMiejsc.getText()), Double.parseDouble(cena.getText())));

            transaction.commit();
            session.close();
            factory.close();
            Dialogs.dodanoSamochod();
            SceneMenager.renderScene("menuGlowneAdmin");
        } else {
            Dialogs.brakujeDanych();
        }
    }

    public boolean sprawdzenieCzyPodanoWszystkieDane() {
        if (iloscMiejsc.getText().equals("--") || rodzajSkrzyni.getText().equals("--")) {
            return false;
        } else if (marka.getText().trim().isEmpty() || rocznik.getText().trim().isEmpty() || cena.getText().trim().isEmpty() || kolor.getText().trim().isEmpty()) {
            return false;
        } else
            return true;
    }
}
