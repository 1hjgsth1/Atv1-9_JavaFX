package com.example.atv1_cleiton;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField txtNumero1;

    @FXML
    private TextField txtNumero2;

    @FXML
    private Label lblResultado;

    @FXML
    private Button btnSoma;

    @FXML
    private Button btnSubtracao;

    @FXML
    private Button btnMultiplicacao;

    @FXML
    private Button btnDivisao;

    @FXML
    public void initialize() {
        btnSoma.setOnAction(event -> calcular('+'));
        btnSubtracao.setOnAction(event -> calcular('-'));
        btnMultiplicacao.setOnAction(event -> calcular('*'));
        btnDivisao.setOnAction(event -> calcular('/'));
    }

    private void calcular(char operacao) {
        try {
            double n1 = Double.parseDouble(txtNumero1.getText().trim());
            double n2 = Double.parseDouble(txtNumero2.getText().trim());
            double resultado;

            switch (operacao) {
                case '+':
                    resultado = n1 + n2;
                    break;
                case '-':
                    resultado = n1 - n2;
                    break;
                case '*':
                    resultado = n1 * n2;
                    break;
                case '/':
                    if (n2 == 0) {
                        lblResultado.setText("Erro: divisão por zero");
                        return;
                    }
                    resultado = n1 / n2;
                    break;
                default:
                    lblResultado.setText("Operação inválida");
                    return;
            }

            lblResultado.setText("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            lblResultado.setText("Digite números válidos.");
        }
    }
}
