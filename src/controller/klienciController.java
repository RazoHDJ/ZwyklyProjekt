package controller;

import aplikacja.SceneMenager;
import dialog.Dialogs;
import hibernate.AdminLoginInfo;
import hibernate.Klienci;
import hibernate.Pracownicy;
import hibernate.Wypozyczenia;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.*;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

public class klienciController {
    public TextField poleNazwisko;
    public TextField poleNIP;
    public TextField poleImie;
    public TextField poleNrTelefonu;
    public Button anulujButton;
    public Button dalejButton;
    public Button edytujKlientaButton;
    public Button dodajKlientaButton;
    public Label nieZnalesionoERROR;
    public Button zatwierdzButton;
    public Button dodajButton;
    private Klienci klient;
    public TextField nazwiskoProperty;
    public Button szukajButtonProperty;
    public TextField imieProperty;
    public Label znalezioneNazwisko;
    public VBox znalezioneDane;
    public Label znalezionyNIP;
    public Label znalezioneImie;
    public Label znalezionyNrTelefonu;

    @FXML
    void initialize() {
        poleImie.setVisible(false);
        poleNazwisko.setVisible(false);
        poleNIP.setVisible(false);
        poleNrTelefonu.setVisible(false);
    }


    public void onActionSzukajButton() {
        boolean znaleziono = false;
        Configuration configuration = new Configuration().configure("hibernate/hibernate.cfg.xml");
        configuration.addAnnotatedClass(Klienci.class);
        configuration.addAnnotatedClass(Wypozyczenia.class);
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

        Criteria criteria = session.createCriteria(Klienci.class);
        List<Klienci> klienci = criteria.list();
        for (Klienci current : klienci) {
            if (imieProperty.getText().equals(current.getImie()) && nazwiskoProperty.getText().equals(current.getNazwisko())) {
                klient = current;
                znaleziono = true;
                System.out.println("Znaleziono klienta");
                znalezioneDane.setVisible(true);
                znalezioneImie.setText(current.getImie());
                znalezioneNazwisko.setText(current.getNazwisko());
                znalezionyNIP.setText(Integer.toString(current.getNip()));
                znalezionyNrTelefonu.setText(Integer.toString(current.getNr_telefonu()));

                //na wypadek jakby klient został znaleziony za 2 razem
                poleImie.setVisible(false);
                poleNazwisko.setVisible(false);
                poleNIP.setVisible(false);
                poleNrTelefonu.setVisible(false);
                nieZnalesionoERROR.setVisible(false);
                dodajKlientaButton.setVisible(false);

                dodajButton.setVisible(false);
                dalejButton.setVisible(true);
                edytujKlientaButton.setVisible(true);
                break;
            }
        }
        if (!znaleziono) {
//            poleImie.setVisible(true);
//            poleNazwisko.setVisible(true);
//            poleNIP.setVisible(true);
//            poleNrTelefonu.setVisible(true);
            dodajButton.setVisible(true);
            nieZnalesionoERROR.setVisible(true);
            edytujKlientaButton.setVisible(false);
        }
        session.close();
        factory.close();
    }

    public void onActionAnuluj(ActionEvent actionEvent) {
        Optional<ButtonType> wynik = Dialogs.potwierdzenieAnulowaniaOknoKlient();
        if (wynik.get() == ButtonType.OK) {
            SceneMenager.renderScene("menuGlownePracownik");
        }
    }

    public void onActionDalej(ActionEvent actionEvent) {
        System.out.println("Dalej button on action");
    }

    public void onActionEdytuj(ActionEvent actionEvent) {
        dalejButton.setVisible(false);
        edytujKlientaButton.setVisible(false);
        zatwierdzButton.setVisible(true);
        //zamykanie starych labelów z informacjami o kliencie
        znalezioneImie.setVisible(false);
        znalezioneNazwisko.setVisible(false);
        znalezionyNIP.setVisible(false);
        znalezionyNrTelefonu.setVisible(false);

        //otwieranie nowych pól edycjii
        poleImie.setVisible(true);
        poleNazwisko.setVisible(true);
        poleNrTelefonu.setVisible(true);
        poleNIP.setVisible(true);

        poleImie.setText(znalezioneImie.getText());
        znalezioneImie.setText(null);
        poleNazwisko.setText(znalezioneNazwisko.getText());
        znalezioneNazwisko.setText(null);
        poleNIP.setText(znalezionyNIP.getText());
        znalezionyNIP.setText(null);
        poleNrTelefonu.setText(znalezionyNrTelefonu.getText());
        znalezionyNrTelefonu.setText(null);
    }

    public void onActionDodaj(ActionEvent actionEvent) {
        dodajButton.setVisible(false);
        dodajKlientaButton.setVisible(true);

        znalezioneImie.setText(null);
        znalezioneNazwisko.setText(null);
        znalezionyNIP.setText(null);
        znalezionyNrTelefonu.setText(null);


        poleImie.setVisible(true);
        poleNazwisko.setVisible(true);
        poleNrTelefonu.setVisible(true);
        poleNIP.setVisible(true);

    }

    public void onActionZatwierdz(ActionEvent actionEvent) {
        if (!poleImie.getText().trim().isEmpty() && !poleNazwisko.getText().trim().isEmpty() && !poleNIP.getText().trim().isEmpty() && !poleNrTelefonu.getText().trim().isEmpty()) {
            klient.setImie(poleImie.getText());
            klient.setNazwisko(poleNazwisko.getText());
            klient.setNip(Integer.parseInt(poleNIP.getText()));
            klient.setNr_telefonu(Integer.parseInt(poleNrTelefonu.getText()));

            Configuration configuration = new Configuration().configure("hibernate/hibernate.cfg.xml");
            configuration.addAnnotatedClass(Klienci.class);
            configuration.addAnnotatedClass(Wypozyczenia.class);
            SessionFactory factory = configuration.buildSessionFactory();
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            session.merge(klient);

            transaction.commit();
            session.close();
            factory.close();

            imieProperty.setText(poleImie.getText());
            nazwiskoProperty.setText(poleNazwisko.getText());
            onActionSzukajButton();

            znalezioneImie.setVisible(true);
            znalezioneNazwisko.setVisible(true);
            znalezionyNIP.setVisible(true);
            znalezionyNrTelefonu.setVisible(true);

            edytujKlientaButton.setVisible(true);
            dalejButton.setVisible(true);
            zatwierdzButton.setVisible(false);
            poleImie.setVisible(false);
            poleNazwisko.setVisible(false);
            poleNIP.setVisible(false);
            poleNrTelefonu.setVisible(false);
        }else {
            Dialogs.niePodanoWszytkichPotrzebnychDanych();
        }
    }

    public void onActionDodajKlienta(ActionEvent actionEvent) {
        if (!poleImie.getText().trim().isEmpty() && !poleNazwisko.getText().trim().isEmpty() && !poleNIP.getText().trim().isEmpty() && !poleNrTelefonu.getText().trim().isEmpty()) {
            Configuration configuration = new Configuration().configure("hibernate/hibernate.cfg.xml");
            configuration.addAnnotatedClass(Klienci.class);
            configuration.addAnnotatedClass(Wypozyczenia.class);
            SessionFactory factory = configuration.buildSessionFactory();
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            session.save(new Klienci(poleImie.getText(), poleNazwisko.getText(), Integer.parseInt(poleNIP.getText()), Integer.parseInt(poleNrTelefonu.getText())));

            transaction.commit();
            session.close();
            factory.close();

            dodajKlientaButton.setVisible(false);
            imieProperty.setText(poleImie.getText());
            nazwiskoProperty.setText(poleNazwisko.getText());
            onActionSzukajButton();

        } else {
            Dialogs.niePodanoWszytkichPotrzebnychDanych();
        }
    }
}
