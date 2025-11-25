package com.example.atv8_cleiton;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class HelloController {

    @FXML
    private TextField txtNumero;

    @FXML
    private Button btnVerificar;

    @FXML
    private Button btnNovo;

    @FXML
    private Label lblResultado;

    private int numeroSorteado;
    private Random random;

    @FXML
    public void initialize() {
        random = new Random();
        sortearNumero();

        btnVerificar.setOnAction(event -> verificar());
        btnNovo.setOnAction(event -> sortearNumero());
    }

    private void sortearNumero() {
        numeroSorteado = random.nextInt(10) + 1; // 1 a 10
        lblResultado.setText("Novo número gerado! Tente adivinhar.");
        txtNumero.clear();
    }

    private void verificar() {
        String entrada = txtNumero.getText().trim();

        if (entrada.isEmpty()) {
            lblResultado.setText("Digite um número.");
            return;
        }

        int chute;
        try {
            chute = Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            lblResultado.setText("Digite um número válido.");
            return;
        }

        if (chute < 1 || chute > 10) {
            lblResultado.setText("Digite um número entre 1 e 10.");
            return;
        }

        if (chute == numeroSorteado) {
            lblResultado.setText("Acertou!");
        } else {
            lblResultado.setText("Errou! O número era " + numeroSorteado + ".");
        }
    }
}
