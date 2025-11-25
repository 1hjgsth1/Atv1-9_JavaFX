package com.example.atv5_cleiton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtIdade;

    @FXML
    private ComboBox<String> cbCurso;

    @FXML
    private TableView<Aluno> tabelaAlunos;

    @FXML
    private TableColumn<Aluno, String> colNome;

    @FXML
    private TableColumn<Aluno, Integer> colIdade;

    @FXML
    private TableColumn<Aluno, String> colCurso;

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnExcluir;

    @FXML
    private Label lblMensagem;

    private ObservableList<Aluno> listaAlunos;

    @FXML
    public void initialize() {
        // Lista que alimenta a tabela
        listaAlunos = FXCollections.observableArrayList();

        // Configura as colunas da tabela (usa os getters de Aluno)
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));
        colCurso.setCellValueFactory(new PropertyValueFactory<>("curso"));

        tabelaAlunos.setItems(listaAlunos);

        // Opções de curso no ComboBox (pode ajustar como quiser)
        cbCurso.getItems().addAll(
                "Informática",
                "Administração",
                "Engenharia",
                "Direito",
                "Medicina"
        );

        // Eventos dos botões
        btnAdicionar.setOnAction(event -> adicionarAluno());
        btnExcluir.setOnAction(event -> excluirAluno());
    }

    private void adicionarAluno() {
        String nome = txtNome.getText().trim();
        String idadeTexto = txtIdade.getText().trim();
        String curso = cbCurso.getValue();

        if (nome.isEmpty() || idadeTexto.isEmpty() || curso == null) {
            lblMensagem.setText("Preencha nome, idade e selecione um curso.");
            return;
        }

        int idade;
        try {
            idade = Integer.parseInt(idadeTexto);
        } catch (NumberFormatException e) {
            lblMensagem.setText("Idade inválida. Digite um número inteiro.");
            return;
        }

        Aluno aluno = new Aluno(nome, idade, curso);
        listaAlunos.add(aluno);

        // Limpar campos após adicionar
        txtNome.clear();
        txtIdade.clear();
        cbCurso.getSelectionModel().clearSelection();

        lblMensagem.setText("Aluno adicionado com sucesso.");
    }

    private void excluirAluno() {
        Aluno selecionado = tabelaAlunos.getSelectionModel().getSelectedItem();

        if (selecionado == null) {
            lblMensagem.setText("Selecione um aluno na tabela para excluir.");
            return;
        }

        listaAlunos.remove(selecionado);
        lblMensagem.setText("Aluno excluído.");
    }
}
