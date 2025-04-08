package bsu.edu.cs222;

import bsu.edu.cs222.combat.CharacterBase;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.FileInputStream;
import bsu.edu.cs222.combat.DifficultySelection;

public class DifficultyMenu {
    private final DifficultySelection difficultySelection = new DifficultySelection();
    private String selectedDifficulty;

    public void start(Stage stage) {
        stage.setTitle("Difficulty menu");
        BorderPane base = new BorderPane();
        base.setStyle("-fx-background-color: #6badce;");
        Scene scene = new Scene(base,800, 600);
        stage.setScene(scene);
        stage.show();
        Button easyButton = new Button("Easy");
        easyButton.setOnAction(_ -> selectDifficulty("Easy", stage));
        Button mediumButton = new Button("Medium");
        mediumButton.setOnAction(_ -> selectDifficulty("Medium", stage));
        Button hardButton = new Button("Hard");
        hardButton.setOnAction(_ -> selectDifficulty("Hard", stage));
        Button mainMenuButton = new Button("Back to Main Menu");
        mainMenuButton.setOnAction(_ -> returnToMainMenu(stage));
        VBox menuOptions = new VBox(15, easyButton, mediumButton, hardButton, mainMenuButton);
        menuOptions.setAlignment(Pos.CENTER);
        base.setCenter(menuOptions);
        base.setBackground(loadBackground());
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
            return new Background(new BackgroundFill(javafx.scene.paint.Color.LIGHTBLUE, null, null));
        }
    }
}
//Resources: https://github.com/jjenkov/javafx-examples/tree/main