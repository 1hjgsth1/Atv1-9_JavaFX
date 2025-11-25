package com.example.atv2_cleiton;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField txtValor;

    @FXML
    private Label lblResultado;

    @FXML
    private Button btnParaF;

    @FXML
    private Button btnParaC;

    @FXML
    public void initialize() {
        btnParaF.setOnAction(event -> converterParaF());
        btnParaC.setOnAction(event -> converterParaC());
    }

    private void converterParaF() {
        try {
            double c = Double.parseDouble(txtValor.getText().trim());
            double f = (c * 9 / 5) + 32;
            lblResultado.setText(String.format("%.2f°F", f));
        } catch (NumberFormatException e) {
            lblResultado.setText("Digite um número válido.");
        }
    }

    private void converterParaC() {
        try {
            double f = Double.parseDouble(txtValor.getText().trim());
            double c = (f - 32) * 5 / 9;
            lblResultado.setText(String.format("%.2f°C", c));
        } catch (NumberFormatException e) {
            lblResultado.setText("Digite um número válido.");
        }
    }
}
