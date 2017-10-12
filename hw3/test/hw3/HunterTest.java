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
public class HunterTest {
    
    public HunterTest() {
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


    /**
     * Test of hunt method, of class Hunter.
     */
    @Test
    public void testHunt() {
        System.out.println("hunt");
        Hunter bob = new Hunter("Bob");
        
        boolean [][] test_field = new boolean[10][10];
        for(int i=0; i< 10; ++i){
            for(int j = 0; j< 10; ++j){
                test_field[i][j]= false;
            }
        }
        
        boolean exp = false;
        boolean res = bob.hunt(test_field);
        assertEquals(exp, res);
        
        for(int i=0; i< 10; ++i){
            for(int j = 0; j< 10; ++j){
                test_field[i][j]= true;
            }
        }
        exp = true;
        res = bob.hunt(test_field);
        assertEquals(exp,res);
    }

    /**
     * Test of collect method, of class Hunter.
     */
    @Test
    public void testCollect() {
        System.out.println("collect");
        Hunter bob = new Hunter("Bob");
        bob.collect();
        
        int expt = 1;
        int result = bob.basket.size();
        
        assertEquals(expt, result);

    }
    
}
