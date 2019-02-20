/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author c0587637
 */
public class Deck {

    Stack<Card> cards;

    public Deck() {
        reset();
        shuffle();
    }
    
    public final void reset() {        
        cards = new Stack<>();
        for (Suit suit : Suit.values()) {
            for (int i = 1; i <= 13; i++) {
                cards.add(new Card(i, suit));
            }
        }
    }

    public final void shuffle() {
        List<Card> pool = new ArrayList<>();
        while (!cards.empty()) {
            pool.add(cards.pop());
        }
        pool.sort(new Comparator<Card>() {
            @Override
            public int compare(Card c1, Card c2) {
                return (int) Math.round(Math.random() * 2 - 1);
            }
        });
        while (!pool.isEmpty()) {
            cards.push(pool.remove(0));
        }
    }
    
    public Card deal() {
        return cards.pop();
    }
    
    public void add(Card card) {
        cards.add(card);
    }
}
