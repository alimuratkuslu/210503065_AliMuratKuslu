package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Main.Service;
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

public class viewServiceController implements Initializable {
	
	Database connectNow = new Database();
	ObservableList<Service> list;
	
	@FXML
	public Button getinfo;
	@FXML
    public TextField kundeid;
	@FXML
	public Button getinfo1;
	@FXML
    public TextField kundeid1;
	@FXML
    private TableView<Service> serviceView;
    @FXML
    private TableColumn<Service, String> service_id;
    @FXML
    private TableColumn<Service, String> kunde_id;
    @FXML
    private TableColumn<Service, String> info;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initiateColumns();
        loadData();

    }
	
	private void initiateColumns() {
		service_id.setCellValueFactory(new PropertyValueFactory<>("service_id"));
        kunde_id.setCellValueFactory(new PropertyValueFactory<>("kunde_id"));
        info.setCellValueFactory(new PropertyValueFactory<>("info"));
    }
	
	private void loadData() {
        list = connectNow.getService1();
        serviceView.getItems().addAll(list);
    }
	
	@FXML
	private void deleteService() {
		
		String id = kundeid.getText();
		
		if(connectNow.serviceExists(id) == true) {
			connectNow.löscheService(id);
			kundeid.setText("");
		}
		else {
			Alert alert = new Alert(Alert.AlertType.ERROR, "Service existiert nicht!");
		    alert.showAndWait();
		}
	}
	
	@FXML
	private void getInfo() {
		
		String id = kundeid1.getText();
		list = connectNow.getService(id);
		serviceView.getItems().addAll(list);
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
