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
    private static Klienci klient;
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
                //przypisanie znalezionego klienta do zmiennej
                klient = current;
                znaleziono = true;

               // System.out.println("Znaleziono klienta");

                znalezioneDane.setVisible(true);
                setZnalezioneVisible(true);

                znalezioneImie.setText(current.getImie());
                znalezioneNazwisko.setText(current.getNazwisko());
                znalezionyNIP.setText(Integer.toString(current.getNip()));
                znalezionyNrTelefonu.setText(Integer.toString(current.getNr_telefonu()));

                //na wypadek jakby klient został znaleziony za 2 razem
                setPolaVisible(false);

                nieZnalesionoERROR.setVisible(false);
                dodajKlientaButton.setVisible(false);

                dodajButton.setVisible(false);
                dalejButton.setVisible(true);
                edytujKlientaButton.setVisible(true);
                break;
            }
        }
        if (!znaleziono) {
            setZnalezioneVisible(false);
            clearZnalezione();

            dalejButton.setVisible(false);
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
        SceneMenager.renderScene("samochody");
    }

    public void onActionEdytuj(ActionEvent actionEvent) {
        dalejButton.setVisible(false);
        edytujKlientaButton.setVisible(false);
        zatwierdzButton.setVisible(true);
        //zamykanie starych labelów z informacjami o kliencie
        setZnalezioneVisible(false);

        //otwieranie nowych pól edycjii
        setPolaVisible(true);

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

        clearZnalezione();

        setPolaVisible(true);
        clearPola();

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

            setZnalezioneVisible(true);

            edytujKlientaButton.setVisible(true);
            dalejButton.setVisible(true);
            zatwierdzButton.setVisible(false);

            setPolaVisible(false);
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

    public void setPolaVisible(boolean pokazac) {
        poleImie.setVisible(pokazac);
        poleNazwisko.setVisible(pokazac);
        poleNIP.setVisible(pokazac);
        poleNrTelefonu.setVisible(pokazac);
    }

    public void setZnalezioneVisible(boolean pokazac) {
        znalezioneImie.setVisible(pokazac);
        znalezioneNazwisko.setVisible(pokazac);
        znalezionyNIP.setVisible(pokazac);
        znalezionyNrTelefonu.setVisible(pokazac);
    }

    public void clearZnalezione() {
        znalezioneImie.setText(null);
        znalezioneNazwisko.setText(null);
        znalezionyNIP.setText(null);
        znalezionyNrTelefonu.setText(null);
    }
    public void clearPola(){
        poleImie.setText(null);
        poleNazwisko.setText(null);
        poleNrTelefonu.setText(null);
        poleNIP.setText(null);
    }

    public static Klienci getKlient() {
        return klient;
    }
}
