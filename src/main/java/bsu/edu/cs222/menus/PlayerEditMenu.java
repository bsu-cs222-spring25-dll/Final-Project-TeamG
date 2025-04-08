package bsu.edu.cs222.menus;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.FileInputStream;

import static bsu.edu.cs222.menus.MenuDesign.*;

public class PlayerEditMenu {
    Label playerLabel = createLabel("Player 1", 45);
    Label hpLabel = createLabel("HP: ", 25);
    Label attackLabel = createLabel("Attack: ", 25);
    Label defenseLabel = createLabel("Defense: ", 25);
    Button playerOneButton = createPlayerButton("Player One");
    Button playerTwoButton = createPlayerButton("Player Two");
    Button saveButton = createFunctionButton("Save changes");
    Button defaultStatButton = createFunctionButton("Return to Default Stats");
    Button mainMenuButton = createFunctionButton("Back to Main Menu");
    TextField hpInput = createStatField();
    TextField attackInput = createStatField();
    TextField defenseInput = createStatField();
    GridPane statsGrid = new GridPane();
    VBox titleBox = new VBox(20, playerLabel);
    VBox playerSelection = new VBox(20, playerOneButton, playerTwoButton);
    HBox buttonBox = new HBox(20, saveButton, defaultStatButton, mainMenuButton);
    Pane layout = new Pane();
    Scene scene = new Scene(layout, 800, 600);
    int selectedPlayer = 1;

    public void start(Stage stage) {
        stage.setTitle("Edit Player");
        layout.setStyle("-fx-background-color: #6badce;");
        titleBox.setLayoutX(290);
        titleBox.setLayoutY(30);
        playerOneButton.setOnAction(_ -> switchPlayer(1));
        playerTwoButton.setOnAction(_ -> switchPlayer(2));
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
}
//Resources: https://github.com/jjenkov/javafx-examples/tree/main