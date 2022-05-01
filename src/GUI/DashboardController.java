package GUI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class DashboardController {
	
	@FXML
    public Button redaddpatientbtn;
    @FXML
    public Button showpatientenbtn;
    @FXML
    public Button adduserbtn;
    @FXML
    public ImageView imageView;
    @FXML
    public Button redLoginbtn;

    @FXML
    void redaddpatient(ActionEvent event) {
        try {
            App.changeStage(event, "addPatient.fxml", "Patient hinzufuegen");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void redAddKunde(ActionEvent event){
        try {
            App.changeStage(event, "addKunde.fxml", "Kunde hinzufügen");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void redpatienten(ActionEvent event) {
        try {
            App.changeStage(event, "viewPatienten.fxml", "Patienten ansehen");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    private void redLogin(ActionEvent event){
        try {
            App.changeStage(event,"LoginPage.fxml","Autohändler");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
