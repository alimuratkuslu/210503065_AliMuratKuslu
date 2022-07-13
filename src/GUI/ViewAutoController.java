package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Main.Auto;
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

public class ViewAutoController implements Initializable{
	@FXML
	Database connectNow = new Database();
	ObservableList<Auto> list;
	
	@FXML
    public Button btnsearch;
    @FXML
    public TextField getName;
    @FXML
	public Button deleteautobtn;
	@FXML
    public TextField autoid;
	@FXML
    private TableView<Auto> autoView;
    @FXML
    private TableColumn<Auto, String> id;
    @FXML
    private TableColumn<Auto, String> name;
    @FXML
    private TableColumn<Auto, String> preis;
    @FXML
    private TableColumn<Auto, String> model;
    @FXML
    private TableColumn<Auto, String> fahrzeugtyp;
    @FXML
    private TableColumn<Auto, String> jahr;
    @FXML
    private TableColumn<Auto, String> treibstoffart;
    @FXML
    private TableColumn<Auto, String> getriebetyp;
    @FXML
    private TableColumn<Auto, String> motorleistung;
    @FXML
    private TableColumn<Auto, String> co2emission;
    @FXML
    private TableColumn<Auto, String> beschleunigung;
    @FXML
    private TableColumn<Auto, String> systemleistung;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initiateColumns();
        loadData();

    }
    
    private void initiateColumns() {
        id.setCellValueFactory(new PropertyValueFactory<>("auto_id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        preis.setCellValueFactory(new PropertyValueFactory<>("preis"));
        model.setCellValueFactory(new PropertyValueFactory<>("model"));
        fahrzeugtyp.setCellValueFactory(new PropertyValueFactory<>("fahrzeugTyp"));
        jahr.setCellValueFactory(new PropertyValueFactory<>("jahr"));
        treibstoffart.setCellValueFactory(new PropertyValueFactory<>("treibstoffArt"));
        getriebetyp.setCellValueFactory(new PropertyValueFactory<>("getriebeTyp"));
        motorleistung.setCellValueFactory(new PropertyValueFactory<>("motorLeistung"));
        co2emission.setCellValueFactory(new PropertyValueFactory<>("co2Emission"));
        beschleunigung.setCellValueFactory(new PropertyValueFactory<>("beschleunigung"));
        systemleistung.setCellValueFactory(new PropertyValueFactory<>("systemLeistung"));
    }
    
    private void loadData() {
        list = connectNow.getAuto1();
        autoView.getItems().addAll(list);
    }
    
    @FXML
    public void deleteAuto(){
    	
    	String id = autoid.getText();
    	
    	if(connectNow.autoExists(id) == true) {
    		connectNow.löscheAuto(id);
    		autoid.setText("");
    		refreshTabelle();
    	}
        else {
		    Alert alert = new Alert(Alert.AlertType.ERROR, "Auto existiert nicht!");
		    alert.showAndWait();
		}
    }
	
	@FXML
    private void redDashboard(ActionEvent event){
        try {
            App.changeStage(event,"Dashboard.fxml","Dashboard");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
	
	@FXML
    private void refreshTabelle() {
        list = connectNow.getAuto1();
        loadData();
        autoView.setItems(list);
    }
	
	@FXML
    private void getAutoName() {
        String auto_name = getName.getText();
        list = connectNow.getAutoName(auto_name);
        list.addAll(connectNow.getAutoName(auto_name));
        autoView.setItems(list);
        getName.setText("");
    }
}
