module com.example.atv1_cleiton {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.atv1_cleiton to javafx.fxml;
    exports com.example.atv1_cleiton;
}