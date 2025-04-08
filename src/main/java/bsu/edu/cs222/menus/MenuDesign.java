package bsu.edu.cs222.menus;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class MenuDesign {
    //class for design details regarding javafx
    public static Label createLabel(String text, int size){
        Label label = new Label(text);
        label.setFont(new Font("Century", size));
        label.setStyle("-fx-text-fill: white;");
        return label;
    }

    public static TextField createStatField(){
        TextField field = new TextField();
        field.setPrefSize(50.0, 50.0);
        return field;
    }

    public static Button createPlayerButton(String text){
        Button button = new Button(text);
        button.setFont(new Font("Century", 15.0));
        button.setPrefSize(150.0, 50.0);
        return button;
    }

    public static Button createFunctionButton(String text){
        Button button = new Button(text);
        button.setFont(new Font("Century", 15.0));
        button.setPrefSize(200.0, 40.0);
        return button;
    }

    public static Button createExitButton(String text){
        Button button = new Button(text);
        button.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        return button;
    }
}
