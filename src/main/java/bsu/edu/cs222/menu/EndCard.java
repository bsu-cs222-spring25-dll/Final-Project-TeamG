package bsu.edu.cs222.menu;

import bsu.edu.cs222.combat.CharacterBase;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.FileInputStream;
import static bsu.edu.cs222.menu.MenuDesign.*;

public class EndCard {
    int winAmount;
    Text winAmountDisplay = new Text();
    CharacterBase enemy;
    Pane layout = new Pane();
    Scene scene = new Scene(layout, 800, 600);
    Button restartButton = createPlayerButton("Do you wish to restart?", 11);
    Button backMenuButton = createPlayerButton("Return to main menu?", 11);
    Button exitButton = createExitButton("X");
    VBox menuOptions = new VBox(20.0, restartButton, backMenuButton);
    HBox exitBox = new HBox(exitButton);
    String backgroundName;

    public void start(Stage stage, CharacterBase enemy, int winAmount) {
        this.winAmount = winAmount;
        this.enemy = enemy;
        stage.setTitle("End Card");
        layout.setStyle("-fx-background-color: #6badce;");
        winAmountDisplay.setText("Wins: " + winAmount);
        winAmountDisplay.setX(350.0);
        winAmountDisplay.setY(480.0);
        winAmountDisplay.setFont(Font.font("Century", FontWeight.BOLD, 24));
        winAmountDisplay.setFill(Color.WHITE);
        restartButton.setOnAction(_ -> restart(stage));
        backMenuButton.setOnAction(_ -> returnToMainMenu(stage));
        exitButton.setOnAction(_ -> stage.close());
        menuOptions.setLayoutX(320.0);
        menuOptions.setLayoutY(300.0);
        exitBox.setPrefWidth(800);
        exitBox.setAlignment(Pos.TOP_RIGHT);
        exitBox.setLayoutY(10);
        exitBox.setPadding(new Insets(0, 5, 0, 0));
        layout.getChildren().addAll(menuOptions, exitBox, winAmountDisplay);

        getBackgroundName();
        stage.setScene(scene);
        stage.show();
        layout.setBackground(loadBackground());
    }

    private void restart(Stage stage){
        PlayerChoiceMenu playerChoiceMenu = new PlayerChoiceMenu();
        try {
            enemy.setHp(enemy.getMaxHp());
            playerChoiceMenu.start(new Stage(), enemy, winAmount);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    stage.close();
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
        try(FileInputStream input = new FileInputStream("src/Assets/" + backgroundName)){
            Image image = new Image(input);
            BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            return new Background(backgroundImage);
        } catch(Exception e){
            System.err.println("Failed to load background image.");
            return new Background(new BackgroundFill(Color.BLACK, null, null));
        }
    }

    private void getBackgroundName(){
        if(enemy.getHp() == 0){
            backgroundName = "EndCardBG.PNG";
        }
        else{
            backgroundName = "defeatBG.jpg";
        }
    }
}