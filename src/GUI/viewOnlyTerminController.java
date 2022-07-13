package GUI;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Main.Termin;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class viewOnlyTerminController implements Initializable{
	
	Database connectNow = new Database();
	ObservableList<Termin> list;
	
	@FXML
	public Button getinfo;
	@FXML
    public TextField terminid;
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

    }
	
	private void initiateColumns() {
		termin_id.setCellValueFactory(new PropertyValueFactory<>("termin_id"));
        kunde_id.setCellValueFactory(new PropertyValueFactory<>("kunde_id"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
    }
	
	@FXML
	private void getInfo() {
		
		String id = terminid.getText();
		list = connectNow.getTermin(id); 
		terminView.getItems().clear();
		terminView.getItems().addAll(list);
    }

	@FXML
    private void redKundeDashboard(ActionEvent event){
        try {
            App.changeStage(event,"KundeDashboard.fxml","Dashboard");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } 
    }

}
