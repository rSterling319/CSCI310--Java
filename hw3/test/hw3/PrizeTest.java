/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rs
 */
public class PrizeTest {
    
    public PrizeTest() {
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
    public void testInit() {
        Prize prize = new Prize("Money");
        Prize prize2 = new Prize();
        System.out.println("Prize: "+ prize2.name + "  Weight: " + prize2.weight);
        
        int exp = 3;
        int act = prize.weight;
        
        assertEquals(exp, act);
    }
    
}
