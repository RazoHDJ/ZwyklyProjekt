package hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Wypozyczenia implements Serializable {
    private static final long serialVersionUID = 3206932015916041940L;

    @Column(name = "id_wypozyczenia")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_wypozyczenia;


    @Column(name = "data_wynajmu")
    private int data_wynajmu;

    @Column(name = "data_zwrotu")
    private int data_zwrotu;

    public Wypozyczenia() {
    }

    public Wypozyczenia(int data_wynajmu, int data_zwrotu) {
        this.data_wynajmu = data_wynajmu;
        this.data_zwrotu = data_zwrotu;
    }

    public int getData_wynajmu() {
        return data_wynajmu;
    }

    public void setData_wynajmu(int data_wynajmu) {
        this.data_wynajmu = data_wynajmu;
    }

    public int getData_zwrotu() {
        return data_zwrotu;
    }

    public void setData_zwrotu(int data_zwrotu) {
        this.data_zwrotu = data_zwrotu;
    }


}
