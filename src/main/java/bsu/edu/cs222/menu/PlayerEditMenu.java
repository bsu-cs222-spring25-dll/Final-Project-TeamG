package bsu.edu.cs222.menu;

import bsu.edu.cs222.combat.CharacterBase;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.FileInputStream;

import static bsu.edu.cs222.menu.MenuDesign.*;

public class PlayerEditMenu {
    CharacterBase player;
    CharacterBase enemy;
    Label playerLabel = createLabel("Player 1", 45);
    Label hpLabel = createLabel("HP: ", 25);
    Label attackLabel = createLabel("Attack: ", 25);
    Label defenseLabel = createLabel("Defense: ", 25);
    Button playerOneButton = createPlayerButton("Player One", 15);
    Button saveButton = createFunctionButton("Save changes");
    Button startBattleButton = createFunctionButton("Start Battle");
    Button mainMenuButton = createFunctionButton("Back to Main Menu");
    Button resetStatsButton = createFunctionButton("Reset Stats");
    TextField hpInput = createStatField();
    TextField attackInput = createStatField();
    TextField defenseInput = createStatField();
    GridPane statsGrid = new GridPane();
    VBox titleBox = new VBox(20, playerLabel);
    VBox playerSelection = new VBox(20, playerOneButton, resetStatsButton);
    HBox buttonBox = new HBox(20, saveButton, startBattleButton, mainMenuButton);
    Pane layout = new Pane();
    Scene scene = new Scene(layout, 800, 600);
    int selectedPlayer = 1;
    int winAmount;

    public void start(Stage stage, CharacterBase enemy, CharacterBase player, int winAmount) {
        this.enemy = enemy;
        this.player = player;
        this.winAmount = winAmount;

        stage.setTitle("Edit Player");
        layout.setStyle("-fx-background-color: #6badce;");
        titleBox.setLayoutX(290);
        titleBox.setLayoutY(30);
        //playerOneButton.setOnAction(_ -> switchPlayer(1));

        saveButton.setOnAction(_ -> setEditedStats(player));
        resetStatsButton.setOnAction(_ -> resetStats(player));

        startBattleButton.setOnAction(_ -> startBattle(stage));
        mainMenuButton.setOnAction(_ -> returnToMainMenu(stage));
        playerSelection.setLayoutX(40);
        playerSelection.setLayoutY(230);
        statsGrid.setVgap(25.0);
        statsGrid.setHgap(20.0);
        statsGrid.setLayoutX(250);
        statsGrid.setLayoutY(190);
        statsGrid.add(hpLabel, 0, 0);
        statsGrid.add(hpInput, 1, 0);
        statsGrid.add(attackLabel, 0, 1);
        statsGrid.add(attackInput, 1, 1);
        statsGrid.add(defenseLabel, 0, 2);
        statsGrid.add(defenseInput, 1, 2);
        buttonBox.setLayoutX(85);
        buttonBox.setLayoutY(510);
        layout.getChildren().addAll(titleBox, playerSelection, statsGrid, buttonBox);
        stage.setScene(scene);
        stage.show();
        layout.setBackground(loadBackground());
    }

    public void switchPlayer(int playerNumber){
        selectedPlayer = playerNumber;
        playerLabel.setText("Player " + playerNumber);
        System.out.println("Switched to Player " + playerNumber);
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
        try(FileInputStream input = new FileInputStream("src/Assets/CharacterEditBG.PNG")){
            Image image = new Image(input);
            BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            return new Background(backgroundImage);
        } catch(Exception e){
            System.err.println("Failed to load background image.");
            return new Background(new BackgroundFill(Color.BLACK, null, null));
        }
    }

    private void setEditedStats(CharacterBase playerOne){
        if(hpInput.getText().equals(null)){
            playerOne.setHp(25);
        }
        else{
            playerOne.setHp(Integer.parseInt(hpInput.getText()));
        }

        if(attackInput.getText().equals(null)){
            playerOne.setAttackPower(15);
        }
        else{
            playerOne.setAttackPower(Integer.parseInt(attackInput.getText()));
        }

        if(defenseInput.getText().equals(null)){
            playerOne.setDefensePower(8);
        }
        else{
            playerOne.setDefensePower(Integer.parseInt(defenseInput.getText()));
        }
        System.out.println("Saved changes to stats!\n");
    }

    public void startBattle(Stage stage){
        BattleMenu battleMenu = new BattleMenu();
        battleMenu.start(new Stage(), enemy, player, winAmount);
        stage.close();
    }

    private void resetStats(CharacterBase playerOne){
        playerOne.setHp(25);
        playerOne.setAttackPower(15);
        playerOne.setDefensePower(8);
        hpInput.clear();
        defenseInput.clear();
        attackInput.clear();
    }
}
//Resources: https://github.com/jjenkov/javafx-examples/tree/main