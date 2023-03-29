module sk.filiptvrdon.javafxapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens sk.filiptvrdon.javafxapp to javafx.fxml;
    exports sk.filiptvrdon.javafxapp;
}