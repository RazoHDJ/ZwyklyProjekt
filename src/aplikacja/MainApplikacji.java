package aplikacja;

import hibernate.*;
import javafx.application.Application;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainApplikacji extends Application {
    //    public static Configuration configuration = new Configuration().configure("hibernate/hibernate.cfg.xml");
//    public static SessionFactory factory = configuration.buildSessionFactory();
//    public static Session session = factory.openSession();
    public static void main(String[] args) {
//        configuration.addAnnotatedClass(AdminLoginInfo.class);
//        configuration.addAnnotatedClass(Klienci.class);
//        configuration.addAnnotatedClass(Pracownicy.class);
//        configuration.addAnnotatedClass(Samochody.class);
//        configuration.addAnnotatedClass(Wypozyczenia.class);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//    //    AdminLoginInfo admin = new AdminLoginInfo("admin", "admin1");
//        Klienci klienci1 = new Klienci("Jeden", "Jedyny", 12345, 54321);
//        Klienci klienci2 = new Klienci("Dwa", "Drugi", 23456, 65432);
//        Pracownicy pracownicy1 = new Pracownicy("Trzy", "Trzeci", 345.67);
//        Pracownicy pracownicy2 = new Pracownicy("Cztery", "Cztery", 456.78);
//        Samochody samochody1 = new Samochody("Pieć", "Piątego", 5555, "Piąty", 55.55);
//        Samochody samochody2 = new Samochody("Sześć", "Szóstego", 6666, "Szósty", 66.66);
//        Wypozyczenia wypozyczenia1 = new Wypozyczenia(1, 11);
//        Wypozyczenia wypozyczenia2 = new Wypozyczenia(2, 22);
//        Wypozyczenia wypozyczenia3 = new Wypozyczenia(3, 33);
//        Wypozyczenia wypozyczenia4 = new Wypozyczenia(4, 44);
//        List<Wypozyczenia> wypozyczeniaList1 = new ArrayList<>();
//        List<Wypozyczenia> wypozyczeniaList2 = new ArrayList<>();
//
//        wypozyczeniaList1.add(wypozyczenia1);
//        wypozyczeniaList1.add(wypozyczenia3);
//        klienci1.setWypozyczeniaList(wypozyczeniaList1);
//        pracownicy1.setWypozyczeniaList(wypozyczeniaList1);
//        samochody1.setWypozyczeniaList(wypozyczeniaList1);
//
//        wypozyczeniaList2.add(wypozyczenia2);
//        wypozyczeniaList2.add(wypozyczenia4);
//        klienci2.setWypozyczeniaList(wypozyczeniaList2);
//        pracownicy2.setWypozyczeniaList(wypozyczeniaList2);
//        samochody2.setWypozyczeniaList(wypozyczeniaList2);
//
//        Configuration configuration = new Configuration().configure("hibernate/hibernate.cfg.xml");
//        configuration.addAnnotatedClass(AdminLoginInfo.class);
//        configuration.addAnnotatedClass(Klienci.class);
//        configuration.addAnnotatedClass(Pracownicy.class);
//        configuration.addAnnotatedClass(Samochody.class);
//        configuration.addAnnotatedClass(Wypozyczenia.class);
//
//        SessionFactory factory = configuration.buildSessionFactory();
//        Session session = factory.openSession();
//        Transaction transaction = session.beginTransaction();
//
//        session.save(klienci1);
//        session.save(klienci2);
//        session.save(pracownicy1);
//        session.save(pracownicy2);
//        session.save(samochody1);
//        session.save(samochody2);
//        session.save(wypozyczenia1);
//        session.save(wypozyczenia2);
//        session.save(wypozyczenia3);
//        session.save(wypozyczenia4);
//
//  //      session.save(admin);
//        transaction.commit();
//        session.close();
//        factory.close();

        SceneMenager.setStage(primaryStage);

        SceneMenager.addScene("logowanie", "fxml/logowanie.fxml");
        SceneMenager.addScene("menuGlowneAdmin", "fxml/menuGlowneAdmin.fxml");
        SceneMenager.addScene("menuGlownePracownik", "fxml/menuGlownePracownik.fxml");

        SceneMenager.renderScene("logowanie");
    }
}
