package controller;

import hibernate.*;
import javafx.fxml.Initializable;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class wypozyczeniaController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Podsumowanie podsumowanie = new Podsumowanie();

        List<Podsumowanie> podsumowanieList = new ArrayList<>();

        Configuration configuration = new Configuration().configure("hibernate/hibernate.cfg.xml");
        configuration.addAnnotatedClass(Samochody.class);
        configuration.addAnnotatedClass(Klienci.class);
        configuration.addAnnotatedClass(Pracownicy.class);
        configuration.addAnnotatedClass(Wypozyczenia.class);
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

        Criteria criteria = session.createCriteria(Samochody.class);
        List<Samochody> samochodyList = criteria.list();
        criteria = session.createCriteria(Klienci.class);
        List<Klienci> klienciList = criteria.list();
        criteria = session.createCriteria(Pracownicy.class);
        List<Pracownicy> pracownicyList = criteria.list();
        criteria = session.createCriteria(Wypozyczenia.class);
        List<Wypozyczenia> wypozyczeniaList = criteria.list();


        for (Wypozyczenia current : wypozyczeniaList) {
            System.out.println(current.getId_wypozyczenia() +" "+ current.getData_wynajmu()+" "+current.getData_zwrotu());
        }

        session.close();
        factory.close();

    }

}
