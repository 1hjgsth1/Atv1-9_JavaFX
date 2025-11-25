package com.example.atv4_cleiton;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtNota1;

    @FXML
    private TextField txtNota2;

    @FXML
    private TextField txtNota3;

    @FXML
    private Button btnCalcular;

    @FXML
    private Label lblResultado;

    @FXML
    public void initialize() {
        btnCalcular.setOnAction(event -> calcularMedia());
    }

    private void calcularMedia() {
        String nome = txtNome.getText().trim();

        if (nome.isEmpty() ||
                txtNota1.getText().trim().isEmpty() ||
                txtNota2.getText().trim().isEmpty() ||
                txtNota3.getText().trim().isEmpty()) {

            lblResultado.setText("Preencha todos os campos.");
            return;
        }

        double n1, n2, n3;

        try {
            n1 = Double.parseDouble(txtNota1.getText().trim());
            n2 = Double.parseDouble(txtNota2.getText().trim());
            n3 = Double.parseDouble(txtNota3.getText().trim());
        } catch (NumberFormatException e) {
            lblResultado.setText("Digite notas válidas (números).");
            return;
        }

        double media = (n1 + n2 + n3) / 3;

        String situacao;
        if (media >= 7) {
            situacao = "Aprovado";
        } else if (media >= 4) {
            situacao = "Recuperação";
        } else {
            situacao = "Reprovado";
        }

        lblResultado.setText(
                String.format("Aluno %s — média: %.2f — %s.", nome, media, situacao)
        );
    }
}
