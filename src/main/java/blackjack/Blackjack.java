/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author c0587637
 */
public class Blackjack {

    private Deck deck;
    private List<Card> dropPile;
    private List<Card> dealerHand;
    private final List<Player> players = new ArrayList<>();
    private int currentPlayer = -1;

    public Blackjack() {
        deck = new Deck();
        dropPile = new ArrayList<>();
        dealerHand = new ArrayList<>();
        for (int i = 0; i < 6; i++)
            players.add(null);
    }

    public void sitDown(Player player, int seat) {
        players.set(seat, player);
    }

    public void playHand() {
        dealerHand.add(deck.deal());
        dealerHand.add(deck.deal());

        for (Player p : players) {
            if (p != null) {
                if (currentPlayer == -1) {
                    currentPlayer = players.indexOf(p);
                }
                hit(p);
                hit(p);
            }
        }
    }

    public void stand() {
        currentPlayer++;
    }

    public void hit(Player p) {
        p.addCard(deck.deal());
    }

    public void dealerFinish() {
        while (bestValueOfHand(dealerHand) <= 16) {
            dealerHand.add(deck.deal());
        }
    }

    public int bestValueOfHand(List<Card> hand) {
        int result = 0;
        for (Card c : hand) {
            if (c.getFaceValue() == 1) {
                if (result + 11 <= 21) {
                    result += 11;
                } else {
                    result += 1;
                }
            } else {
                result += c.getPointValue();
            }
        }
        return result;
    }

    public Deck getDeck() {
        return deck;
    }

    public List<Card> getDropPile() {
        return dropPile;
    }

    public List<Card> getDealerHand() {
        return dealerHand;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }
    
    
}
