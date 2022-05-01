package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class addPersonalController implements Initializable {
	
	public Button absagenbtn;
    @FXML
    public Button adduserbtn;
    @FXML
    public TextField idaddpersonaltxt;
    @FXML
    public TextField usernameaddpersonaltxt;
    @FXML
    public PasswordField passwordaddpersonal;
    @FXML
    public TextField nameaddpersonaltxt;
    @FXML
    public TextField vornameaddpersonaltxt;
    @FXML
    public TextField tnummeraddpersonaltxt;
    @FXML
    public TextField anummeraddpersonaltxt;
    @FXML
    public TextField emailaddpersonaltxt;
    @FXML
    public TextField versicherungaddpersonaltxt;
    @FXML
    public TextField positionaddpersonaltxt;
	
	@FXML
	void addPersonal() {
		
		String name = nameaddpersonaltxt.getText();
		String vorname = vornameaddpersonaltxt.getText();
		String telefonNummer = tnummeraddpersonaltxt.getText();
		String ausweisNummer = anummeraddpersonaltxt.getText();
		String email = emailaddpersonaltxt.getText();
		String personal_id = idaddpersonaltxt.getText();
		String position = positionaddpersonaltxt.getText();
		String sozialVersicherungsNummer = versicherungaddpersonaltxt.getText();
		String benutzerKonto = usernameaddpersonaltxt.getText();
		String passwort = passwordaddpersonal.getText();
		
		if (personal_id == "0" || benutzerKonto.equals("") || passwort.equals("")) {
            JOptionPane.showMessageDialog(null, "Einige Felder waren leer");
        } 
		else {
            PersonalDao pdao = new PersonalDao();
            int result = pdao.savePersonal(name, vorname, telefonNummer, ausweisNummer, email, personal_id, position, sozialVersicherungsNummer, benutzerKonto, passwort);
            if (result == -1) JOptionPane.showMessageDialog(null, "Verwaltungspersonal existiert!");
            if (result == 0) {
                JOptionPane.showMessageDialog(null, "Verwaltungspersonal hinzugefügt!");
                idaddpersonaltxt.setText("");
                usernameaddpersonaltxt.setText("");
                passwordaddpersonal.setText("");
                nameaddpersonaltxt.setText("");
                vornameaddpersonaltxt.setText("");
                tnummeraddpersonaltxt.setText("");
                anummeraddpersonaltxt.setText("");
                emailaddpersonaltxt.setText("");
                versicherungaddpersonaltxt.setText("");
                positionaddpersonaltxt.setText("");
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
