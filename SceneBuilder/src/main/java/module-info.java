module sk.filiptvrdon.scenebuilder {
    requires javafx.controls;
    requires javafx.fxml;


    opens sk.filiptvrdon.scenebuilder to javafx.fxml;
    exports sk.filiptvrdon.scenebuilder;
}