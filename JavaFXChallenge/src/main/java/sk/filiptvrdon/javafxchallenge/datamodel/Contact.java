package sk.filiptvrdon.javafxchallenge.datamodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;

public class Contact {
    @FXML
    SimpleStringProperty firstName = new SimpleStringProperty("");
    @FXML
    SimpleStringProperty lastName = new SimpleStringProperty("");
    @FXML
    SimpleStringProperty phoneNumber = new SimpleStringProperty("");
    @FXML
    SimpleStringProperty notes = new SimpleStringProperty("");

    public Contact() {
    }

    /*
    public Contact(SimpleStringProperty firstName, SimpleStringProperty lastName, SimpleStringProperty phoneNumber, SimpleStringProperty notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.notes = notes;
    }
    */

    public Contact(String firstname, String lastName, String phoneNumber, String notes){
        this.firstName.set(firstname);
        this.lastName.set(lastName);
        this.phoneNumber.set(phoneNumber);
        this.notes.set(notes);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String getNotes() {
        return notes.get();
    }

    public void setNotes(String notes) {
        this.notes.set(notes);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName=" + firstName +
                ", lastName=" + lastName +
                ", phoneNumber=" + phoneNumber +
                ", notes=" + notes +
                '}';
    }
}
