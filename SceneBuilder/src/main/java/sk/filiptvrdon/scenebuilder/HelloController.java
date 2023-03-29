package sk.filiptvrdon.scenebuilder;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Label secondLabel;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onOkButtonClick(){
        System.out.println("button OK was pressed");
        secondLabel.setText("Ok was pressed :)");
    }
}