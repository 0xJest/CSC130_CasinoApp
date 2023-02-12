package edu.neumont.casinoapp;

import javafx.fxml.FXML;

public class Blackjack {

//    rectangle.setOnMouseClicked(event ->
//    {
//        if (event.getButton() == MouseButton.PRIMARY)
//        {
//            rectangle.setFill(Color.GREEN);
//        } else if (event.getButton() == MouseButton.SECONDARY)
//        {
//            rectangle.setFill(Color.RED);
//        }
//    });

    @FXML
    protected void onMenuClick() {
        BaseApplication.sh.activate("GameMenu");
        BaseApplication.sh.resize(400, 600);
    }
}
