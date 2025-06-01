package edu.ucab.triviaucabapp;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class HelloController {
    @FXML
    private Label welcomeText;
    
    @FXML
    private Label timerLabel;
    
    private Timeline timeline;
    private int timeSeconds = 30; // 30 seconds max time

    @FXML
    public void initialize() {
        timerLabel.setText(String.format("%d seconds", timeSeconds));
        timeline = new Timeline(
            new KeyFrame(Duration.seconds(1), e -> {
                timeSeconds--;
                timerLabel.setText(String.format("%d seconds", timeSeconds));
                if (timeSeconds <= 0) {
                    timeline.stop();
                    timerLabel.setText("Time's up!");
                }
            })
        );
        timeline.setCycleCount(timeSeconds);
    }

    @FXML
    protected void onStartTimerClick() {
        timeline.play();
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}