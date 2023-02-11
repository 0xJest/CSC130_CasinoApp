package edu.neumont.casinoapp;

import javafx.fxml.FXML;

public class Mystery {
    @FXML
    protected void onMenuClick() {
        BaseApplication.sh.activate("GameMenu");
    }
}
