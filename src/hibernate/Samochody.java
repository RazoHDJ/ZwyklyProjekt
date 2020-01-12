package hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "samochody")
public class Samochody implements Serializable {
    private static final long serialVersionUID = -3242662756121093792L;

    @Column(name = "id_samochodu")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_samochodu;

    @Column(name = "marka")
    private String marka;

    @Column(name = "typ")
    private String typ;

    @Column(name = "rok")
    private int rok;

    @Column(name = "kolor")
    private String kolor;

    @Column(name = "ilosc_miejsc")
    private int ilosc_miejsc;

    @Column(name = "cena_wynajmu_za_dzien")
    private double cena_za_wynajem;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_samochodu" )
    private List<Wypozyczenia> wypozyczeniaList;

    public Samochody() {
    }

    public Samochody(String marka, String typ, int rok, String kolor, int ilosc_miejsc, double cena_za_wynajem) {
        this.marka = marka;
        this.typ = typ;
        this.rok = rok;
        this.kolor = kolor;
        this.ilosc_miejsc = ilosc_miejsc;
        this.cena_za_wynajem = cena_za_wynajem;
    }

    public int getId_samochodu() {
        return id_samochodu;
    }

    public int getIlosc_miejsc() {
        return ilosc_miejsc;
    }

    public void setIlosc_miejsc(int ilosc_miejsc) {
        this.ilosc_miejsc = ilosc_miejsc;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public double getCena_za_wynajem() {
        return cena_za_wynajem;
    }

    public void setCena_za_wynajem(double cena_za_wynajem) {
        this.cena_za_wynajem = cena_za_wynajem;
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
}
