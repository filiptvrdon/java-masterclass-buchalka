module com.example.javafxlayouts {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens com.example.javafxlayouts to javafx.fxml;
    exports com.example.javafxlayouts;
}