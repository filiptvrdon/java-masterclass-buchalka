module sk.filiptvrdon.events {
    requires javafx.controls;
    requires javafx.fxml;


    opens sk.filiptvrdon.events to javafx.fxml;
    exports sk.filiptvrdon.events;
}