package controller;

import aplikacja.SceneMenager;
import hibernate.AdminLoginInfo;
import hibernate.Klienci;
import hibernate.Pracownicy;
import hibernate.Wypozyczenia;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLOutput;
import java.util.List;

public class klienciController {
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
                break;
            }
        }
        if (!znaleziono) {
            System.out.printf("Nie znaleziono klienta");
        }
        session.close();
        factory.close();
    }
}
