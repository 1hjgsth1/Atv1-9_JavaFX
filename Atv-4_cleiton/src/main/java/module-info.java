module com.example.atv4_cleiton {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.atv4_cleiton to javafx.fxml;
    exports com.example.atv4_cleiton;
}