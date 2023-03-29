package sk.filiptvrdon.javafxchallenge;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sk.filiptvrdon.javafxchallenge.datamodel.Contact;

public class AddNewDialogueController {

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField notes;

    public Contact processResults(){
        System.out.println("PROCESSING RESULTS");
        return new Contact(
                firstName.getText(),
                lastName.getText(),
                phoneNumber.getText(),
                notes.getText()
        );

//        return new Contact(
//                new SimpleStringProperty(firstName.getText()),
//                new SimpleStringProperty(lastName.getText()),
//                new SimpleStringProperty(phoneNumber.getText()),
//                new SimpleStringProperty(notes.getText()));
    }
}
