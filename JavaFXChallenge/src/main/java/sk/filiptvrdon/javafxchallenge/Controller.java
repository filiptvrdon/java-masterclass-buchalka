package sk.filiptvrdon.javafxchallenge;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import sk.filiptvrdon.javafxchallenge.datamodel.Contact;
import sk.filiptvrdon.javafxchallenge.datamodel.ContactData;

import java.io.IOException;
import java.util.Optional;

public class Controller {

    @FXML
    private BorderPane mainBorderPane;
    @FXML
    TableView<Contact> tableView = new TableView<>();
    @FXML
    MenuItem addNewMenuItem;
    ContactData contactData = ContactData.getInstance();

    public void initialize (){
        tableView.setItems(contactData.getContacts());
    }

    @FXML
    public void handleAddNewMenuItem(){
        System.out.println("MENU ITEM CLICKED");

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New Contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("add-new-dialogue.fxml"));

        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch(IOException e){
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            AddNewDialogueController controller = fxmlLoader.getController();
            Contact newContact = controller.processResults();
            contactData.addContact(newContact);
        }
    }

    @FXML
    public void handleTableViewKeyReleased(KeyEvent keyEvent){
        if (keyEvent.getCode().equals(KeyCode.DELETE)){
            Contact selectedContact = tableView.getSelectionModel().getSelectedItem();
            if (selectedContact != null){
                contactData.removeContact(selectedContact);
            }
        }
    }
}