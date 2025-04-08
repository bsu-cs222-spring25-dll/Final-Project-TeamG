package bsu.edu.cs222;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.FileInputStream;

import static bsu.edu.cs222.MenuDesign.*;

public class Menu extends Application {
    public void start(Stage primaryStage) {
        primaryStage.setTitle("RPG Battle");
        BorderPane base = new BorderPane();
        base.setStyle("-fx-background-color: #6badce;");
        Button fightMonsterButton = new Button("Fight Enemy");
        fightMonsterButton.setPrefSize(150, 55);
        fightMonsterButton.setFont(Font.font("Century", 20.0));
        fightMonsterButton.setOnAction(_ -> openDifficultyMenu(primaryStage));
        Button editPlayerButton = new Button("Edit Player");
        editPlayerButton.setPrefSize(150,55);
        editPlayerButton.setFont(Font.font("Century", 20.0));
        editPlayerButton.setOnAction(_ -> openPlayerEditMenu(primaryStage));
        Button exitButton = createExitButton("X");
        exitButton.setOnAction(_ -> primaryStage.close());
        VBox menuBox = new VBox(20.0, fightMonsterButton, editPlayerButton);
        menuBox.setAlignment(Pos.BASELINE_CENTER);
        menuBox.setPadding(new Insets(320, 0, 0, 0));
        menuBox.setBackground(loadBackground());
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

    private Background loadBackground(){
        try(FileInputStream input = new FileInputStream("src/Assets/MainMenuBG.PNG")){
            Image image = new Image(input);
            BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            return new Background(backgroundImage);
        } catch(Exception e){
            System.err.println("Failed to load background image.");
            return new Background(new BackgroundFill(javafx.scene.paint.Color.BLACK, null, null));
        }
    }

    public static void main(String[] args){
        launch(args);
    }
}