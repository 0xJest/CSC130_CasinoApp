package edu.neumont.casinoapp;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import java.net.URL;

public class Mystery {

    @FXML
    protected void onReturnMenu() {
        BaseApplication.sh.activate("GameMenu");
    }

}
