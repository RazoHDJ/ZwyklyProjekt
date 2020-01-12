package hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Wypozyczenia implements Serializable {
    private static final long serialVersionUID = 3206932015916041940L;

    @Column(name = "id_wypozyczenia")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_wypozyczenia;


    @Column(name = "data_wynajmu")
    private LocalDate data_wynajmu;

    @Column(name = "data_zwrotu")
    private LocalDate data_zwrotu;

    public Wypozyczenia() {
    }

    public Wypozyczenia(LocalDate data_wynajmu, LocalDate data_zwrotu) {
        this.data_wynajmu = data_wynajmu;
        this.data_zwrotu = data_zwrotu;
    }

    public int getId_wypozyczenia() {
        return id_wypozyczenia;
    }

    public LocalDate getData_wynajmu() {
        return data_wynajmu;
    }

    public void setData_wynajmu(LocalDate data_wynajmu) {
        this.data_wynajmu = data_wynajmu;
    }

    public LocalDate getData_zwrotu() {
        return data_zwrotu;
    }

    public void setData_zwrotu(LocalDate data_zwrotu) {
        this.data_zwrotu = data_zwrotu;
    }
}
