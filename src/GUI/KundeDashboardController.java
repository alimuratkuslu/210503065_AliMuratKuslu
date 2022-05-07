package GUI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class KundeDashboardController {
    @FXML
    public Button showkundenbtn;
    @FXML
    public Button showautos;
    @FXML
    public ImageView imageView;
    @FXML
    public Button redLoginbtn;
    
    @FXML
    void redAutos(ActionEvent event) {
        try {
            App.changeStage(event, "viewAuto.fxml", "Autos ansehen");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void redOnlyKunden(ActionEvent event) {
        try {
            App.changeStage(event, "viewOnlyKunde.fxml", "Kunden ansehen");
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
