package bsu.edu.cs222;

import bsu.edu.cs222.combat.CharacterBase;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.FileInputStream;

public class BattleMenu {
    CharacterBase enemy;
    CharacterBase player;
    public void start(Stage stage, CharacterBase enemy, CharacterBase player) {
        this.enemy = enemy;
        this.player = player;
        stage.setTitle("Battle!");

        BorderPane base = new BorderPane();
        base.setStyle("-fx-background-color: #6badce;");

        Button endCardButton = new Button("Go to end card menu");
        endCardButton.setOnAction(_ -> openEndCard((stage)));

        VBox menuOptions = new VBox(15.0, endCardButton);
        menuOptions.setStyle("-fx-alignment: bottom-right;");
        menuOptions.setBackground(loadBackground());

        Scene scene = new Scene(base, 800, 600);
        stage.setScene(scene);
        stage.show();

        base.setCenter(menuOptions);
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
            return new Background(new BackgroundFill(javafx.scene.paint.Color.LIGHTBLUE, null, null));
        }
    }
}