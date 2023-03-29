module sk.filiptvrdon.todolistapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens sk.filiptvrdon.todolistapp to javafx.fxml;
    exports sk.filiptvrdon.todolistapp;
}