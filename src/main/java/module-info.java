module com.example.collegemanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.collegemanagementsystem to javafx.fxml;
    exports com.example.collegemanagementsystem;
}