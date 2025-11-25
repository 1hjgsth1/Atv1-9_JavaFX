module com.example.atv3_cleiton {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.atv3_cleiton to javafx.fxml;
    exports com.example.atv3_cleiton;
}