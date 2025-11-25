module com.example.atv9_cleiton {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.atv9_cleiton to javafx.fxml;
    exports com.example.atv9_cleiton;
}