module com.example.atv5_cleiton {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.atv5_cleiton to javafx.fxml;
    exports com.example.atv5_cleiton;
}