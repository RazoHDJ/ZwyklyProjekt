package hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pracownicy")
public class Pracownicy implements Serializable {
    private static final long serialVersionUID = -3096169708825811959L;

    @Column(name = "id_pracownika")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pracownika;

    @Column(name = "imie")
    private String imie;

    @Column(name = "nazwisko")
    private String nazwisko;

    @Column(name = "zarobki")
    private double zarobki;

    @Column(name = "login")
    private String login;

    @Column(name = "haslo")
    private String haslo;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pracownika")
    private List<Wypozyczenia> wypozyczeniaList;

    public Pracownicy() {
    }

    public Pracownicy(String imie, String nazwisko, double zarobki) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.zarobki = zarobki;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public double getZarobki() {
        return zarobki;
    }

    public void setZarobki(double zarobki) {
        this.zarobki = zarobki;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public List<Wypozyczenia> getWypozyczeniaList() {
        return wypozyczeniaList;
    }

    public void setWypozyczeniaList(List<Wypozyczenia> wypozyczeniaList) {
        this.wypozyczeniaList = wypozyczeniaList;
    }

    public void addWypozyczenie(Wypozyczenia noweWypozyczenie){
        if (wypozyczeniaList == null) {
            wypozyczeniaList = new ArrayList<>();
        }
        wypozyczeniaList.add(noweWypozyczenie);
    }

    public int getId_pracownika() {
        return id_pracownika;
    }
}
