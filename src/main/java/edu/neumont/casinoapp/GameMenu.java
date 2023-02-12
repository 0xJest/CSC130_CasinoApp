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
        BaseApplication.sh.resize(500, 650);
    }

    @FXML
    protected void onKingsCornerClick() {
        BaseApplication.sh.activate("KingsCorner");
        BaseApplication.sh.resize(400, 600);
    }

    @FXML
    protected void onAceToTenClick() {
        BaseApplication.sh.activate("AceToTen");
        BaseApplication.sh.resize(400, 600);
    }


    @FXML
    protected void onMysteryClick() {
        BaseApplication.sh.activate("Mystery");
        BaseApplication.sh.resize(400, 600);
    }

}