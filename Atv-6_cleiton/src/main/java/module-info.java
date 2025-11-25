module com.example.atv6_cleiton {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.atv6_cleiton to javafx.fxml;
    exports com.example.atv6_cleiton;
}