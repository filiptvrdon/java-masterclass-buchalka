module sk.filiptvrdon.javafxchallenge {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.xml;

    opens sk.filiptvrdon.javafxchallenge to javafx.fxml;
    exports sk.filiptvrdon.javafxchallenge;
    exports sk.filiptvrdon.javafxchallenge.datamodel;
    opens sk.filiptvrdon.javafxchallenge.datamodel to javafx.fxml;
}