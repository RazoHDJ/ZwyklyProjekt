package controller;

import aplikacja.SceneMenager;
import dialog.Dialogs;
import hibernate.AdminLoginInfo;
import hibernate.Klienci;
import hibernate.Pracownicy;
import hibernate.Wypozyczenia;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
    private  Klienci klient;
    public TextField nazwiskoProperty;
    public Button szukajButtonProperty;
    public TextField imieProperty;
    public Label znalezioneNazwisko;
    public VBox znalezioneDane;
    public Label znalezionyNIP;
    public Label znalezioneImie;
    public Label znalezionyNrTelefonu;

    public void onActionSzukajButton(ActionEvent actionEvent) {
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

                dalejButton.setVisible(true);
                edytujKlientaButton.setVisible(true);
                break;
            }
        }
        if (!znaleziono) {
            poleImie.setVisible(true);
            poleNazwisko.setVisible(true);
            poleNIP.setVisible(true);
            poleNrTelefonu.setVisible(true);
            dodajKlientaButton.setVisible(true);
            nieZnalesionoERROR.setVisible(true);
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
        System.out.println("Edytuj button on action");
    }

    public void onActionDodaj(ActionEvent actionEvent) {
        System.out.println("Dodaj button on action");
    }
}
