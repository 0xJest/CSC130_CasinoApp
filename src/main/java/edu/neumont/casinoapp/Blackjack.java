package edu.neumont.casinoapp;

import edu.neumont.casinoapp.models.Card;
import edu.neumont.casinoapp.models.Deck;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.util.ArrayList;

public class Blackjack {
    private static int TOTAL_FUNDS = 5000;
    private static int CURRENT_BET = 0;
    private static String STATUS_MSG = "Welcome to Blackjack! Please Select a bet to begin!";
    private static Card NEXT_CARD;
    private static ArrayList<Card> PLAYER_HAND = new ArrayList<>();
    private static ArrayList<Card> DEALER_HAND = new ArrayList<>();

    private static Deck deck = new Deck();

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

    // NOTES
    // Player and Dealer can draw up to a maximum of 6 cards per hand, program should prevent any extra draws
    // Cheat method should reset on drawing a new hand
    // Dealer's hand should start hidden and reveal on Dealer's turn.
    // Dealer stands on 16 or higher
    // All FXML elements should be updated in UpdateView() whenever practical
    // Feel free to add more methods / static variables

    @FXML
    protected void initialize() {
        //Executes on FXML load operation
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
        deck.shuffelMany(3);
        // deal user two cards
        PLAYER_HAND.addAll(deck.popMany(2));
        // deal dealer two hidden cards
        DEALER_HAND.addAll(deck.popMany(2));
        // load next card variable
        NEXT_CARD = deck.pop();
        // update status message
        STATUS_MSG = "Select an action to continue!";
        showCardsInImagePanePlayer(PLAYER_HAND);
        showCardsInImagePaneDealer( DEALER_HAND);
        updateView();
    }

    @FXML
    protected void onHit() {
        // add card to user's hand
        PLAYER_HAND.add(deck.pop());
        // check bust, if so, lose bet, no dealer's turn
        for (Card card : PLAYER_HAND) {
            if (card.getValue() == 11) {
                if (card.getValue() + 10 > 21) {
                    STATUS_MSG = "You busted! You lost your bet!";
                    TOTAL_FUNDS -= CURRENT_BET;
                    CURRENT_BET = 0;
                    updateView();
                    return;
                }
            }
        }
        // update status message
        updateView();
    }

    @FXML
    protected void onDoubleDown() {
        // double bet and do dealers turn
        // update status message
        updateView();
    }

    @FXML
    protected void onStand() {
        // do dealers turn
        // update status message
        updateView();
    }

    @FXML
    protected void onCheat() {
        // show Dealer's hand
        // show next card
        // update status message
        // should apply for entire hand, not entire game
        updateView();
    }


    @FXML
    protected void onReturnMenu() {
        BaseApplication.sh.activate("GameMenu");
    }

    protected void showCardsInImagePanePlayer(ArrayList<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            File file = new File(cards.get(i).getFileName());
            if (file.exists() && file.canRead()) {
                switch (i) {
                    case 0 -> imgvPlayerCard1.setImage(new Image(file.toURI().toString()));
                    case 1 -> imgvPlayerCard2.setImage(new Image(file.toURI().toString()));
                    case 2 -> imgvPlayerCard3.setImage(new Image(file.toURI().toString()));
                    case 3 -> imgvPlayerCard4.setImage(new Image(file.toURI().toString()));
                    case 4 -> imgvPlayerCard5.setImage(new Image(file.toURI().toString()));
                    case 5 -> imgvPlayerCard6.setImage(new Image(file.toURI().toString()));
                    default -> {
                    }
                }
            }
        }

    }
    protected void showCardsInImagePaneDealer( ArrayList<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            File file = new File(cards.get(i).getFileName());
            if (file.exists() && file.canRead()) {
                switch (i) {
                    case 0 -> imgvDealerCard1.setImage(new Image(file.toURI().toString()));
                    case 1 -> imgvDealerCard2.setImage(new Image(file.toURI().toString()));
                    case 2 -> imgvDealerCard3.setImage(new Image(file.toURI().toString()));
                    case 3 -> imgvDealerCard4.setImage(new Image(file.toURI().toString()));
                    case 4 -> imgvDealerCard5.setImage(new Image(file.toURI().toString()));
                    case 5 -> imgvDealerCard6.setImage(new Image(file.toURI().toString()));
                    default -> {
                    }
                }
            }
        }

    }

}
