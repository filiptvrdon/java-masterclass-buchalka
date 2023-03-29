module com.example.hbox {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hbox to javafx.fxml;
    exports com.example.hbox;
}