package bsu.edu.cs222;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

import bsu.edu.cs222.Menu;

public class BattleMenu {
    public void start(Stage stage) {
        stage.setTitle("Battle!");

        BorderPane base = new BorderPane();
        base.setStyle("-fx-background-color: #6badce;");

        Button editPlayerButton = new Button("Return to Menu");
        editPlayerButton.setOnAction(e -> openEndCard((stage)));

        VBox menuOptions = new VBox(15.0, editPlayerButton);
        menuOptions.setStyle("-fx-alignment: center;");

        Scene scene = new Scene(base, 800, 600);
        stage.setScene(scene);
        stage.show();

        base.setCenter(menuOptions);
    }

    private void openEndCard(Stage stage){
        EndCard endCard = new EndCard();
        try {
            endCard.start(new Stage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        stage.close();
    }
}