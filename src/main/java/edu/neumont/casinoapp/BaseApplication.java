package edu.neumont.casinoapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class BaseApplication extends Application {
    public static SceneHandler sh;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(BaseApplication.class.getResource("GameMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Karen's Card Casino");
        stage.setResizable(true);
        stage.setScene(scene);

        sh = new SceneHandler(scene);
        sh.addScene("GameMenu", FXMLLoader.load(getClass().getResource( "GameMenu.fxml" )));
        sh.addScene("Blackjack", FXMLLoader.load(getClass().getResource( "Blackjack.fxml" )));
        sh.addScene("KingsCorner", FXMLLoader.load(getClass().getResource( "KingsCorner.fxml" )));
        sh.addScene("AceToTen", FXMLLoader.load(getClass().getResource( "AceToTen.fxml" )));
        sh.addScene("Mystery", FXMLLoader.load(getClass().getResource( "Mystery.fxml" )));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}