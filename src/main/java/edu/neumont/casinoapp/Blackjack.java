package edu.neumont.casinoapp;

import edu.neumont.casinoapp.models.Card;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class Blackjack {
    private static int TOTAL_FUNDS = 5000;
    private static int CURRENT_BET = 0;
    private static String STATUS_MSG = "Welcome to Blackjack! Please Select a bet to begin!";
    private static Card NEXT_CARD;

    @FXML
    private Label lblStatusBar, lblCurrentBet, lblTotalFunds;
    @FXML
    private ImageView imgvBet10, imgvBet20, imgvBet50, imgvBet100, imgvBet500, imgvBet1K, imgvBet5K, imgvNextCard;
    @FXML
    private ImageView imgvDealerCard1, imgvDealerCard2, imgvDealerCard3, imgvDealerCard4, imgvDealerCard5, imgvDealerCard6;
    @FXML
    private ImageView imgvPlayerCard1, imgvPlayerCard2, imgvPlayerCard3, imgvPlayerCard4, imgvPlayerCard5, imgvPlayerCard6;

    private ImageView[] playerCards = {imgvPlayerCard1, imgvPlayerCard2, imgvPlayerCard3, imgvPlayerCard4, imgvPlayerCard5, imgvPlayerCard6};
    private ImageView[] dealerCards = {imgvDealerCard1, imgvDealerCard2, imgvDealerCard3, imgvDealerCard4, imgvDealerCard5, imgvDealerCard6};

    @FXML
    protected void initialize() {
        imgvBet10.setOnMouseClicked(event -> updateBet(event, 10));
        imgvBet20.setOnMouseClicked(event -> updateBet(event, 20));
        imgvBet50.setOnMouseClicked(event -> updateBet(event, 50));
        imgvBet100.setOnMouseClicked(event -> updateBet(event, 100));
        imgvBet500.setOnMouseClicked(event -> updateBet(event, 500));
        imgvBet1K.setOnMouseClicked(event -> updateBet(event, 1000));
        imgvBet5K.setOnMouseClicked(event -> updateBet(event, 5000));
        updateView();
    }

    private void updateView() {
        lblCurrentBet.setText(CURRENT_BET + "");
        lblTotalFunds.setText(TOTAL_FUNDS + "");
        lblStatusBar.setText(STATUS_MSG);
    }

    private void updateBet(MouseEvent event, int betAmount) {
        if (event.getButton() == MouseButton.PRIMARY) {
            if (CURRENT_BET + betAmount <= TOTAL_FUNDS) {
                STATUS_MSG = "Confirm your bet to deal a new hand!";
                CURRENT_BET += betAmount;
            } else {
                STATUS_MSG = "You don't have enough to bet that much!";
            }
        } else if (event.getButton() == MouseButton.SECONDARY) {
            if (CURRENT_BET - betAmount > 0) {
                STATUS_MSG = "Confirm your bet to deal a new hand!";
                CURRENT_BET -= betAmount;
            }
        }
        updateView();
    }

    @FXML
    protected void onConfirmBet() {
        // deal user two cards
        // deal dealer two hidden cards
        // load next card variable
        updateView();
    }

    @FXML
    protected void onHit() {
        // add card to user's hand
        // check bust, if so, lose bet, no dealer's turn
        updateView();
    }

    @FXML
    protected void onDoubleDown() {
        // double bet and do dealers turn (soft 16)
        updateView();
    }

    @FXML
    protected void onStand() {
        // do dealers turn (soft 16)
        updateView();
    }

    @FXML
    protected void onCheat() {
        // show Dealer's hand
        // show next card
        // taunt user via status message
        // should apply for entire hand, not entire game
        updateView();
    }

    @FXML
    protected void onReturnMenu() {
        BaseApplication.sh.activate("GameMenu");
    }
}
