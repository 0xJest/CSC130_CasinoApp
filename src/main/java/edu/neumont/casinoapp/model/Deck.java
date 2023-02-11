package edu.neumont.casinoapp.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> deck = new ArrayList<>();

    public Deck(){

    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public Card pop(){
        return deck.remove(0);
    }
    public List<Card> popMany(int count){
        List<Card> cards = new ArrayList<>();
        for(int i = 0; i < count; i++){
            cards.add(deck.remove(0));
        }
        return cards;
    }
}
