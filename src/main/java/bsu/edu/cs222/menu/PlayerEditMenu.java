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
    GridPane statsGrid = createStatsGrid();
    VBox titleBox = createPlayerTitleVBox();
    VBox playerSelection = createPlayerSelectionVBox();
    HBox buttonBox = createButtonBoxHBox();
    Pane layout = new Pane();
    Scene scene = new Scene(layout, 800, 600);
    int winAmount;

    public void start(Stage stage, CharacterBase enemy, CharacterBase player, int winAmount) {
        this.enemy = enemy;
        this.player = player;
        this.winAmount = winAmount;
        stage.setTitle("Edit Player");
        layout.setStyle("-fx-background-color: #6badce;");
        setupButtons(stage);
        layout.getChildren().addAll(titleBox, playerSelection, statsGrid, buttonBox);
        stage.setScene(scene);
        stage.show();
        layout.setBackground(loadBackground());
    }

    private void setupButtons(Stage stage) {
        saveButton.setOnAction(_ -> setEditedStats(player));
        resetStatsButton.setOnAction(_ -> resetStats(player));
        startBattleButton.setOnAction(_ -> startBattle(stage));
        mainMenuButton.setOnAction(_ -> returnToMainMenu(stage));
    }

    private VBox createPlayerTitleVBox(){
        VBox titleBox = new VBox(20, playerLabel);
        titleBox.setLayoutX(290);
        titleBox.setLayoutY(30);
        return titleBox;
    }

    private VBox createPlayerSelectionVBox(){
        VBox playerSelection = new VBox(20, playerOneButton, resetStatsButton);
        playerSelection.setLayoutX(40);
        playerSelection.setLayoutY(230);
        return playerSelection;
    }

    private HBox createButtonBoxHBox(){
        HBox buttonBox = new HBox(20, saveButton, startBattleButton, mainMenuButton);
        buttonBox.setLayoutX(85);
        buttonBox.setLayoutY(510);
        return buttonBox;
    }

    private GridPane createStatsGrid(){
        GridPane statsGrid = new GridPane();
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
        return statsGrid;
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
        String hpText = hpInput.getText();
        String attackText = attackInput.getText();
        String defenseText = defenseInput.getText();
        playerOne.setHp(hpText.isEmpty() ? 25 : Integer.parseInt(hpText));
        playerOne.setAttackPower(attackText.isEmpty() ? 15 : Integer.parseInt(attackText));
        playerOne.setDefensePower(defenseText.isEmpty() ? 8 : Integer.parseInt(defenseText));
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