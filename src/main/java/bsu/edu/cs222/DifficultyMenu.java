package bsu.edu.cs222;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DifficultyMenu {

    public void start(Stage stage) {
        stage.setTitle("Difficulty menu");
        Label title = new Label("Difficulty Menu");
        title.setFont(new Font("Times New Roman", 60));

        BorderPane base = new BorderPane();
        base.setStyle("-fx-background-color: #6badce;");

        Scene scene = new Scene(base,800, 600);
        stage.setScene(scene);
        stage.show();

        Button easyButton = new Button("Easy");
        easyButton.setOnAction(e -> selectDifficulty("Easy", stage));
        Button mediumButton = new Button("Medium");
        mediumButton.setOnAction(e -> selectDifficulty("Medium", stage));
        Button hardButton = new Button("Hard");
        hardButton.setOnAction(e -> selectDifficulty("Hard", stage));
        Button mainMenuButton = new Button("Back to Main Menu");
        mainMenuButton.setOnAction(e -> returnToMainMenu(stage));

        VBox menuOptions = new VBox(15, title, easyButton, mediumButton, hardButton, mainMenuButton);
        menuOptions.setAlignment(Pos.CENTER);

        base.setCenter(menuOptions);
    }

    private void selectDifficulty(String difficulty, Stage stage){
        System.out.println("Difficulty selected: " + difficulty);
        PlayerChoiceMenu playerChoiceMenu = new PlayerChoiceMenu();
        playerChoiceMenu.start(new Stage());
        stage.close();
    }

    private void returnToMainMenu(Stage stage){
        Menu menu = new Menu();
        menu.start(new Stage());
        stage.close();
    }
}
//Resources: https://github.com/jjenkov/javafx-examples/tree/main