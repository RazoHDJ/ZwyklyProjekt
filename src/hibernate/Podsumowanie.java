package hibernate;

public class Podsumowanie {

    private String imiePracownika;
    private String nazwiskoPracownika;

    private String imieKlienta;
    private String nazwikosKlienta;
    private int NIP;
    private int nrTelefonu;

    private String marka;
    private int rok;
    private int iloscMiejsc;
    private String skrzyniaBiegów;
    private String kolor;
    private double cena;

    public Podsumowanie(String imiePracownika, String nazwiskoPracownika, String imieKlienta, String nazwikosKlienta, int NIP, int nrTelefonu, String marka, int rok, int iloscMiejsc, String skrzyniaBiegów, String kolor, double cena) {
        this.imiePracownika = imiePracownika;
        this.nazwiskoPracownika = nazwiskoPracownika;
        this.imieKlienta = imieKlienta;
        this.nazwikosKlienta = nazwikosKlienta;
        this.NIP = NIP;
        this.nrTelefonu = nrTelefonu;
        this.marka = marka;
        this.rok = rok;
        this.iloscMiejsc = iloscMiejsc;
        this.skrzyniaBiegów = skrzyniaBiegów;
        this.kolor = kolor;
        this.cena = cena;
    }

    public Podsumowanie() {
    }

    public String getImiePracownika() {
        return imiePracownika;
    }

    public void setImiePracownika(String imiePracownika) {
        this.imiePracownika = imiePracownika;
    }

    public String getNazwiskoPracownika() {
        return nazwiskoPracownika;
    }

    public void setNazwiskoPracownika(String nazwiskoPracownika) {
        this.nazwiskoPracownika = nazwiskoPracownika;
    }

    public String getImieKlienta() {
        return imieKlienta;
    }

    public void setImieKlienta(String imieKlienta) {
        this.imieKlienta = imieKlienta;
    }

    public String getNazwikosKlienta() {
        return nazwikosKlienta;
    }

    public void setNazwikosKlienta(String nazwikosKlienta) {
        this.nazwikosKlienta = nazwikosKlienta;
    }

    public int getNIP() {
        return NIP;
    }

    public void setNIP(int NIP) {
        this.NIP = NIP;
    }

    public int getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(int nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public int getIloscMiejsc() {
        return iloscMiejsc;
    }

    public void setIloscMiejsc(int iloscMiejsc) {
        this.iloscMiejsc = iloscMiejsc;
    }

    public String getSkrzyniaBiegów() {
        return skrzyniaBiegów;
    }

    public void setSkrzyniaBiegów(String skrzyniaBiegów) {
        this.skrzyniaBiegów = skrzyniaBiegów;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
}
