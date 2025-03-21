package bsu.edu.cs222;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.FileInputStream;

public class EndCard {
    public void start(Stage stage) {
        stage.setTitle("End Card");

        BorderPane base = new BorderPane();
        base.setStyle("-fx-background-color: #6badce;");

        Scene scene = new Scene(base, 800, 600);
        stage.setScene(scene);
        stage.show();

        Button restartButton = new Button("Do you wish to restart?");
        restartButton.setOnAction(_ -> restart(stage));

        Button backMenuButton = new Button("Return to main menu?");
        backMenuButton.setOnAction(_ -> returnToMainMenu(stage));

        Button exitButton = new Button("X");
        exitButton.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        exitButton.setOnAction(_ -> exit());

        VBox menuOptions = new VBox(15.0, restartButton, backMenuButton, exitButton);
        menuOptions.setAlignment(Pos.CENTER);
        menuOptions.setBackground(loadBackground());

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

    private void exit(){
        System.exit(0);
    }

    private Background loadBackground(){
        try(FileInputStream input = new FileInputStream("src/Assets/EndCardBG.PNG")){
            Image image = new Image(input);
            BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            return new Background(backgroundImage);
        } catch(Exception e){
            System.err.println("Failed to load background image.");
            return new Background(new BackgroundFill(javafx.scene.paint.Color.LIGHTBLUE, null, null));
        }
    }
}