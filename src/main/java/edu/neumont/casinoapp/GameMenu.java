package edu.neumont.casinoapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

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
        BaseApplication.sh.activate("Mystery");
    }

}