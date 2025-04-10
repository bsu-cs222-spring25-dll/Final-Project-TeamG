package bsu.edu.cs222.menu;

import bsu.edu.cs222.combat.BattleLogic;
import bsu.edu.cs222.combat.CharacterBase;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.FileInputStream;

import static bsu.edu.cs222.menu.MenuDesign.*;

public class BattleMenu {

    BattleLogic battleLogic = new BattleLogic();
    CharacterBase enemy;
    CharacterBase player;
    Button endCardButton = new Button("Go to end card menu");
    Button attackButton = createPlayerButton("Attack", 15);
    Button defendButton = createPlayerButton("Defense", 15);
    VBox menuOptions = new VBox(15.0, endCardButton);
    VBox actionOptions = new VBox(15.0, attackButton, defendButton);
    Pane layout = new Pane();
    Scene scene = new Scene(layout, 800, 600);

    public void start(Stage stage, CharacterBase enemy, CharacterBase player) {
        this.enemy = enemy;
        this.player = player;
        stage.setTitle("Battle!");
        layout.setStyle("-fx-background-color: #6badce;");
        endCardButton.setOnAction(_ -> openEndCard((stage)));
        attackButton.setOnAction(_ -> battleLogic.attackBattleTurnOrder(player, enemy));
        defendButton.setOnAction(_ -> battleLogic.defendBattleTurnOrder(player, enemy));
        endCardButton.setFont(new Font("Century", 8.0));
        endCardButton.setPrefSize(90.0, 30.0);
        menuOptions.setStyle("-fx-alignment: bottom-right;");
        menuOptions.setLayoutX(650.0);
        menuOptions.setLayoutY(550.0);
        actionOptions.setLayoutX(50.0);
        actionOptions.setLayoutY(450.0);
        stage.setScene(scene);
        stage.show();
        layout.getChildren().addAll(menuOptions, actionOptions);
        layout.setBackground(loadBackground());
    }

    private void openEndCard(Stage stage){
        EndCard endCard = new EndCard();
        try {
            endCard.start(new Stage(), enemy);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        stage.close();
    }

    private Background loadBackground(){
        try(FileInputStream input = new FileInputStream("src/Assets/" + "BattleMenuSketchBG" + ".jpg")){
            Image image = new Image(input);
            BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            return new Background(backgroundImage);
        } catch(Exception e){
            System.err.println("Failed to load background image.");
            return new Background(new BackgroundFill(Color.BLACK, null, null));
        }
    }
}