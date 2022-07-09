package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Main.Service;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class viewOnlyServiceController implements Initializable{
	
	Database connectNow = new Database();
	ObservableList<Service> list;
	
	@FXML
	public Button getinfo;
	@FXML
    public TextField kundeid;
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

    }
	
	private void initiateColumns() {
		service_id.setCellValueFactory(new PropertyValueFactory<>("service_id"));
        kunde_id.setCellValueFactory(new PropertyValueFactory<>("kunde_id"));
        info.setCellValueFactory(new PropertyValueFactory<>("info"));
    }
	
	@FXML
	private void getInfo() {
		
		String id = kundeid.getText();
		
		list = connectNow.getService(id);
		serviceView.getItems().addAll(list);

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
