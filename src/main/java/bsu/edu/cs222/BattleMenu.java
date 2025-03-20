package bsu.edu.cs222;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BattleMenu {
    public void start(Stage stage) {
        stage.setTitle("Battle!");

        BorderPane base = new BorderPane();
        base.setStyle("-fx-background-color: #6badce;");

        Button endCardButton = new Button("Go to end card menu");
        endCardButton.setOnAction(e -> openEndCard((stage)));

        FileInputStream input = null;//Added
        try {
            input = new FileInputStream("src/Assets/BattleMenuSketchBG.jpg");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        javafx.scene.image.Image image = new Image(input);

        BackgroundImage backgroundimage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        Background background = new Background(backgroundimage);

        VBox menuOptions = new VBox(15.0, endCardButton);
        menuOptions.setStyle("-fx-alignment: bottom-right;");
        menuOptions.setBackground(background);

        Scene scene = new Scene(base, 800, 600);
        stage.setScene(scene);
        stage.show();

        base.setCenter(menuOptions);
    }

    private void openEndCard(Stage stage){
        EndCard endCard = new EndCard();
        try {
            endCard.start(new Stage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        stage.close();
    }
}