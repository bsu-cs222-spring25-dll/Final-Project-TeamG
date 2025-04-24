package bsu.edu.cs222.menu;

import bsu.edu.cs222.combat.BattleLogic;
import bsu.edu.cs222.combat.BattleWinCalculator;
import bsu.edu.cs222.combat.CharacterBase;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.FileInputStream;
import static bsu.edu.cs222.menu.MenuDesign.*;

public class BattleMenu {
    BattleLogic battleLogic = new BattleLogic();
    BattleWinCalculator battleWinCalculator = new BattleWinCalculator();
    CharacterBase enemy;
    CharacterBase player;
    Label playerHPLabel = createLabel(" ", 20);
    Label playerDefenseLabel = createLabel(" ", 20);
    Label enemyHPLabel = createLabel(" ", 20);
    Label actionTextLabel = createLabel(" ", 15);
    Button endCardButton = new Button("Go to end card menu");
    Button attackButton = createPlayerButton("Attack", 15);
    Button defendButton = createPlayerButton("Defense", 15);
    VBox menuOptions = new VBox(15.0, endCardButton);
    VBox actionOptions = new VBox(15.0, attackButton, defendButton);
    VBox playerStatsDisplay = new VBox(20.0, playerHPLabel, playerDefenseLabel);
    VBox enemyStatsDisplay = new VBox(5.0, enemyHPLabel);
    Pane layout = new Pane();
    Scene scene = new Scene(layout, 800, 600);
    String backgroundName;
    int winAmount = battleWinCalculator.getBattleWinNumber();

    public void start(Stage stage, CharacterBase enemy, CharacterBase player, int winAmount) {
        this.winAmount = winAmount;
        this.enemy = enemy;
        this.player = player;
        stage.setTitle("Battle!");
        layout.setStyle("-fx-background-color: #6badce;");
        endCardButton.setOnAction(_ -> openEndCard((stage)));
        attackButton.setOnAction(_ -> attackButtonAction(stage));
        defendButton.setOnAction(_ -> defendButtonAction(stage));
        endCardButton.setFont(new Font("Century", 8.0));
        endCardButton.setPrefSize(90.0, 30.0);
        menuOptions.setStyle("-fx-alignment: bottom-right;");
        menuOptions.setLayoutX(650.0);
        menuOptions.setLayoutY(550.0);
        actionOptions.setLayoutX(50.0);
        actionOptions.setLayoutY(470.0);
        playerStatsDisplay.setLayoutX(349.0);
        playerStatsDisplay.setLayoutY(485.0);
        enemyStatsDisplay.setLayoutX(550.0);
        enemyStatsDisplay.setLayoutY(240.0);

        playerHPLabel.setText("HP: " + player.getHp());
        enemyHPLabel.setText(enemy.getName() + "'s HP: " + enemy.getHp());
        playerDefenseLabel.setText("Defense: " + player.defend());
        actionTextLabel.setText("The battle begins!");

        getBackgroundName();

        stage.setScene(scene);
        stage.show();
        layout.getChildren().addAll(menuOptions, actionOptions, playerStatsDisplay, enemyStatsDisplay);
        layout.setBackground(loadBackground());
    }

    private void openEndCard(Stage stage){
        //battleWinCalculator.increaseWinCount();
        //winAmount = battleWinCalculator.getBattleWinNumber();
        //winAmount++;
        System.out.printf("Number of wins: %d", winAmount);

        EndCard endCard = new EndCard();
        try {
            endCard.start(new Stage(), enemy, winAmount);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        stage.close();
    }

    private String getBackgroundName(){
        if(enemy.getName().equals("Bunbun")){
            backgroundName = "EasyEnemyBG.PNG";

        }
        else if(enemy.getName().equals("Gobbo")){
            backgroundName = "MediumEnemyBG.PNG";
        }
        else if(enemy.getName().equals("Howard")){
            backgroundName = "HardEnemyBG.PNG";
        }
        else{
            backgroundName = "BattleMenuSketchBG.jpg";
        }
        return backgroundName;
    }

    private Background loadBackground(){
        try(FileInputStream input = new FileInputStream("src/Assets/" + backgroundName)){
            Image image = new Image(input);
            BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            return new Background(backgroundImage);
        } catch(Exception e){
            System.err.println("Failed to load background image.");
            return new Background(new BackgroundFill(Color.BLACK, null, null));
        }
    }

    public void attackButtonAction(Stage stage){
        battleLogic.attackBattleTurnOrder(player, enemy);
        actionTextLabel.setText("You did " + battleLogic.getDamage() + "damage!\n" + enemy.getName() + " did " + (enemy.attack() - player.defend() + " damage to you!"));
        playerHPLabel.setText("HP: " + player.getHp());
        enemyHPLabel.setText(enemy.getName() + "'s HP: " + enemy.getHp());
        if(enemy.getHp() == 0){
            winAmount++;
            openEndCard((stage));
        }
        else if(player.getHp() == 0){
            openEndCard((stage));
        }
        else{

        }
    }

    public void defendButtonAction(Stage stage){
        battleLogic.defendBattleTurnOrder(player, enemy);
        actionTextLabel.setText("You defended! " + enemy.getName() + " did" + battleLogic.getDamage() + "to you!");
        playerHPLabel.setText("HP: " + player.getHp());
        if(enemy.getHp() == 0){
            openEndCard((stage));

        }
        else if(player.getHp() == 0){
            openEndCard((stage));

        }
        else{

        }
    }
}