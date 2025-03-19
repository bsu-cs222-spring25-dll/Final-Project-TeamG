package bsu.edu.cs222;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Menu extends Application {
    public void start(Stage primaryStage){
        primaryStage.setTitle("RPG Battle");

        BorderPane base = new BorderPane();
        base.setStyle("-fx-background-color: #6badce;");
        //Image backgroundImage = new Image("");
        //ImageView backgroundView = new ImageView();
        //backgroundView.setFitWidth();
        //backgroundView.setFitHeight();

        Label title = new Label("RPG Battle");
        title.setFont(new Font("Times New Roman", 60));

        Button fightMonsterButton = new Button("Fight Monster");
        fightMonsterButton.setOnAction(e -> openDifficultyMenu(primaryStage));

        Button editPlayerButton = new Button("Edit Player");
        editPlayerButton.setOnAction(e -> openPlayerEditMenu(primaryStage));

        Button exitButton = new Button("X");
        exitButton.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        exitButton.setOnAction(e -> primaryStage.close());

        VBox menuBox = new VBox(15.0, title, fightMonsterButton, editPlayerButton);
        menuBox.setStyle("-fx-alignment: center;");

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