package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class addServiceController implements Initializable{
	
	@FXML
	public TextField serviceidtxt;
    @FXML
    public TextField kundeidtxt;
    @FXML
    public TextField infotxt;
    @FXML
    public Button absagenbtn;
    @FXML
    public Button addservicebtn;
    
    @FXML
    void addService() {
    	String serviceid = serviceidtxt.getText();
    	String kundeid = kundeidtxt.getText();
    	String info = infotxt.getText();
    	
    	if (serviceid.equals("") || kundeid.equals("") || info.equals("")) {
			new Alert(Alert.AlertType.ERROR, "Einige Felder waren leer!").showAndWait();
        } 
		else {
			Database connectNow = new Database();
            Connection connectDb = Database.getDBConnection();
            
            boolean result = connectNow.createService(serviceid, kundeid, info);
            
            if (!result) {
            	new Alert(Alert.AlertType.ERROR, "Service existiert!").showAndWait();
            }
            if (result) {
            	new Alert(Alert.AlertType.CONFIRMATION, "Service hinzugefügt!").showAndWait();
            	serviceidtxt.setText("");
            	kundeidtxt.setText("");
            	infotxt.setText("");
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
	public void initialize(URL arg0, ResourceBundle arg1) {		
	}

}
