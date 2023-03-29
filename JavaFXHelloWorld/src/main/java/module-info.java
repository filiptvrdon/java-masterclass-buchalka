module com.example.javafxhelloworld {
    requires javafx.controls;
    requires javafx.fxml;


    opens sk.ftvrdon to javafx.fxml;
    exports sk.ftvrdon;
}