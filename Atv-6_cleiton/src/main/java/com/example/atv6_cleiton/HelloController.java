package com.example.atv6_cleiton;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.CheckBox;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML
    private ComboBox<String> cbPao;

    @FXML
    private RadioButton rbBovina;

    @FXML
    private RadioButton rbFrango;

    @FXML
    private RadioButton rbSoja;

    @FXML
    private CheckBox chkQueijo;

    @FXML
    private CheckBox chkBacon;

    @FXML
    private CheckBox chkSalada;

    @FXML
    private CheckBox chkMolho;

    @FXML
    private TextField txtNomeCliente;

    @FXML
    private Button btnGerarPedido;

    @FXML
    private Label lblResultado;

    private ToggleGroup grupoCarne;

    @FXML
    public void initialize() {
        // Opções de pão
        cbPao.getItems().addAll(
                "Francês",
                "Integral",
                "Australiano"
        );

        // Grupo dos RadioButtons de carne
        grupoCarne = new ToggleGroup();
        rbBovina.setToggleGroup(grupoCarne);
        rbFrango.setToggleGroup(grupoCarne);
        rbSoja.setToggleGroup(grupoCarne);

        // Ação do botão
        btnGerarPedido.setOnAction(event -> gerarPedido());
    }

    private void gerarPedido() {
        String nome = txtNomeCliente.getText().trim();
        String tipoPao = cbPao.getValue();

        if (nome.isEmpty()) {
            lblResultado.setText("Informe o nome do cliente.");
            return;
        }

        if (tipoPao == null) {
            lblResultado.setText("Selecione o tipo de pão.");
            return;
        }

        String tipoCarne;
        if (rbBovina.isSelected()) {
            tipoCarne = "Bovina";
        } else if (rbFrango.isSelected()) {
            tipoCarne = "de Frango";
        } else if (rbSoja.isSelected()) {
            tipoCarne = "de Soja";
        } else {
            lblResultado.setText("Selecione o tipo de carne.");
            return;
        }

        // Montar lista de adicionais
        List<String> adicionais = new ArrayList<>();
        if (chkQueijo.isSelected()) adicionais.add("Queijo");
        if (chkBacon.isSelected()) adicionais.add("Bacon");
        if (chkSalada.isSelected()) adicionais.add("Salada");
        if (chkMolho.isSelected()) adicionais.add("Molho");

        String adicionaisTexto;
        if (adicionais.isEmpty()) {
            adicionaisTexto = "sem adicionais.";
        } else {
            adicionaisTexto = "com " + juntarAdicionais(adicionais) + ".";
        }

        String mensagem = String.format(
                "Pedido de %s: pão %s com carne %s, %s",
                nome,
                tipoPao,
                tipoCarne,
                adicionaisTexto
        );

        lblResultado.setText(mensagem);
    }

    // Junta a lista de adicionais com vírgula e "e" no final
    private String juntarAdicionais(List<String> itens) {
        if (itens.size() == 1) {
            return itens.get(0);
        } else if (itens.size() == 2) {
            return itens.get(0) + " e " + itens.get(1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < itens.size(); i++) {
                if (i == itens.size() - 1) {
                    sb.append("e ").append(itens.get(i));
                } else {
                    sb.append(itens.get(i)).append(", ");
                }
            }
            return sb.toString();
        }
    }
}
