package bsu.edu.cs222;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Menu extends Application {
    public void start(Stage primaryStage) throws FileNotFoundException {
        primaryStage.setTitle("RPG Battle");

        FileInputStream input = new FileInputStream("src/Assets/MainMenuBG.PNG");//Added
        Image image = new Image(input);

        BackgroundImage backgroundimage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        Background background = new Background(backgroundimage);

        BorderPane base = new BorderPane();

        base.setStyle("-fx-background-color: #6badce;");

        Button fightMonsterButton = new Button("Fight Monster");

        fightMonsterButton.setOnAction(_ -> openDifficultyMenu(primaryStage));

        Button editPlayerButton = new Button("Edit Player");
        editPlayerButton.setOnAction(_ -> openPlayerEditMenu(primaryStage));

        Button exitButton = new Button("X");
        exitButton.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        exitButton.setOnAction(_ -> primaryStage.close());

        VBox menuBox = new VBox(15.0, fightMonsterButton, editPlayerButton);
        menuBox.setStyle("-fx-alignment: center;");
        menuBox.setBackground(background);
        StackPane exitPane = new StackPane(exitButton);
        exitPane.setStyle("-fx-alignment: top-right;");

        base.setTop(exitPane);
        base.setCenter(menuBox);

        Scene scene = new Scene(base, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openDifficultyMenu(Stage primaryStage){
        System.out.println("Opening Difficulty menu...");
        DifficultyMenu difficultyMenu = new DifficultyMenu();
        difficultyMenu.start(new Stage());
        primaryStage.close();
    }

    private void openPlayerEditMenu(Stage primaryStage){
        System.out.println("Opening Player edit menu...");
        PlayerEditMenu playerEditMenu = new PlayerEditMenu();
        playerEditMenu.start(new Stage());
        primaryStage.close();
    }

    public static void main(String[] args){
        launch(args);
    }
}