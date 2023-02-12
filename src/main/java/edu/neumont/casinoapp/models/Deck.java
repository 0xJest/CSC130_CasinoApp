package edu.neumont.casinoapp.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cardList = new ArrayList<>();

    public Deck() {
        // generate 52 card deck
    }

    public void shuffle(){
        Collections.shuffle(cardList);
    }

    public Card pop(){
        return cardList.remove(0);
    }
    public List<Card> popMany(int count){
        List<Card> cards = new ArrayList<>();
        for(int i = 0; i < count; i++){
            cards.add(cardList.remove(0));
        }
        return cards;
    }
}