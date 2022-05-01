package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Main.Kunde;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewKundeController implements Initializable {
	
	UserDao user = new UserDao();
	ObservableList<Kunde> list;
	
	@FXML
    private TableView<Kunde> kundeView;
    @FXML
    private TableColumn<Kunde, String> ids;
    @FXML
    private TableColumn<Kunde, String> namen;
    @FXML
    private TableColumn<Kunde, String> vornamen;
    @FXML
    private TableColumn<Kunde, String> telefonnummern;
    @FXML
    private TableColumn<Kunde, String> ausweisnummern;
    @FXML
    private TableColumn<Kunde, String> versicherungTyps;
    @FXML
    private TableColumn<Kunde, String> adressen;
    @FXML
    private TableColumn<Kunde, String> emails;
    @FXML
    private TableColumn<Kunde, String> benutzerkontos;
    @FXML
    private TableColumn<Kunde, String> passwörter;
	
	
	
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
        ids.setCellValueFactory(new PropertyValueFactory<>("kunde_id"));
        versicherungTyps.setCellValueFactory(new PropertyValueFactory<>("versicherungsTyp"));
        adressen.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        emails.setCellValueFactory(new PropertyValueFactory<>("email"));
        benutzerkontos.setCellValueFactory(new PropertyValueFactory<>("benutzerKonto"));
        passwörter.setCellValueFactory(new PropertyValueFactory<>("passwort"));
    }
	
	private void loadData() {
        list = user.getKunden();
        kundeView.getItems().addAll(list);
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
