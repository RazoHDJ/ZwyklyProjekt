package controller;

import aplikacja.SceneMenager;
import dialog.Dialogs;
import hibernate.Klienci;
import hibernate.Pracownicy;
import hibernate.Wypozyczenia;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class dodawaniePracownikaController implements Initializable {
    public TextField imie;
    public TextField nazwisko;
    public TextField login;
    public PasswordField haslo;
    public PasswordField hasloPotorz;
    public TextField pensja;

    public void onActionAnuluj(ActionEvent actionEvent) {
        Optional<ButtonType> wynik = Dialogs.anulowanieDodawaniaSamochodu();
        if (wynik.get() == ButtonType.OK) {
            SceneMenager.renderScene("menuGlowneAdmin");
        }
    }

    public void onActionDodaj(ActionEvent actionEvent) {
        if (imie.getText().trim().isEmpty() || nazwisko.getText().trim().isEmpty() || login.getText().trim().isEmpty() || haslo.getText().trim().isEmpty() || hasloPotorz.getText().trim().isEmpty() || pensja.getText().trim().isEmpty()) {
            Dialogs.brakujeDanych();
        } else if (!haslo.getText().equals(hasloPotorz.getText())) {
            Dialogs.podanoDwaRozneHasla();
        } else {
            Configuration configuration = new Configuration().configure("hibernate/hibernate.cfg.xml");
            configuration.addAnnotatedClass(Pracownicy.class);
            configuration.addAnnotatedClass(Wypozyczenia.class);
            SessionFactory factory = configuration.buildSessionFactory();
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            session.save(new Pracownicy(imie.getText(), nazwisko.getText(), Double.parseDouble(pensja.getText()), login.getText(), haslo.getText()));

            transaction.commit();
            session.close();
            factory.close();
            Dialogs.dodanoPracownika();
            SceneMenager.renderScene("menuGlowneAdmin");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
