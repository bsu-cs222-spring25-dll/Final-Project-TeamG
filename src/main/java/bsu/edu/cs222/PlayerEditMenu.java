package bsu.edu.cs222;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.FileInputStream;

public class PlayerEditMenu {
    Label playerLabel = new Label("Player 1");
    Label hpLabel = new Label("HP: ");
    Label attackLabel = new Label("Attack: ");
    Label defenseLabel = new Label("Defense: ");
    Label title = new Label("Edit Player");

    int selectedPlayer = 1;

    Button playerOneButton = new Button("Player One");
    Button playerTwoButton = new Button("Player Two");
    Button saveButton = new Button("Save changes");
    Button defaultStatButton = new Button("Return to Default Stats");
    Button mainMenuButton = new Button("Back to Main Menu");

    TextField hpInput = new TextField();
    TextField attackInput = new TextField();
    TextField defenseInput = new TextField();

    GridPane statsGrid = new GridPane();

    VBox titleBox = new VBox(10, playerLabel);
    VBox playerSelection = new VBox(10, playerOneButton, playerTwoButton);

    HBox buttonBox = new HBox(10, saveButton, defaultStatButton, mainMenuButton);

    public void start(Stage stage) {
        stage.setTitle("Edit Player");
        title.setFont(new Font("Times New Roman", 60));

        BorderPane base = new BorderPane();
        base.setStyle("-fx-background-color: #6badce;");

        Scene scene = new Scene(base, 800, 600);

        stage.setScene(scene);
        stage.show();

        titleBox.setAlignment(Pos.CENTER);
        playerSelection.setAlignment(Pos.CENTER_LEFT);

        playerOneButton.setOnAction(_ -> switchPlayer(1));
        playerTwoButton.setOnAction(_ -> switchPlayer(2));
        mainMenuButton.setOnAction(_ -> returnToMainMenu(stage));

        statsGrid.setVgap(10.0);
        statsGrid.setHgap(10.0);
        statsGrid.setAlignment(Pos.CENTER);
        statsGrid.add(hpLabel, 0, 0);
        statsGrid.add(hpInput, 1, 0);
        statsGrid.add(attackLabel, 0, 1);
        statsGrid.add(attackInput, 1, 1);
        statsGrid.add(defenseLabel, 0, 2);
        statsGrid.add(defenseInput, 1, 2);

        buttonBox.setAlignment(Pos.BOTTOM_LEFT);

        base.setTop(titleBox);
        base.setLeft(playerSelection);
        base.setCenter(statsGrid);
        base.setBottom(buttonBox);
        base.setBackground(loadBackground());
    }

    private void switchPlayer(int playerNumber){
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
            return new Background(new BackgroundFill(javafx.scene.paint.Color.LIGHTBLUE, null, null));
        }
    }
}
//Resources: https://github.com/jjenkov/javafx-examples/tree/main