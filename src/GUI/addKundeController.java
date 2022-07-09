package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


public class addKundeController implements Initializable{
	
	public Button absagenbtn;
    @FXML
    public Button adduserbtn;
    @FXML
    public TextField idaddkundetxt;
    @FXML
    public TextField usernameaddkundetxt;
    @FXML
    public PasswordField passwordadkunde;
    @FXML
    public TextField nameaddkundetxt;
    @FXML
    public TextField vornameaddkundetxt;
    @FXML
    public TextField tnummeraddkundetxt;
    @FXML
    public TextField anummeraddkundetxt;
    @FXML
    public TextField emailaddkundetxt;
    @FXML
    public TextField versicherungaddkundetxt;
    @FXML
    public TextField adresseaddkundetxt;
    @FXML
    public ImageView imageView;


    @FXML
    void addKunde() throws SQLException {
        int id = 0;
        try{
            id = Integer.parseInt(idaddkundetxt.getText());
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ID nicht gültig!");
            return;
        }
        String name = nameaddkundetxt.getText();
        String vorname = vornameaddkundetxt.getText();
        String telefonNummer = tnummeraddkundetxt.getText();
        String ausweisNummer = anummeraddkundetxt.getText();
        String email = emailaddkundetxt.getText();
        String kunde_id = idaddkundetxt.getText();
        String versicherungsTyp = versicherungaddkundetxt.getText();
        String adresse = adresseaddkundetxt.getText();
        String benutzerKonto = usernameaddkundetxt.getText();
        String passwort = passwordadkunde.getText();

        if (id == 0 || benutzerKonto.equals("") || passwort.equals("")) {
        	new Alert(Alert.AlertType.ERROR, "Einige Felder waren leer!").showAndWait();
        } else {
        	Database connectNow = new Database();
            boolean result = connectNow.saveKunde(name, vorname, telefonNummer, ausweisNummer, email, kunde_id, versicherungsTyp, adresse, benutzerKonto, passwort);
            if (!result) {
            	new Alert(Alert.AlertType.ERROR, "Kunde existiert!").showAndWait();
            }
            if (result) {
            	new Alert(Alert.AlertType.CONFIRMATION, "Kunde hinzugefügt!").showAndWait();
                idaddkundetxt.setText("");
                usernameaddkundetxt.setText("");
                passwordadkunde.setText("");
                nameaddkundetxt.setText("");
                vornameaddkundetxt.setText("");
                tnummeraddkundetxt.setText("");
                anummeraddkundetxt.setText("");
                emailaddkundetxt.setText("");
                versicherungaddkundetxt.setText("");
                adresseaddkundetxt.setText("");
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
