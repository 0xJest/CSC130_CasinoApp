package edu.neumont.casinoapp.model;

import javafx.scene.image.Image;

public class Card {
    private Suits suit;
    private int value;
    private String fileName;
    private boolean isFaceUp;

    public Card(Suits suit, int value, String fileName) {
        this.suit = suit;
        this.value = value;
        this.fileName = fileName;
        this.isFaceUp = false;
    }

    public Suits getSuit() {
        return suit;
    }

    public void setSuit(Suits suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void setFaceUp(boolean faceUp) {
        isFaceUp = faceUp;
    }
}
