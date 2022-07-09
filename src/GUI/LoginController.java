package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Main.Kunde;
import Main.Verwaltungspersonal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
    private Label loginMessageLabel;
    
    @FXML
    public ImageView imageView;
    
    @FXML
    void login(ActionEvent event) throws IOException, SQLException{
    	
    	String uname = txtuname.getText();
        String pass = txtpass.getText();
        
        if(txtuname.getText().isBlank() == false && txtpass.getText().isBlank() == false ) {

        	Database connectNow = new Database();
            Connection connectDb = Database.getDBConnection();
            
            Verwaltungspersonal personal = connectNow.validateLoginPersonal(txtuname.getText(),txtpass.getText());
            Kunde kunde = connectNow.validateLoginKunde(txtuname.getText(), txtpass.getText());

            if(personal != null && kunde == null) {
                String username = txtuname.getText();
                String password = txtpass.getText();
                App.changeStage(event,"Dashboard.fxml", "Autohändler Dashboard" );
            }
            else if(kunde != null && personal == null) {
            	String username = txtuname.getText();
                String password = txtpass.getText();
                App.changeStage(event,"KundeDashboard.fxml", "Autohändler Dashboard" );
            }
            
            else {
            	new Alert(Alert.AlertType.ERROR, "Benutzername oder Passwort ungültig!").showAndWait();
            }

        }else{
        	new Alert(Alert.AlertType.ERROR, "Benutzername oder Passwort ungültig!").showAndWait();
        }
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
    

}
