package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class addAutoController implements Initializable{
	
	public Button absagenbtn;
    @FXML
    public Button addautorbtn;
    @FXML
    public TextField idaddautotxt;
    @FXML
    public TextField nameaddautotxt;
    @FXML
    public TextField preisaddauto;
    @FXML
    public TextField modeladdautotxt;
    @FXML
    public TextField fahrzeugtypaddautotxt;
    @FXML
    public TextField jahraddautotxt;
    @FXML
    public TextField treibstoffrtaddautotxt;
    @FXML
    public TextField getriebetypaddautotxt;
    @FXML
    public TextField motorladdautotxt;
    @FXML
    public TextField co2addautotxt;
    @FXML
    public TextField beschaddautotxt;
    @FXML
    public TextField systemladdautotxt;
    @FXML
    public ImageView imageView;


    @FXML
    void addAuto() throws SQLException {
        int id = 0;
        try{
            id = Integer.parseInt(idaddautotxt.getText());
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ID nicht gültig!");
            return;
        }
        String auto_id = idaddautotxt.getText();
        String name = nameaddautotxt.getText();
        String preis = preisaddauto.getText();
        String model = modeladdautotxt.getText();
        String fahrzeugTyp = fahrzeugtypaddautotxt.getText();
        String jahr = jahraddautotxt.getText();
        String treibstoffArt = treibstoffrtaddautotxt.getText();
        String getriebeTyp = getriebetypaddautotxt.getText();
        String motorLeistung = motorladdautotxt.getText();
        String co2Emission = co2addautotxt.getText();
        String beschleunigung = beschaddautotxt.getText();
        String systemLeistung = systemladdautotxt.getText();

        if (auto_id.equals("") || name.equals("")) {
        	new Alert(Alert.AlertType.ERROR, "Einige Felder waren leer!").showAndWait();
        } else {
        	Database connectNow = new Database();
            int result = connectNow.saveAuto(auto_id, name, preis, model, fahrzeugTyp, jahr, treibstoffArt, getriebeTyp, motorLeistung, co2Emission, beschleunigung, systemLeistung);
            if (result == -1) {
            	new Alert(Alert.AlertType.ERROR, "Auto existiert!").showAndWait();
            }
            if (result == 0) {
            	new Alert(Alert.AlertType.CONFIRMATION, "Auto hinzugefügt!").showAndWait();
            	idaddautotxt.setText("");
            	nameaddautotxt.setText("");
            	preisaddauto.setText("");
            	modeladdautotxt.setText("");
            	fahrzeugtypaddautotxt.setText("");
            	jahraddautotxt.setText("");
            	treibstoffrtaddautotxt.setText("");
            	getriebetypaddautotxt.setText("");
            	motorladdautotxt.setText("");
            	co2addautotxt.setText("");
            	beschaddautotxt.setText("");
            	systemladdautotxt.setText("");
            }
        }
    }

    @FXML
    void redDashboard(ActionEvent event) {
        try {
            App.changeStage(event, "Dashboard.fxml", "Dashboard");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
