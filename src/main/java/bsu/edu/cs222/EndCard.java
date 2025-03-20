package bsu.edu.cs222;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class EndCard {
    public void start(Stage stage) {
        stage.setTitle("End Card");

        BorderPane base = new BorderPane();
        base.setStyle("-fx-background-color: #6badce;");

        Scene scene = new Scene(base, 800, 600);
        stage.setScene(scene);
        stage.show();

        Button restartButton = new Button("Do you wish to restart?");

        Button backMenuButton = new Button("Return to main menu?");
        backMenuButton.setOnAction(e -> returnToMainMenu(stage));

        Button exitButton = new Button("X");
        exitButton.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        exitButton.setOnAction(e -> returnToMainMenu(stage));

    //Background background = new Background(backgroundimage);

        VBox menuOptions = new VBox(15.0, restartButton, backMenuButton, exitButton);
        menuOptions.setAlignment(Pos.CENTER);
    //menuOptions.setBackground(background);



        base.setCenter(menuOptions);
}
    private void restart(Stage stage){
        PlayerChoiceMenu playerChoiceMenu = new PlayerChoiceMenu();
        try {
            playerChoiceMenu.start(new Stage());
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    stage.close();


}
    private void returnToMainMenu(Stage stage){
        Menu menu = new Menu();
    try {
        menu.start(new Stage());
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    stage.close();
}
    private void exit(Stage stage){
        System.exit(0);
}
    }












