package bsu.edu.cs222;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
        backMenuButton.setOnAction(_ -> returnToMainMenu(stage));

        Button exitButton = new Button("X");
        exitButton.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        exitButton.setOnAction(_ -> returnToMainMenu(stage));

        FileInputStream input;
        try {
            input = new FileInputStream("src/Assets/EndCardBG.PNG");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Image image = new Image(input);

        BackgroundImage backgroundimage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        Background background = new Background(backgroundimage);

        VBox menuOptions = new VBox(15.0, restartButton, backMenuButton, exitButton);
        menuOptions.setAlignment(Pos.CENTER);
        menuOptions.setBackground(background);

        base.setCenter(menuOptions);
}
    //Restart function will be fleshed out during development of the battle functions
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