package edu.neumont.casinoapp;

import javafx.fxml.FXML;

public class KingsCorner {
    @FXML
    protected void onReturnMenu() {
        BaseApplication.sh.activate("GameMenu");
    }
}
