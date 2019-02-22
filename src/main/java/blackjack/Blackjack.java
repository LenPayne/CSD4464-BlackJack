/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author c0587637
 */
@ApplicationScoped
@Named
public class Blackjack {

    private Deck deck;
    private List<Card> dropPile;
    private List<Card> dealerHand;
    private final List<Player> players = new ArrayList<>();
    private List<Card> playerHand = new ArrayList<>();
    private int currentPlayer = -1;
    private boolean inProgress = false;

    public Blackjack() {
        deck = new Deck();
        dropPile = new ArrayList<>();
        dealerHand = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            players.add(null);
        }
    }

    public void sitDown(Player player, int seat) {
        players.set(seat, new Player());
    }

    public void playHand() {
        while (!dealerHand.isEmpty()) {
            dropPile.add(dealerHand.remove(0));
        }
        while (!playerHand.isEmpty()) {
            dropPile.add(playerHand.remove(0));
        }

        dealerHand.add(deck.deal());
        dealerHand.add(deck.deal());

        playerHand.add(deck.deal());
        playerHand.add(deck.deal());
        inProgress = true;
    }

    public void stand() {
        dealerFinish();
    }

    public void hit() {
        playerHand.add(deck.deal());
    }

    public void dealerFinish() {
        while (bestValueOfHand(dealerHand) <= 16) {
            dealerHand.add(deck.deal());
        }
        inProgress = false;
    }

    public boolean isBusted(List<Card> hand) {
        return bestValueOfHand(hand) > 21;
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

    public List<Card> getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(List<Card> playerHand) {
        this.playerHand = playerHand;
    }

    public boolean isInProgress() {
        return inProgress;
    }
    
    public String getIcon(Suit s) {
        switch(s) {
            case HEARTS:
                return "fas fa-heart";
            case DIAMONDS:
                return "fas fa-gem";
            case SPADES:
                return "fas fa-spider";
            default:
                return "fas fa-cube";
        }
    }
    
    public String getFilename(Card c) {
        String v = c.getFaceValue()+"";
        switch(v) {
            case "1":
                v = "A";
                break;
            case "11":
                v = "J";
                break;
            case "12":
                v = "Q";
                break;
            case "13":
                v = "K";
                break;
        }
        String s = c.getSuit().toString().substring(0, 1);
        return v+s+".png";
    }

}
