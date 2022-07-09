package GUI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class DashboardController {
	
	@FXML
    public Button redaddkundebtn;
    @FXML
    public Button showkundenbtn;
    @FXML
    public Button showpersonalbtn;
    @FXML
    public Button showautos;
    @FXML
    public Button redaddautos;
    @FXML
    public Button addkundebtn;
    @FXML
    public Button addterminbtn;
    @FXML
    public Button addservicebtn;
    @FXML
    public ImageView imageView;
    @FXML
    public Button redLoginbtn;

    @FXML
    void redAddPersonal(ActionEvent event) {
        try {
            App.changeStage(event, "addPersonal.fxml", "Verwaltungspersonal hinzufügen");
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
    void redAutos(ActionEvent event) {
        try {
            App.changeStage(event, "viewAuto.fxml", "Autos ansehen");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    @FXML
    void redAddAutos(ActionEvent event) {
        try {
            App.changeStage(event, "addAuto.fxml", "Autos hinzufügen");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void redKunden(ActionEvent event) {
        try {
            App.changeStage(event, "viewKunde.fxml", "Kunden ansehen");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    @FXML
    void redPersonal(ActionEvent event) {
        try {
            App.changeStage(event, "viewPersonal.fxml", "Verwaltungspersonal ansehen");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    @FXML
    void redAddTermin(ActionEvent event) {
        try {
            App.changeStage(event, "addTermin.fxml", "Termin hinzufügen");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    /*@FXML
    void redTermin(ActionEvent event) {
        try {
            App.changeStage(event, "addTermin.fxml", "Termin hinzufügen");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/
    
    @FXML
    void redAddService(ActionEvent event) {
        try {
            App.changeStage(event, "addService.fxml", "Service hinzufügen");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    /*@FXML
    void redService(ActionEvent event) {
        try {
            App.changeStage(event, "addService.fxml", "Service hinzufügen");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/
    
    @FXML
    private void redLogin(ActionEvent event){
        try {
            App.changeStage(event,"LoginPage.fxml","Autohändler");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
