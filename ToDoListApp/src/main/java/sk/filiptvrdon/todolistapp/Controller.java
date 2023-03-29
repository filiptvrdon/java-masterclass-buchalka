 package sk.filiptvrdon.todolistapp;

 import javafx.application.Platform;
 import javafx.beans.value.ChangeListener;
 import javafx.beans.value.ObservableValue;
 import javafx.collections.transformation.FilteredList;
 import javafx.collections.transformation.SortedList;
 import javafx.event.ActionEvent;
 import javafx.event.EventHandler;
 import javafx.fxml.FXML;
 import javafx.fxml.FXMLLoader;
 import javafx.scene.control.*;
 import javafx.scene.input.KeyCode;
 import javafx.scene.input.KeyEvent;
 import javafx.scene.layout.BorderPane;
 import javafx.scene.paint.Color;
 import javafx.util.Callback;
 import sk.filiptvrdon.todolistapp.dataModel.TodoData;
 import sk.filiptvrdon.todolistapp.dataModel.TodoItem;

 import java.io.IOException;
 import java.time.LocalDate;
 import java.time.format.DateTimeFormatter;
 import java.util.Comparator;
 import java.util.Optional;
 import java.util.function.Predicate;

 public class Controller {

    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadlineValue;

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private ToggleButton filterToggleButton;

     @FXML
     private ContextMenu listContextMenu;

     private FilteredList<TodoItem> filteredList;
     private Predicate<TodoItem> allItemsPredicate;
     private Predicate<TodoItem> todaysItemsPredicate;

     public void initialize(){

        listContextMenu = new ContextMenu();
        MenuItem deleteMI = new MenuItem("Delete");
        deleteMI.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                deleteItem(item);
            }
        });
        listContextMenu.getItems().addAll(deleteMI);

        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem oldValue, TodoItem newValue) {
                if (newValue != null){
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    deadlineValue.setText(df.format(item.getDeadline()));

                }
            }
        });
        allItemsPredicate = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem todoItem) {
                return true;
            }
        };

        todaysItemsPredicate = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem todoItem) {
                return (todoItem.getDeadline().equals(LocalDate.now()));
            }
        };

         filteredList = new FilteredList<>(TodoData.getInstance().getTodoItems(), allItemsPredicate);


         SortedList<TodoItem> sortedList = new SortedList<>(filteredList,
                 new Comparator<TodoItem>() {
                     @Override
                     public int compare(TodoItem o1, TodoItem o2){
                         return o1.getDeadline().compareTo(o2.getDeadline());
                     }
                 });

        // todoListView.setItems(TodoData.getInstance().getTodoItems());
        todoListView.setItems(sortedList);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();

        todoListView.setCellFactory(new Callback<ListView<TodoItem>, ListCell<TodoItem>>() {
            @Override
            public ListCell<TodoItem> call(ListView<TodoItem> todoItemListView) {
                ListCell<TodoItem> cell = new ListCell<TodoItem>(){
                    @Override
                    protected void updateItem(TodoItem item, boolean empty){
                        super.updateItem(item, empty);
                        if (empty){
                            setText(null);
                        } else {
                            setText(item.getShortDescription());;
                            if (item.getDeadline().isBefore(LocalDate.now().plusDays(1))){
                                setTextFill(Color.RED);
                            }
                        }
                    }
                };

                cell.emptyProperty().addListener(
                        (obs, wasEmpty, isNowEmpty) -> {
                            if (isNowEmpty){
                                cell.setContextMenu(null);
                            } else {
                                cell.setContextMenu(listContextMenu);
                            }
                });
                return cell;
            }
        });
    }

    @FXML
    public void showNewItemDialog(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New Todo Item");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("todoitemDialog.fxml"));
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
            DialogController controller = fxmlLoader.getController();
            TodoItem newItem = controller.processResults();
            todoListView.getSelectionModel().select(newItem);
        }
    }
    @FXML
    public void handleClickListView(){
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        System.out.println("Selected item: " + item);

        itemDetailsTextArea.setText(item.getDetails());
        deadlineValue.setText(String.valueOf(item.getDeadline()));
    }
    @FXML
    public void handleKeyReleased (KeyEvent keyEvent){
         if (keyEvent.getCode().equals(KeyCode.DELETE)){
             TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
             if (selectedItem != null){
                 deleteItem(selectedItem);
             }
         }
    }

    public void deleteItem(TodoItem item){
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
         alert.setTitle("Delete item");
         alert.setContentText("Are you sure?");
         Optional<ButtonType> result = alert.showAndWait();

         if (result.isPresent() && result.get() == ButtonType.OK) {
             TodoData.getInstance().deleteTodoItem(item);
         }
    }

    @FXML
    public void handleFilterButton(){
         TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();

         if (filterToggleButton.isSelected()){
            filteredList.setPredicate(todaysItemsPredicate);
            if (filteredList.isEmpty()){
                itemDetailsTextArea.clear();
                deadlineValue.setText("");
            } else if (filteredList.contains(selectedItem)){
                todoListView.getSelectionModel().select(selectedItem);
            } else {
                todoListView.getSelectionModel().selectFirst();
            }

         } else {
            filteredList.setPredicate(allItemsPredicate);
            todoListView.getSelectionModel().select(selectedItem);
         }
    }

    @FXML
     public void handleExit(){
         Platform.exit();
    }



}