package GUI;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Main.Kunde;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewOnlyKundeController implements Initializable{
	
	Database connectNow = new Database();
	ObservableList<Kunde> list;
	
	@FXML
	public Button getinfo;
	@FXML
    public TextField kundeid;
	@FXML
    private TableView<Kunde> kundeView;
    @FXML
    private TableColumn<Kunde, String> id;
    @FXML
    private TableColumn<Kunde, String> name;
    @FXML
    private TableColumn<Kunde, String> vorname;
    @FXML
    private TableColumn<Kunde, String> telefonnummer;
    @FXML
    private TableColumn<Kunde, String> ausweisnummer;
    @FXML
    private TableColumn<Kunde, String> versicherungTyp;
    @FXML
    private TableColumn<Kunde, String> adresse;
    @FXML
    private TableColumn<Kunde, String> email;
    @FXML
    private TableColumn<Kunde, String> benutzerkonto;
    @FXML
    private TableColumn<Kunde, String> passwort;
	
	@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initiateColumns();

    }
	
	private void initiateColumns() {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        vorname.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        telefonnummer.setCellValueFactory(new PropertyValueFactory<>("telefonNummer"));
        ausweisnummer.setCellValueFactory(new PropertyValueFactory<>("ausweisNummer"));
        id.setCellValueFactory(new PropertyValueFactory<>("kunde_id"));
        versicherungTyp.setCellValueFactory(new PropertyValueFactory<>("versicherungsTyp"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        benutzerkonto.setCellValueFactory(new PropertyValueFactory<>("benutzerKonto"));
        passwort.setCellValueFactory(new PropertyValueFactory<>("passwort"));
    }
	
	@FXML
	private void getInfo() {
		
		String id = kundeid.getText();
		list = connectNow.getKunden1(id);
		kundeView.getItems().clear();
		kundeView.getItems().addAll(list);

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
