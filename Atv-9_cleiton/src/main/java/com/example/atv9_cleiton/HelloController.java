package com.example.atv9_cleiton;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.NumberFormat;
import java.util.Locale;

public class HelloController {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtKwh;

    @FXML
    private ComboBox<String> cbTipo;

    @FXML
    private Button btnCalcular;

    @FXML
    private Label lblResultado;

    @FXML
    public void initialize() {
        // Tipos de residência
        cbTipo.getItems().addAll(
                "Residencial",
                "Comercial",
                "Industrial"
        );

        btnCalcular.setOnAction(event -> calcularConta());
    }

    private void calcularConta() {
        String nome = txtNome.getText().trim();
        String kwhTexto = txtKwh.getText().trim();
        String tipo = cbTipo.getValue();

        if (nome.isEmpty() || kwhTexto.isEmpty() || tipo == null) {
            lblResultado.setText("Preencha nome, consumo e tipo de residência.");
            return;
        }

        double kwh;
        try {
            kwh = Double.parseDouble(kwhTexto);
        } catch (NumberFormatException e) {
            lblResultado.setText("Quantidade de kWh inválida.");
            return;
        }

        if (kwh < 0) {
            lblResultado.setText("Consumo não pode ser negativo.");
            return;
        }

        double tarifa;
        switch (tipo.toLowerCase()) {
            case "residencial":
                tarifa = 0.60;
                break;
            case "comercial":
                tarifa = 0.48;
                break;
            case "industrial":
                tarifa = 0.75;
                break;
            default:
                lblResultado.setText("Tipo de residência inválido.");
                return;
        }

        double valor = kwh * tarifa;

        // Formatação em R$ com vírgula (pt-BR)
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String valorFormatado = nf.format(valor);

        String mensagem = String.format(
                "Cliente: %s — Tipo: %s — Consumo: %.0f kWh — Valor: %s",
                nome,
                tipo,
                kwh,
                valorFormatado
        );

        lblResultado.setText(mensagem);
    }
}
