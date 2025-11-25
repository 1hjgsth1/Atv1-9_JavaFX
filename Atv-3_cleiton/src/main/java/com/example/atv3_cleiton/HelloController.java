package com.example.atv3_cleiton;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class HelloController {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtIdade;

    @FXML
    private RadioButton rbMasculino;

    @FXML
    private RadioButton rbFeminino;

    @FXML
    private CheckBox chkEsportes;

    @FXML
    private Button btnAnalisar;

    @FXML
    private Label lblResultado;

    private ToggleGroup grupoSexo;

    @FXML
    public void initialize() {
        // Grupo para o sexo
        grupoSexo = new ToggleGroup();
        rbMasculino.setToggleGroup(grupoSexo);
        rbFeminino.setToggleGroup(grupoSexo);

        // Evento do botão
        btnAnalisar.setOnAction(event -> analisar());
    }

    private void analisar() {
        String nome = txtNome.getText().trim();
        String idadeTexto = txtIdade.getText().trim();

        if (nome.isEmpty() || idadeTexto.isEmpty()) {
            lblResultado.setText("Preencha nome e idade.");
            return;
        }

        int idade;
        try {
            idade = Integer.parseInt(idadeTexto);
        } catch (NumberFormatException e) {
            lblResultado.setText("Idade inválida. Digite um número inteiro.");
            return;
        }

        String sexo;
        if (rbMasculino.isSelected()) {
            sexo = "masculino";
        } else if (rbFeminino.isSelected()) {
            sexo = "feminino";
        } else {
            lblResultado.setText("Selecione o sexo.");
            return;
        }

        String gostaEsportes = chkEsportes.isSelected()
                ? "gosta de esportes."
                : "não gosta de esportes.";

        String resumo = String.format("%s, %d anos, do sexo %s, %s",
                nome, idade, sexo, gostaEsportes);

        String observacao = (idade < 18)
                ? "Menor de idade."
                : "Maior de idade.";

        lblResultado.setText(resumo + "\n" + observacao);
    }
}
