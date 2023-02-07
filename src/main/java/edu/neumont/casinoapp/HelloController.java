package edu.neumont.casinoapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    // Scene Transitions:
    // Will need to be setup in individual controllers

    // Stage stage = (Stage) label.getScene().getWindow();
    // FXMLLoader sceneLoader = new FXMLLoader(getClass().getResource("yourFile.fxml"));
    // Parent newScene = sceneLoader.load();
    // stage.setScene(new Scene(newScene));

}