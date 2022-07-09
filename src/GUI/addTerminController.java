package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class addTerminController implements Initializable{
	
	@FXML
	public TextField terminidtxt;
    @FXML
    public TextField kundeidtxt;
    @FXML
    public TextField datetxt;
    @FXML
    public Button absagenbtn;
    @FXML
    public Button addterminbtn;
    
    @FXML
    void addTermin() {
    	String terminid = terminidtxt.getText();
    	String kundeid = kundeidtxt.getText();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    	LocalDate Date = LocalDate.parse(datetxt.getText(), formatter);
    	
    	if (terminid.equals("") || kundeid.equals("") || Date.equals("")) {
			new Alert(Alert.AlertType.ERROR, "Einige Felder waren leer!").showAndWait();
        } 
		else {
			Database connectNow = new Database();
            Connection connectDb = Database.getDBConnection();
            boolean result = connectNow.createTermin(terminid, kundeid, Date);
            
            if (!result) {
            	new Alert(Alert.AlertType.ERROR, "Termin existiert!").showAndWait();
            }
            if (result) {
            	new Alert(Alert.AlertType.CONFIRMATION, "Termin hinzugefügt!").showAndWait();
            	terminidtxt.setText("");
            	kundeidtxt.setText("");
            	datetxt.setText("");
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
		// TODO Auto-generated method stub
		
	}

}
