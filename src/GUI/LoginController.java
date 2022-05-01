package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Main.Kunde;
import Main.Verwaltungspersonal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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
            JOptionPane.showMessageDialog(null, "Ungültiger Benutzername oder Passwort");
            txtuname.setText("");
            txtpass.setText("");
            txtuname.requestFocus();
        } 
        else if(personal != null || kunde != null){
        	try {
            	App.changeStage(event, "Dashboard.fxml", "Autohändler Dashboard");
                /*JOptionPane.showMessageDialog(null, "Erfolgreich eingeloggt");
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("LoginPage.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setTitle("Autohändler");
                stage.setScene(scene);
                stage.show();*/
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
    

}
