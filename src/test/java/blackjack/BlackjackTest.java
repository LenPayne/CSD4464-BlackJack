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
        instance.hit(p);
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

    /**
     * Test of sitDown method, of class Blackjack.
     */
    @org.junit.Test
    public void testSitDown() {
        System.out.println("sitDown");
        Player player = null;
        int seat = 0;
        Blackjack instance = new Blackjack();
        instance.sitDown(player, seat);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playHand method, of class Blackjack.
     */
    @org.junit.Test
    public void testPlayHand() {
        System.out.println("playHand");
        Blackjack instance = new Blackjack();
        instance.playHand();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stand method, of class Blackjack.
     */
    @org.junit.Test
    public void testStand() {
        System.out.println("stand");
        Blackjack instance = new Blackjack();
        instance.stand();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hit method, of class Blackjack.
     */
    @org.junit.Test
    public void testHit() {
        System.out.println("hit");
        Player p = null;
        Blackjack instance = new Blackjack();
        instance.hit(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dealerFinish method, of class Blackjack.
     */
    @org.junit.Test
    public void testDealerFinish() {
        System.out.println("dealerFinish");
        Blackjack instance = new Blackjack();
        instance.dealerFinish();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bestValueOfHand method, of class Blackjack.
     */
    @org.junit.Test
    public void testBestValueOfHand() {
        System.out.println("bestValueOfHand");
        List<Card> hand = null;
        Blackjack instance = new Blackjack();
        int expResult = 0;
        int result = instance.bestValueOfHand(hand);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
