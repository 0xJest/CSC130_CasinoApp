package edu.neumont.casinoapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameMenu {


    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onBlackjackClick() {
        BaseApplication.sh.activate("Blackjack");
    }

    @FXML
    protected void onKingsCornerClick() {
        BaseApplication.sh.activate("KingsCorner");
    }

    @FXML
    protected void onAceToTenClick() {
        BaseApplication.sh.activate("AceToTen");
    }

    @FXML
    protected void onMysteryClick() {
        // not_impl
        // https://i.kym-cdn.com/entries/icons/original/000/042/524/maliciouscover.jpg
    }

}