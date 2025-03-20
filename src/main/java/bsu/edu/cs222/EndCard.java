package bsu.edu.cs222;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EndCard {
    public void start(Stage stage){
        stage.setTitle("End Card");

        BorderPane base = new BorderPane();
        base.setStyle("-fx-background-color: #6badce;");

        Scene scene = new Scene(base, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
}