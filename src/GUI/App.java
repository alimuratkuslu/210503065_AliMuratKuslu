package GUI;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("LoginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Autohändler");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	public static void changeStage(ActionEvent event, String ressource, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(ressource));
        Scene scene = new Scene(fxmlLoader.load());
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

	public static void main(String[] args) {
		launch(args);
	}
}
