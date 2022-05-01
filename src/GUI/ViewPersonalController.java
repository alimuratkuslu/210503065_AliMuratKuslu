package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Main.Verwaltungspersonal;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewPersonalController implements Initializable{
	
	PersonalDao pdao = new PersonalDao();
	ObservableList<Verwaltungspersonal> list;
	
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
    
    private void loadData() {
        list = pdao.getPersonal();
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
