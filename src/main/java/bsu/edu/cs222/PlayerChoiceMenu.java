package bsu.edu.cs222;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PlayerChoiceMenu {
    String selectedDifficulty = " ";
    String selectedPlayer = " ";

    public void start(Stage stage) {
        stage.setTitle("Player Choice");

        Button playerOneButton = new Button("Player One");
        playerOneButton.setOnAction(e -> selectPlayer("Player One"));
        Button playerTwoButton = new Button("Player Two");
        playerTwoButton.setOnAction(e -> selectPlayer("Player Two"));

        Button backButton = new Button("Back to Difficulty");
        backButton.setOnAction(e -> returnToDifficultyMenu(stage));
        Button startBattleButton = new Button("Start Battle");
        startBattleButton.setOnAction(e -> startBattle(stage));

        FileInputStream input = null;
        try {
            input = new FileInputStream("src/Assets/CharacterSelectMenuBG.PNG");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Image image = new Image(input);

        BackgroundImage backgroundimage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        Background background = new Background(backgroundimage);

        VBox menuOptions = new VBox(15, playerOneButton, playerTwoButton, startBattleButton, backButton);
        menuOptions.setAlignment(Pos.CENTER);
        menuOptions.setBackground(background);

        BorderPane base = new BorderPane();
        base.setStyle("-fx-background-color: #6badce;");
        base.setCenter(menuOptions);

        Scene scene = new Scene(base, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    private void selectPlayer(String player){
        selectedPlayer = player;
        System.out.println("Selected player: " + player);
    }

    private void returnToDifficultyMenu(Stage stage){
        DifficultyMenu difficultyMenu = new DifficultyMenu();
        difficultyMenu.start(new Stage());
        stage.close();
    }

    private void startBattle(Stage stage){
        if(selectedPlayer.isEmpty()){
            System.out.println("Please select a player before battle...");
            return;
        }
        System.out.println("Starting battle with " + selectedPlayer + " on " + selectedDifficulty + " difficulty.");
        BattleMenu battleMenu = new BattleMenu();
        battleMenu.start(new Stage());
        stage.close();
    }
}