package hibernate;

import java.time.LocalDate;

public class Podsumowanie {
    //Wypożyczenia
    private int idWypozyczenia;
    private LocalDate dataWynajmu;
    private LocalDate dataZwrotu;

    //Pracownicy
    private int idPracownika;
    private String imiePracownika;
    private String nazwiskoPracownika;

    //Klient
    private int idKlienta;
    private String imieKlienta;
    private String nazwikosKlienta;
    private int NIP;
    private int nrTelefonu;

    //Samochód
    private int idSamochodu;
    private String marka;
    private int rok;
    private int iloscMiejsc;
    private String skrzyniaBiegów;
    private String kolor;
    private double cena;

    public Podsumowanie(int idWypozyczenia, LocalDate dataWynajmu, LocalDate dataZwrotu, int idPracownika, String imiePracownika, String nazwiskoPracownika, int idKlienta, String imieKlienta, String nazwikosKlienta, int NIP, int nrTelefonu, int idSamochodu, String marka, int rok, int iloscMiejsc, String skrzyniaBiegów, String kolor, double cena) {
        this.idWypozyczenia = idWypozyczenia;
        this.dataWynajmu = dataWynajmu;
        this.dataZwrotu = dataZwrotu;
        this.idPracownika = idPracownika;
        this.imiePracownika = imiePracownika;
        this.nazwiskoPracownika = nazwiskoPracownika;
        this.idKlienta = idKlienta;
        this.imieKlienta = imieKlienta;
        this.nazwikosKlienta = nazwikosKlienta;
        this.NIP = NIP;
        this.nrTelefonu = nrTelefonu;
        this.idSamochodu = idSamochodu;
        this.marka = marka;
        this.rok = rok;
        this.iloscMiejsc = iloscMiejsc;
        this.skrzyniaBiegów = skrzyniaBiegów;
        this.kolor = kolor;
        this.cena = cena;
    }

    public Podsumowanie() {
    }

    public int getIdWypozyczenia() {
        return idWypozyczenia;
    }

    public void setIdWypozyczenia(int idWypozyczenia) {
        this.idWypozyczenia = idWypozyczenia;
    }

    public LocalDate getDataWynajmu() {
        return dataWynajmu;
    }

    public void setDataWynajmu(LocalDate dataWynajmu) {
        this.dataWynajmu = dataWynajmu;
    }

    public LocalDate getDataZwrotu() {
        return dataZwrotu;
    }

    public void setDataZwrotu(LocalDate dataZwrotu) {
        this.dataZwrotu = dataZwrotu;
    }

    public int getIdPracownika() {
        return idPracownika;
    }

    public void setIdPracownika(int idPracownika) {
        this.idPracownika = idPracownika;
    }

    public int getIdKlienta() {
        return idKlienta;
    }

    public void setIdKlienta(int idKlienta) {
        this.idKlienta = idKlienta;
    }

    public int getIdSamochodu() {
        return idSamochodu;
    }

    public void setIdSamochodu(int idSamochodu) {
        this.idSamochodu = idSamochodu;
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
