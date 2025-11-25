module com.example.atv7_cleiton {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.atv7_cleiton to javafx.fxml;
    exports com.example.atv7_cleiton;
}