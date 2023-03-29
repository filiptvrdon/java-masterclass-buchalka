package sk.filiptvrdon.events;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    public Label threadStateLabel;
    @FXML
    private Label welcomeText;
    @FXML
    private TextField textField;
    @FXML
    private Button helloButton;
    @FXML
    private Button byeButton;
    @FXML
    private CheckBox clearCheckBox;

    @FXML
    public void initialize (){
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    protected void onButtonClick(ActionEvent event) {
        if (event.getSource().equals(helloButton)){
            System.out.println("Hello " + textField.getText());
        } else if (event.getSource().equals(byeButton)){
            System.out.println("Bye " + textField.getText());
        }

        if (clearCheckBox.isSelected()){
            textField.clear();
            helloButton.setDisable(true);
            byeButton.setDisable(true);
        }

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                    System.out.println("I'm going to sleep on the " + s);
                    Thread.sleep(5000);

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            threadStateLabel.setText("Background process has finished");
                        }
                    });


                } catch (InterruptedException e) {
                    //
                }
            }
        };
        new Thread(task).start();

    }

    @FXML
    public void handleKeyReleased(){
        String text = textField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        helloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }

    public void handleCheckBoxChange(){
        System.out.println("The checkbox is " + (clearCheckBox.isSelected() ? "checked" : "unchecked"));
    }
}