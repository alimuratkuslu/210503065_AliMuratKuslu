package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


public class addKundeController implements Initializable{
	
	public Button absagenbtn;
    @FXML
    public Button adduserbtn;
    @FXML
    public TextField idaddusertxt;
    @FXML
    public TextField usernameaddusertxt;
    @FXML
    public PasswordField passwordadduser;
    @FXML
    public ImageView imageView;


    @FXML
    void addKunde() throws SQLException {
        int id = 0;
        try{
            id = Integer.parseInt(idaddusertxt.getText());
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ID nicht gueltig!");
            return;
        }
        String name = usernameaddusertxt.getText();
        String vorname = passwordadduser.getText();
        String telefonNummer = "";
        String ausweisNummer = "";
        String email = "";
        String kunde_id = "";
        String versicherungsTyp = "";
        String adresse = "";
        String benutzerKonto = "";
        String passwort = "";

        if (id == 0 || benutzerKonto.equals("") || passwort.equals("")) {
            JOptionPane.showMessageDialog(null, "Einige Felder waren leer");
        } else {
            UserDao udao = new UserDao();
            int result = udao.saveKunde(name, vorname, telefonNummer, ausweisNummer, email, kunde_id, versicherungsTyp, adresse, benutzerKonto, passwort);
            if (result == -1) JOptionPane.showMessageDialog(null, "Kunde existiert!");
            if (result == 0) {
                JOptionPane.showMessageDialog(null, "Kunde hinzugefügt!");
                idaddusertxt.setText("");
                usernameaddusertxt.setText("");
                passwordadduser.setText("");
            }
        }
    }

    @FXML
    void redDashboard(ActionEvent event) {
        try {
            App.changeStage(event, "Dashboard.fxml", "Dashboard");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
	
	
}
