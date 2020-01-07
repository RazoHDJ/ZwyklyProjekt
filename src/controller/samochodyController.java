package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import hibernate.Samochody;
import hibernate.Wypozyczenia;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class samochodyController implements Initializable {
    @FXML
    private TableView<?> tableView;
    @FXML
    private TableColumn<Integer, Samochody> tableID;
    @FXML
    private TableColumn<String, Samochody> tableMarka;
    @FXML
    private TableColumn<Integer, Samochody> tableRok;
    @FXML
    private TableColumn<String, Samochody> tableMiejsca;
    @FXML
    private TableColumn<String, Samochody> tableSkrzynia;
    @FXML
    private TableColumn<String, Samochody> tableKolor;
    @FXML
    private TableColumn<Double, Samochody> tableCena;
    private Samochody xd;
    @FXML
    void initialize() {
        System.out.println("Stare");
        Configuration configuration = new Configuration().configure("hibernate/hibernate.cfg.xml");
        configuration.addAnnotatedClass(Samochody.class);
        configuration.addAnnotatedClass(Wypozyczenia.class);
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

        Criteria criteria = session.createCriteria(Samochody.class);
        List<Samochody> samochodyList = criteria.list();
//        TableColumn<String, Samochody> firstColumn = new TableColumn<>("Jeden");
//        firstColumn.setCellValueFactory(new PropertyValueFactory<>(new Samochody().getKolor()));
//        tableID.setCellValueFactory(new PropertyValueFactory<>(samochodyList.));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Elo nowe");
    }
}
