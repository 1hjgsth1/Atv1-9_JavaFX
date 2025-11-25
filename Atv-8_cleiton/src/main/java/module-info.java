module com.example.atv8_cleiton {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.atv8_cleiton to javafx.fxml;
    exports com.example.atv8_cleiton;
}