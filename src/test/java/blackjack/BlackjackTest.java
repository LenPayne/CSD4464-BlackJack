/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author c0587637
 */
public class BlackjackTest {
    
    public BlackjackTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testGame() {
        Blackjack instance = new Blackjack();
        Player p = new Player();
        instance.sitDown(p, 0);
        instance.playHand();
        instance.hit();
        instance.stand();
        instance.dealerFinish();
        System.out.println("Dealer Hand");
        for(Card c : instance.getDealerHand()) {
            System.out.println(c.getFaceValue() + " " + c.getSuit());
        }        
        System.out.println("Value: " + instance.bestValueOfHand(instance.getDealerHand()));
        System.out.println("Player Hand");
        for(Card c : p.getHand()) {
            System.out.println(c.getFaceValue() + " " + c.getSuit());
        }
        System.out.println("Value: " + instance.bestValueOfHand(p.getHand()));
    }
}
