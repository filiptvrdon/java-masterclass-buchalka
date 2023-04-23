module com.example.lesson343javafxthreads {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lesson343javafxthreads to javafx.fxml;
    exports com.example.lesson343javafxthreads;
}