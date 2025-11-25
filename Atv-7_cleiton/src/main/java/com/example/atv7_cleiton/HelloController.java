package com.example.atv7_cleiton;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class HelloController {

    @FXML
    private Circle luzVermelha;

    @FXML
    private Circle luzAmarela;

    @FXML
    private Circle luzVerde;

    @FXML
    private Button btnIniciar;

    @FXML
    private Button btnParar;

    private Timeline timeline;
    private int estado = 0; // 0 = vermelho, 1 = amarelo, 2 = verde

    @FXML
    public void initialize() {

        // Inicia com tudo apagado
        luzVermelha.setFill(Color.GRAY);
        luzAmarela.setFill(Color.GRAY);
        luzVerde.setFill(Color.GRAY);

        // Timeline que troca a cor a cada 2 segundos
        timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> trocarCor()));
        timeline.setCycleCount(Timeline.INDEFINITE);

        btnIniciar.setOnAction(event -> timeline.play());
        btnParar.setOnAction(event -> timeline.stop());
    }

    private void trocarCor() {
        // Apaga tudo primeiro
        luzVermelha.setFill(Color.GRAY);
        luzAmarela.setFill(Color.GRAY);
        luzVerde.setFill(Color.GRAY);

        // Liga a luz correta
        switch (estado) {
            case 0:
                luzVermelha.setFill(Color.RED);
                break;
            case 1:
                luzAmarela.setFill(Color.YELLOW);
                break;
            case 2:
                luzVerde.setFill(Color.GREEN);
                break;
        }

        // Próximo estado
        estado = (estado + 1) % 3;
    }
}
