package edu.neumont.casinoapp;

import javafx.fxml.FXML;

public class Blackjack {

    @FXML
    protected void onMenuClick() {
        BaseApplication.sh.activate("GameMenu");
    }
}
