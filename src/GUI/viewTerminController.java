package GUI;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Main.Termin;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class viewTerminController implements Initializable{
	
	Database connectNow = new Database();
	ObservableList<Termin> list;
	
	@FXML
	public Button getinfo;
	@FXML
    public TextField terminid;
	@FXML
	public Button getinfo1;
	@FXML
    public TextField kundeid;
	@FXML
    private TableView<Termin> terminView;
    @FXML
    private TableColumn<Termin, String> termin_id;
    @FXML
    private TableColumn<Termin, String> kunde_id;
    @FXML
    private TableColumn<Termin, String> date;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initiateColumns();
        loadData();

    }
	
	private void initiateColumns() {
		termin_id.setCellValueFactory(new PropertyValueFactory<>("termin_id"));
        kunde_id.setCellValueFactory(new PropertyValueFactory<>("kunde_id"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
    }
	
	private void loadData() {
        list = connectNow.getTermine();
        terminView.getItems().addAll(list);
    }
	
	@FXML
	private void deleteTermin() {
		
		String id = terminid.getText();
		
		if(connectNow.terminExists(id) == true) {
			connectNow.löscheTermin(id);
			terminid.setText("");
			refreshTabelle();
		}
		else {
			Alert alert = new Alert(Alert.AlertType.ERROR, "Termin existiert nicht!");
		    alert.showAndWait();
		}
	}
	
	@FXML
	private void getInfo() {
		
		String id = kundeid.getText();
		list = connectNow.getTermin(id);
		terminView.getItems().clear();
		terminView.getItems().addAll(list);
    }
	
	@FXML
    private void refreshTabelle() {
        list = connectNow.getTermine();
        loadData();
        terminView.setItems(list);
    }

	@FXML
    private void redDashboard(ActionEvent event){
        try {
            App.changeStage(event,"Dashboard.fxml","Dashboard");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } 
    }
}
