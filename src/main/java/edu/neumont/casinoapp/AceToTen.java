package edu.neumont.casinoapp;

import javafx.fxml.FXML;

public class AceToTen {

    @FXML
    protected void initialize() {

    }

    @FXML
    protected void onReturnMenu() {
        BaseApplication.sh.activate("GameMenu");
    }
}
