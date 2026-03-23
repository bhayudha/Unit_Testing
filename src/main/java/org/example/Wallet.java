package org.example;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private Owner owner;
    private List<String> cards;
    private double cash;

    public Wallet() {
        this.cards = new ArrayList<>();
        this.cash = 0;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }

    public void addCard(String cardName) {
        cards.add(cardName);
    }

    public boolean removeCard(String cardName) {
        return cards.remove(cardName);
    }

    public List<String> getCards() {
        return cards;
    }

    public void addCash(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Jumlah deposit tidak boleh negatif");
        }
        this.cash += amount;
    }

    public void withdrawCash(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("IllegalArgumentException");
        }
        if (amount > this.cash) {
            throw new RuntimeException("Insufficient Funds Exception");
        }
        this.cash -= amount;
    }

    public double getCashBalance() {
        return cash;
    }
}