package hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "klienci")
public class Klienci implements Serializable {

    private static final long serialVersionUID = 6845019164835891520L;

    @Column(name = "id_klienta")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_klienta;

    @Column(name = "imie")
    private String imie;

    @Column(name = "nazwisko")
    private String nazwisko;

    @Column(name = "NIP")
    private int nip;

    @Column(name = "nr_telefonu")
    private int nr_telefonu;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_klienta")
    private List<Wypozyczenia> wypozyczeniaList;

    public Klienci() {
    }

    public Klienci(String imie, String nazwisko, int nip, int nr_telefonu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nip = nip;
        this.nr_telefonu = nr_telefonu;
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

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }

    public int getNr_telefonu() {
        return nr_telefonu;
    }

    public void setNr_telefonu(int nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }

    public List<Wypozyczenia> getWypozyczeniaList() {
        return this.wypozyczeniaList;
    }

    public void setWypozyczeniaList(List<Wypozyczenia> wypozyczeniaList) {
        this.wypozyczeniaList = wypozyczeniaList;
    }

    public int getId_klienta() {
        return id_klienta;
    }

    public void addWypozyczenie(Wypozyczenia noweWypozyczenie){
        if (wypozyczeniaList == null) {
            wypozyczeniaList = new ArrayList<>();
        }
        wypozyczeniaList.add(noweWypozyczenie);
    }
}
