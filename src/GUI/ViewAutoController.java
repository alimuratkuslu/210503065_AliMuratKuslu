package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Main.Auto;
import Main.Kunde;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewAutoController implements Initializable{
	
	ADao adao = new ADao();
	ObservableList<Auto> list;
	
	@FXML
    private TableView<Auto> autoView;
    @FXML
    private TableColumn<Auto, String> id;
    @FXML
    private TableColumn<Auto, String> name;
    @FXML
    private TableColumn<Auto, Integer> preis;
    @FXML
    private TableColumn<Auto, String> model;
    @FXML
    private TableColumn<Auto, String> fahrzeugtyp;
    @FXML
    private TableColumn<Auto, Integer> jahr;
    @FXML
    private TableColumn<Auto, String> treibstoffart;
    @FXML
    private TableColumn<Auto, String> getriebetyp;
    @FXML
    private TableColumn<Auto, Integer> motorleistung;
    @FXML
    private TableColumn<Auto, String> co2emission;
    @FXML
    private TableColumn<Auto, Integer> beschleunigung;
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
        list = adao.getAuto();
        autoView.getItems().addAll(list);
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
