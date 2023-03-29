package sk.filiptvrdon.todolistapp;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sk.filiptvrdon.todolistapp.dataModel.TodoData;
import sk.filiptvrdon.todolistapp.dataModel.TodoItem;

import java.time.LocalDate;

public class DialogController {
    @FXML
    private TextField shortDescriptionField;
    @FXML
    private TextArea detailsTextArea;
    @FXML
    private DatePicker deadlinePicker;

    public TodoItem processResults(){
        System.out.println("PROCESSING RESULTS");
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsTextArea.getText().trim();
        LocalDate deadline = deadlinePicker.getValue();
        TodoItem newItem = new TodoItem(shortDescription,details,deadline);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;
    }
}
