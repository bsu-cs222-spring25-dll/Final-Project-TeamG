package bsu.edu.cs222.menu;

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
import static bsu.edu.cs222.menu.MenuDesign.*;

public class Menu extends Application {
    int winAmount;
    Button fightMonsterButton = createfightMonsterButton();
    Button exitButton = createExitButton("X");

    public void start(Stage primaryStage) {
        primaryStage.setTitle("RPG Battle");
        BorderPane base = new BorderPane();
        base.setStyle("-fx-background-color: #6badce;");
        setupButtons(primaryStage);
        VBox menuBox = createMenuVBox();
        StackPane exitPane = new StackPane(exitButton);
        exitPane.setStyle("-fx-alignment: top-right;");
        base.setTop(exitPane);
        base.setCenter(menuBox);
        Scene scene = new Scene(base, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createfightMonsterButton(){
        Button fightMonsterButton = new Button("Start");
        fightMonsterButton.setPrefSize(150, 55);
        fightMonsterButton.setFont(Font.font("Century", 20.0));
        return fightMonsterButton;
    }

    private void setupButtons(Stage primaryStage) {
        fightMonsterButton.setOnAction(_ -> openDifficultyMenu(primaryStage));
        exitButton.setOnAction(_ -> primaryStage.close());
    }

    private VBox createMenuVBox(){
        VBox menuBox = new VBox(20.0, fightMonsterButton);
        menuBox.setAlignment(Pos.BASELINE_CENTER);
        menuBox.setPadding(new Insets(320, 0, 0, 0));
        menuBox.setBackground(loadBackground());
        return menuBox;
    }

    private void openDifficultyMenu(Stage primaryStage){
        System.out.println("Opening Difficulty menu...");
        DifficultyMenu difficultyMenu = new DifficultyMenu();
        difficultyMenu.start(new Stage(), winAmount);
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