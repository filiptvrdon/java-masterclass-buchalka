module com.example.fxlayouts {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fxlayouts to javafx.fxml;
    exports com.example.fxlayouts;
}