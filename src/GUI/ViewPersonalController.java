package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Main.Verwaltungspersonal;
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

public class ViewPersonalController implements Initializable{
	
	Database connectNow = new Database();
	ObservableList<Verwaltungspersonal> list;
	
	@FXML
	public Button deletepersonalbtn;
	@FXML
    public TextField personalid;
	@FXML
    private TableView<Verwaltungspersonal> personalView;
    @FXML
    private TableColumn<Verwaltungspersonal, String> ids;
    @FXML
    private TableColumn<Verwaltungspersonal, String> namen;
    @FXML
    private TableColumn<Verwaltungspersonal, String> vornamen;
    @FXML
    private TableColumn<Verwaltungspersonal, String> telefonnummern;
    @FXML
    private TableColumn<Verwaltungspersonal, String> ausweisnummern;
    @FXML
    private TableColumn<Verwaltungspersonal, String> versicherungnummern;
    @FXML
    private TableColumn<Verwaltungspersonal, String> positionen;
    @FXML
    private TableColumn<Verwaltungspersonal, String> emails;
    @FXML
    private TableColumn<Verwaltungspersonal, String> benutzerkontos;
    @FXML
    private TableColumn<Verwaltungspersonal, String> passwörter;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initiateColumns();
        loadData();

    }
    
    private void initiateColumns() {
        namen.setCellValueFactory(new PropertyValueFactory<>("name"));
        vornamen.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        telefonnummern.setCellValueFactory(new PropertyValueFactory<>("telefonNummer"));
        ausweisnummern.setCellValueFactory(new PropertyValueFactory<>("ausweisNummer"));
        ids.setCellValueFactory(new PropertyValueFactory<>("personal_id"));
        versicherungnummern.setCellValueFactory(new PropertyValueFactory<>("sozialVersicherungsNummer"));
        positionen.setCellValueFactory(new PropertyValueFactory<>("position"));
        emails.setCellValueFactory(new PropertyValueFactory<>("email"));
        benutzerkontos.setCellValueFactory(new PropertyValueFactory<>("benutzerKonto"));
        passwörter.setCellValueFactory(new PropertyValueFactory<>("passwort"));
    }
    
    @FXML
    private void refreshTabelle() {
        list = connectNow.getPersonal();
        loadData();
        personalView.setItems(list);
    }
    
    @FXML
    public void deletePersonal(){
    	
    	String id = personalid.getText();
    	 
        if (connectNow.personalExists(id) == true) {
			connectNow.löschePersonal(id);
			personalid.setText("");
			refreshTabelle();

		}else {
		    Alert alert = new Alert(Alert.AlertType.ERROR, "Kunde existiert nicht!");
		    alert.showAndWait();
		}
    }

    
    private void loadData() {
        list = connectNow.getPersonal();
        personalView.getItems().addAll(list);
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
