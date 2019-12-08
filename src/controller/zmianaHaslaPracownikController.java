package controller;

import aplikacja.SceneMenager;
import dialog.Dialogs;
import hibernate.AdminLoginInfo;
import hibernate.Pracownicy;
import hibernate.Wypozyczenia;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class zmianaHaslaPracownikController {
    private static Pracownicy pracownik;
    public VBox podanoPoprawneHaslo;
    public Label bledneHasloError;
    public PasswordField stareHaslo;
    public Button przyciskPotwierdzeniaStaregoHasla;
    public Label podaneHaslaRozneERROR;
    public PasswordField noweHasloDrugie;
    public PasswordField noweHasloPierwsze;


    @FXML
    void initialize(){
        pracownik = menuGlownePracownikController.getPracownik();
    }

    public void onActionPotwierdzenieStaregoHasla(ActionEvent actionEvent) {
        if (stareHaslo.getText().equals(pracownik.getHaslo())) {
            przyciskPotwierdzeniaStaregoHasla.setVisible(false);
            podanoPoprawneHaslo.setVisible(true);
            bledneHasloError.setVisible(false);
        }
        else {
            bledneHasloError.setVisible(true);
            stareHaslo.setText(null);
        }
    }


    public void onActionZmianaHasla(ActionEvent actionEvent) {
        if (noweHasloPierwsze.getText().equals(noweHasloDrugie.getText())) {

            pracownik.setHaslo(noweHasloDrugie.getText());

            Configuration configuration = new Configuration().configure("hibernate/hibernate.cfg.xml");
            configuration.addAnnotatedClass(AdminLoginInfo.class);
            configuration.addAnnotatedClass(Pracownicy.class);
            configuration.addAnnotatedClass(Wypozyczenia.class);
            SessionFactory factory = configuration.buildSessionFactory();
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            session.merge(pracownik);

            transaction.commit();
            session.close();
            factory.close();

            SceneMenager.renderScene("menuGlownePracownik");
            Dialogs.potwierdzenieZmianyHaslaDialog();

        }else {
            podaneHaslaRozneERROR.setVisible(true);
        }
    }
}
