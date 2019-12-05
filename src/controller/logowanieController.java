package controller;

import aplikacja.SceneMenager;
import hibernate.AdminLoginInfo;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class logowanieController {
    public Label errorInLogin;
    private String correctPasswordAdmin = "admin";
    private String correctLoginAdmin = "admin";

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField loginField;

    @FXML
    void exitOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void zalogujOnAction(ActionEvent event) {
        boolean znaleziono = false;
        Configuration configuration = new Configuration().configure("hibernate/hibernate.cfg.xml");
        configuration.addAnnotatedClass(AdminLoginInfo.class);
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

        Criteria criteria = session.createCriteria(AdminLoginInfo.class);
        List<AdminLoginInfo> loginInfo = criteria.list();
        for(AdminLoginInfo current : loginInfo){
            if (current.getLogin().equals(loginField.getText()) && current.getPassword().equals(passwordField.getText())) {
                System.out.println("Pomyślnie zalogowano jako Admin");
                SceneMenager.renderScene("menuGlowneAdmin");
                znaleziono = true;
                break;
            }
        }
        if (!znaleziono){
            errorInLogin.setVisible(true);
        }
        session.close();
        factory.close();
    }

    @FXML
    void initialize() {



    }

}
