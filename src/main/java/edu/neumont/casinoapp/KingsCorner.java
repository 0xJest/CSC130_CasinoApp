package edu.neumont.casinoapp;

import javafx.fxml.FXML;

public class KingsCorner {
    @FXML
    protected void onMenuClick() {
        BaseApplication.sh.activate("GameMenu");
    }
}
