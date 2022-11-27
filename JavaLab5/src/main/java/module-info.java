module com.example.javalab5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javalab5 to javafx.fxml;
    exports com.example.javalab5;
}