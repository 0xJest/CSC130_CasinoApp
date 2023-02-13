package edu.neumont.casinoapp.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cardList = new ArrayList<>();

    public Deck() {
        // generate 52 card deck
        for (Suits suit : Suits.values()) {

            for (int i = 1; i <= 13; i++) {
                String filePath = "src/main/resources/edu/neumont/casinoapp/assets/BlackJack/Cards/card";
                if (i == 1)
                    cardList.add(new Card(suit, i, filePath + suit.toString() + "A" + ".png"));
                else if (i == 11)
                    cardList.add(new Card(suit, i, filePath + suit.toString() + "J" + ".png"));
                else if (i == 12)
                    cardList.add(new Card(suit, i, filePath + suit.toString() + "Q" + ".png"));
                else if (i == 13)
                    cardList.add(new Card(suit, i, filePath + suit.toString() + "K" + ".png"));
                else
                    cardList.add(new Card(suit, i, filePath + suit.toString() + i + ".png"));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cardList);
    }

    public void shuffelMany(int count) {
        for (int i = 0; i < count; i++) {
            shuffle();
        }
    }

    public Card pop() {
        return cardList.remove(0);
    }

    public List<Card> popMany(int count) {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cards.add(cardList.remove(0));
        }
        return cards;
    }
}