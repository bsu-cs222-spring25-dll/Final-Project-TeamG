package bsu.edu.cs222;

import bsu.edu.cs222.combat.CharacterBase;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.FileInputStream;
import bsu.edu.cs222.combat.DifficultySelection;

import static bsu.edu.cs222.MenuDesign.*;

public class DifficultyMenu {
    private final DifficultySelection difficultySelection = new DifficultySelection();
    private String selectedDifficulty;

    public void start(Stage stage) {
        stage.setTitle("Difficulty menu");
        Pane layout = new Pane();
        layout.setStyle("-fx-background-color: #6badce;");
        Scene scene = new Scene(layout,800, 600);
        stage.setScene(scene);
        stage.show();
        Button easyButton = createPlayerButton("Easy", 15);
        easyButton.setOnAction(_ -> selectDifficulty("Easy", stage));
        Button mediumButton = createPlayerButton("Medium", 15);
        mediumButton.setOnAction(_ -> selectDifficulty("Medium", stage));
        Button hardButton = createPlayerButton("Hard", 15);
        hardButton.setOnAction(_ -> selectDifficulty("Hard", stage));
        Button mainMenuButton = createPlayerButton("Back to Main Menu", 12);
        mainMenuButton.setOnAction(_ -> returnToMainMenu(stage));
        VBox menuOptions = new VBox(20, easyButton, mediumButton, hardButton, mainMenuButton);
        menuOptions.setLayoutY(200.0);
        menuOptions.setLayoutX(300.0);
        layout.getChildren().addAll(menuOptions);
        layout.setBackground(loadBackground());
    }

    public void selectDifficulty(String difficulty, Stage stage){
        this.selectedDifficulty = difficulty;
        System.out.println("Difficulty selected: " + difficulty);
        CharacterBase chosenEnemy = difficultySelection.getSelectedEnemy(difficulty);
        PlayerChoiceMenu playerChoiceMenu = new PlayerChoiceMenu();
        playerChoiceMenu.start(new Stage(), chosenEnemy);
        stage.close();
    }

    public void selectDifficulty(String difficulty){
        this.selectedDifficulty = difficulty;
    }

    public String getSelectedDifficulty(){
        return selectedDifficulty;
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

    private Background loadBackground(){
        try(FileInputStream input = new FileInputStream("src/Assets/DifficultyMenuBG.PNG")){
            Image image = new Image(input);
            BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            return new Background(backgroundImage);
        } catch(Exception e){
            System.err.println("Failed to load background image.");
            return new Background(new BackgroundFill(Color.BLACK, null, null));
        }
    }
}
//Resources: https://github.com/jjenkov/javafx-examples/tree/main