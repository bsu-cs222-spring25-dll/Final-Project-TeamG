package bsu.edu.cs222.menu;

import bsu.edu.cs222.combat.BattleLogic;
import bsu.edu.cs222.combat.CharacterBase;
import bsu.edu.cs222.combat.PlayerSelection;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.FileInputStream;

import static bsu.edu.cs222.menu.MenuDesign.*;

public class PlayerChoiceMenu{
    DifficultyMenu difficultyMenu = new DifficultyMenu();
    String selectedDifficulty = difficultyMenu.getSelectedDifficulty();
    PlayerSelection playerSelection = new PlayerSelection();

    BattleLogic battleLogic = new BattleLogic();
    int winAmount;

    String selectedPlayer;
    CharacterBase enemy;
    CharacterBase chosenPlayer;
    Pane layout = new Pane();
    Scene scene = new Scene(layout, 800, 600);

    public void start(Stage stage, CharacterBase enemy, int winAmount) {
        this.winAmount = winAmount;
        this.enemy = enemy;
        stage.setTitle("Player Choice");
        layout.setStyle("-fx-background-color: #6badce;");
        Button playerOneButton = createPlayerButton("Player One", 15);
        playerOneButton.setOnAction(_ -> selectPlayer("Player One"));

        Button playerTwoButton = createPlayerButton("Player Two", 15);
        playerTwoButton.setOnAction(_ -> selectPlayer("Player Two"));

        Button backButton = createPlayerButton("Back to Difficulty", 15);
        backButton.setOnAction(_ -> returnToDifficultyMenu(stage));
        Button startBattleButton = createPlayerButton("Start Battle", 15);
        startBattleButton.setOnAction(_ -> startBattle(stage));
        VBox menuOptions = new VBox(20, playerOneButton, playerTwoButton, startBattleButton, backButton);
        menuOptions.setLayoutX(300.0);
        menuOptions.setLayoutY(250.0);
        layout.getChildren().addAll(menuOptions);
        stage.setScene(scene);
        stage.show();
        layout.setBackground(loadBackground());
    }

    public void selectPlayer(String player){
        this.selectedPlayer = player;
        chosenPlayer = playerSelection.getSelectedPlayer(player);
        System.out.println("Selected player: " + chosenPlayer.getName());
    }

    //public String getSelectedPlayer(){
        //return selectedPlayer;
    //}

    private void returnToDifficultyMenu(Stage stage){
        DifficultyMenu difficultyMenu = new DifficultyMenu();
        difficultyMenu.start(new Stage(), winAmount);
        stage.close();
    }

    private void startBattle(Stage stage){
        System.out.println("Starting battle with " + chosenPlayer.getName() + " on " + enemy.getName() + " difficulty: " + selectedDifficulty);
        BattleMenu battleMenu = new BattleMenu();
        PlayerEditMenu playerEditMenu = new PlayerEditMenu();
        if(chosenPlayer.getName().equals("Player One")){
            playerEditMenu.start(new Stage(),enemy, chosenPlayer, winAmount);
            stage.close();

        }
        else if(chosenPlayer.getName().equals("Player Two")){
            battleMenu.start(new Stage(), enemy, chosenPlayer, winAmount);
            stage.close();

        }
    }

    private Background loadBackground(){
        try(FileInputStream input = new FileInputStream("src/Assets/CharacterSelectMenuBG.PNG")){
            Image image = new Image(input);
            BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            return new Background(backgroundImage);
        } catch(Exception e){
            System.err.println("Failed to load background image.");
            return new Background(new BackgroundFill(Color.BLACK, null, null));
        }
    }
}