package bsu.edu.cs222;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PlayerChoiceMenu {
    String selectedDifficulty = " ";
    String selectedEnemy = " ";

    public void start(Stage stage) {
        stage.setTitle("Player Choice");

        Label title = new Label("Choose Enemy");
        title.setFont(new Font("Times New Roman", 60));
        Label difficultyLabel = new Label("Difficulty: " + selectedDifficulty);
        difficultyLabel.setFont(new Font("Times New Roman", 40));

        Button enemyOneButton = new Button("Enemy One");
        enemyOneButton.setOnAction(e -> selectEnemy("Enemy One"));
        Button enemyTwoButton = new Button("Enemy Two");
        enemyTwoButton.setOnAction(e -> selectEnemy("Enemy Two"));
        Button backButton = new Button("Back to Difficulty");
        backButton.setOnAction(e -> returnToDifficultyMenu(stage));
        Button startBattleButton = new Button("Start Battle");
        startBattleButton.setOnAction(e -> startBattle(stage));

        VBox menuOptions = new VBox(15, title, difficultyLabel, enemyOneButton, enemyTwoButton, startBattleButton, backButton);
        menuOptions.setAlignment(Pos.CENTER);

        BorderPane base = new BorderPane();
        base.setStyle("-fx-background-color: #6badce;");
        base.setCenter(menuOptions);

        Scene scene = new Scene(base, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    private void selectEnemy(String enemy){
        selectedEnemy = enemy;
        System.out.println("Selected Enemy: " + enemy);
    }

    private void returnToDifficultyMenu(Stage stage){
        DifficultyMenu difficultyMenu = new DifficultyMenu();
        difficultyMenu.start(new Stage());
        stage.close();
    }

    private void startBattle(Stage stage){
        if(selectedEnemy.isEmpty()){
            System.out.println("Please select and enemy before battle...");
            return;
        }
        System.out.println("Starting battle with " + selectedEnemy + " on " + selectedDifficulty + " difficulty.");
        BattleMenu battleMenu = new BattleMenu();
        battleMenu.start(new Stage());
        stage.close();
    }
}