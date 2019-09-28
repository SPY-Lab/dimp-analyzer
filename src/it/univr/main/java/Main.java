

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import gui.MainController;


public class Main extends Application {

    private final static String MAIN_FXML_PATH = "gui/main.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(MAIN_FXML_PATH));
            loader.setController(new MainController(primaryStage));
            Parent root = loader.load();

            Scene mainScene = new Scene(root);
            primaryStage.setScene(mainScene);
            primaryStage.setTitle("Mudyn");
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
