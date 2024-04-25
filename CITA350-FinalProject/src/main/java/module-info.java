module com.example.cita350finalproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens com.example.cita350finalproject to javafx.fxml;
    exports com.example.cita350finalproject;
}