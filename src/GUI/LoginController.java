package GUI;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Main.Kunde;
import Main.Verwaltungspersonal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class LoginController implements Initializable{
	
	@FXML
    private Label label;

    @FXML
    public Button btnlogin;

    @FXML
    public TextField txtuname;

    @FXML
    public PasswordField txtpass;

    @FXML
    public ImageView imageView;
    
    @FXML
    void login(ActionEvent event) {
        String uname = txtuname.getText();
        String pass = txtpass.getText();
        UserDao dao = new UserDao();
        PersonalDao pdao = new PersonalDao();
        
        Kunde kunde = dao.getKundeObject(uname, pass);
        Verwaltungspersonal personal = pdao.getPersonalObject(uname, pass);
        if(kunde == null && personal == null) {
        	new Alert(Alert.AlertType.ERROR, "Benutzername oder Passwort ungültig!").showAndWait();
            txtuname.setText("");
            txtpass.setText("");
            txtuname.requestFocus();
        } 
        else if(personal != null || kunde != null){
        	try {
        		if(personal != null) {
        			App.changeStage(event, "Dashboard.fxml", "Autohändler Dashboard");
                	new Alert(Alert.AlertType.CONFIRMATION, "Erfolgreich Einloggen!").showAndWait();
        		}
        		else if(kunde != null) {
        			App.changeStage(event, "KundeDashboard.fxml", "Autohändler Dashboard");
        			new Alert(Alert.AlertType.CONFIRMATION, "Erfolgreich Einloggen!").showAndWait();
        		}
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
    

}
