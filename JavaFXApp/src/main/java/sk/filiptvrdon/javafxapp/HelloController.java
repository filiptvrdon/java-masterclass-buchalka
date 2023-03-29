package sk.filiptvrdon.javafxapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void handleMouseEnter(){
        welcomeText.setScaleX(2.0);
        welcomeText.setScaleY(2.0);
    }

    @FXML
    public void handleMouseExit(){
        welcomeText.setScaleX(1.0);
        welcomeText.setScaleY(1.0);
    }

}