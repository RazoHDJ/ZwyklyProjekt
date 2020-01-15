package controller;

import aplikacja.SceneMenager;
import dialog.Dialogs;
import hibernate.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class wypozyczeniaController implements Initializable {


    public TableView<Podsumowanie> tabelView;

    public TableColumn<Integer, Podsumowanie> tableViewWypozyczeniaId;
    public TableColumn<LocalDate, Podsumowanie> tableViewDataWynajmu;
    public TableColumn<LocalDate, Podsumowanie> tableViewDataZwrotu;

    public TableColumn<Integer, Podsumowanie> tableViewPracownicyID;
    public TableColumn<String, Podsumowanie> tableViewPracownicyImie;
    public TableColumn<String, Podsumowanie> tableViewPracownicyNazwisko;

    public TableColumn<Integer, Podsumowanie> tableViewKlienciID;
    public TableColumn<String, Podsumowanie> tableViewKlienciImie;
    public TableColumn<String, Podsumowanie> tableViewKlienciNazwisko;
    public TableColumn<Integer, Podsumowanie> tableViewKlienciNIP;
    public TableColumn<Integer, Podsumowanie> tableViewKlienciNrTel;

    public TableColumn<Integer, Podsumowanie> tableViewSamochodyID;
    public TableColumn<String, Podsumowanie> tableViewSamochodyMarka;
    public TableColumn<Integer, Podsumowanie> tableViewSamochodyRok;
    public TableColumn<Integer, Podsumowanie> tableViewSamochodyIlosc;
    public TableColumn<String, Podsumowanie> tableViewSamochodySkrzynia;
    public TableColumn<String, Podsumowanie> tableViewSamochodyKolor;
    public TableColumn<Double, Podsumowanie> tableViewSamochodyCena;

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
        List<Wypozyczenia> tempWypozyczenia = null;


        boolean przerwanie;
        for (Wypozyczenia wypozyczenie : wypozyczeniaList) {
            podsumowanie = new Podsumowanie();
            //Wypożyczenia
           // System.out.print("\n" + wypozyczenie.getId_wypozyczenia() + " " + wypozyczenie.getData_wynajmu() + " " + wypozyczenie.getData_zwrotu() + " ");

            podsumowanie.setIdWypozyczenia(wypozyczenie.getId_wypozyczenia());
            podsumowanie.setDataWynajmu(wypozyczenie.getData_wynajmu());
            podsumowanie.setDataZwrotu(wypozyczenie.getData_zwrotu());

            //pracownicy
            przerwanie = false;
            for (Pracownicy pracownik : pracownicyList) {
                tempWypozyczenia = pracownik.getWypozyczeniaList();
                for (Wypozyczenia temp : tempWypozyczenia) {
                    if (wypozyczenie.getId_wypozyczenia() == temp.getId_wypozyczenia()) {
                       // System.out.print(pracownik.getId_pracownika() + " " + pracownik.getImie() + " " + pracownik.getNazwisko() + " ");

                        podsumowanie.setIdPracownika(pracownik.getId_pracownika());
                        podsumowanie.setImiePracownika(pracownik.getImie());
                        podsumowanie.setNazwiskoPracownika(pracownik.getNazwisko());

                        przerwanie = true;
                        break;
                    }
                }
                if (przerwanie) {
                    break;
                }
            }
            //klienci
            przerwanie = false;
            for (Klienci klienci : klienciList) {
                tempWypozyczenia = klienci.getWypozyczeniaList();
                for (Wypozyczenia temp : tempWypozyczenia) {
                    if (wypozyczenie.getId_wypozyczenia() == temp.getId_wypozyczenia()) {
                      //  System.out.print(klienci.getId_klienta() + " " + klienci.getImie() + " " + klienci.getNazwisko() + " " + klienci.getNip() + " " + klienci.getNr_telefonu() + " ");

                        podsumowanie.setIdKlienta(klienci.getId_klienta());
                        podsumowanie.setImieKlienta(klienci.getImie());
                        podsumowanie.setNazwikosKlienta(klienci.getNazwisko());
                        podsumowanie.setNIP(klienci.getNip());
                        podsumowanie.setNrTelefonu(klienci.getNr_telefonu());

                        przerwanie = true;
                        break;
                    }
                }
                if (przerwanie) {
                    break;
                }
            }

            //samochody
            przerwanie = false;
            for (Samochody samochody : samochodyList) {
                tempWypozyczenia = samochody.getWypozyczeniaList();
                for (Wypozyczenia temp : tempWypozyczenia) {
                    if (wypozyczenie.getId_wypozyczenia() == temp.getId_wypozyczenia()) {
                       // System.out.print(samochody.getId_samochodu() + " " + samochody.getMarka() + " " + samochody.getRok() + " " + samochody.getIlosc_miejsc() + " " + samochody.getTyp() + " " + samochody.getKolor() + " " + samochody.getCena_za_wynajem());

                        podsumowanie.setIdSamochodu(samochody.getId_samochodu());
                        podsumowanie.setMarka(samochody.getMarka());
                        podsumowanie.setRok(samochody.getRok());
                        podsumowanie.setIloscMiejsc(samochody.getIlosc_miejsc());
                        podsumowanie.setSkrzyniaBiegów(samochody.getTyp());
                        podsumowanie.setKolor(samochody.getKolor());
                        podsumowanie.setCena(samochody.getCena_za_wynajem());

                        przerwanie = true;
                        break;
                    }
                }
                if (przerwanie) {
                    break;
                }
            }

            //dodanie do listy
            podsumowanieList.add(podsumowanie);
        }

        session.close();
        factory.close();

        wpisywanieDoTablicy(podsumowanieList);
    }

    public void onActionWroc(ActionEvent actionEvent) {
        Optional<ButtonType> wynik = Dialogs.anulowanieDodawaniaSamochodu();
        if (wynik.get() == ButtonType.OK) {
            SceneMenager.renderScene("menuGlowneAdmin");
        }
    }

    public void wpisywanieDoTablicy(List<Podsumowanie> podsumowanieList) {

        tableViewWypozyczeniaId.setCellValueFactory(new PropertyValueFactory<>("idWypozyczenia"));
        tableViewDataWynajmu.setCellValueFactory(new PropertyValueFactory<>("dataWynajmu"));
        tableViewDataZwrotu.setCellValueFactory(new PropertyValueFactory<>("dataZwrotu"));

        tableViewPracownicyID.setCellValueFactory(new PropertyValueFactory<>("idPracownika"));
        tableViewPracownicyImie.setCellValueFactory(new PropertyValueFactory<>("imiePracownika"));
        tableViewPracownicyNazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwiskoPracownika"));

        tableViewKlienciID.setCellValueFactory(new PropertyValueFactory<>("idKlienta"));
        tableViewKlienciImie.setCellValueFactory(new PropertyValueFactory<>("imieKlienta"));
        tableViewKlienciNazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwikosKlienta"));
        tableViewKlienciNIP.setCellValueFactory(new PropertyValueFactory<>("NIP"));
        tableViewKlienciNrTel.setCellValueFactory(new PropertyValueFactory<>("nrTelefonu"));

        tableViewSamochodyID.setCellValueFactory(new PropertyValueFactory<>("idSamochodu"));
        tableViewSamochodyMarka.setCellValueFactory(new PropertyValueFactory<>("marka"));
        tableViewSamochodyRok.setCellValueFactory(new PropertyValueFactory<>("rok"));
        tableViewSamochodyIlosc.setCellValueFactory(new PropertyValueFactory<>("iloscMiejsc"));
        tableViewSamochodySkrzynia.setCellValueFactory(new PropertyValueFactory<>("skrzyniaBiegów"));
        tableViewSamochodyKolor.setCellValueFactory(new PropertyValueFactory<>("kolor"));
        tableViewSamochodyCena.setCellValueFactory(new PropertyValueFactory<>("cena"));

        for (Podsumowanie current : podsumowanieList) {
            tabelView.getItems().add(current);
        }

    }
}
