module com.example.atv2_cleiton {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.atv2_cleiton to javafx.fxml;
    exports com.example.atv2_cleiton;
}