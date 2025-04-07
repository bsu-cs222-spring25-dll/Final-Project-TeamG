package bsu.edu.cs222;

import bsu.edu.cs222.combat.CharacterBase;
import bsu.edu.cs222.combat.PlayerSelection;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.FileInputStream;

public class PlayerChoiceMenu{
    DifficultyMenu difficultyMenu = new DifficultyMenu();
    String selectedDifficulty = difficultyMenu.getSelectedDifficulty();
    PlayerSelection playerSelection = new PlayerSelection();
    String selectedPlayer;
    CharacterBase enemy;
    CharacterBase chosenPlayer;
    public void start(Stage stage, CharacterBase enemy) {
        this.enemy = enemy;
        stage.setTitle("Player Choice");
        Button playerOneButton = new Button("Player One");
        playerOneButton.setOnAction(_ -> selectPlayer("Player One"));
        Button playerTwoButton = new Button("Player Two");
        playerTwoButton.setOnAction(_ -> selectPlayer("Player Two"));
        Button backButton = new Button("Back to Difficulty");
        backButton.setOnAction(_ -> returnToDifficultyMenu(stage));
        Button startBattleButton = new Button("Start Battle");
        startBattleButton.setOnAction(_ -> startBattle(stage));
        VBox menuOptions = new VBox(15, playerOneButton, playerTwoButton, startBattleButton, backButton);
        menuOptions.setAlignment(Pos.CENTER);
        menuOptions.setBackground(loadBackground());
        BorderPane base = new BorderPane();
        base.setStyle("-fx-background-color: #6badce;");
        base.setCenter(menuOptions);
        Scene scene = new Scene(base, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    protected void selectPlayer(String player){
        //this.selectedPlayer = player;
        chosenPlayer = playerSelection.getSelectedPlayer(player);
        System.out.println("Selected player: " + chosenPlayer.getName());
    }

    public String getSelectedPlayer(){
        return selectedPlayer;
    }

    private void returnToDifficultyMenu(Stage stage){
        DifficultyMenu difficultyMenu = new DifficultyMenu();
        difficultyMenu.start(new Stage());
        stage.close();
    }

    private void startBattle(Stage stage){
        System.out.println("Starting battle with " + chosenPlayer.getName() + " on " + enemy.getName() + " difficulty.");
        BattleMenu battleMenu = new BattleMenu();
        battleMenu.start(new Stage(), enemy, chosenPlayer);
        stage.close();
    }

    private Background loadBackground(){
        try(FileInputStream input = new FileInputStream("src/Assets/CharacterSelectMenuBG.PNG")){
            Image image = new Image(input);
            BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            return new Background(backgroundImage);
        } catch(Exception e){
            System.err.println("Failed to load background image.");
            return new Background(new BackgroundFill(javafx.scene.paint.Color.LIGHTBLUE, null, null));
        }
    }
}