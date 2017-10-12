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
public class ColorTest {
    
    public ColorTest() {
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
        Color color = new Color("Red");
        Color color2 = new Color();
        
        System.out.println("Color: " + color2.name + "   Weight: " + color2.weight);
        
        int exp = 0;
        int act = color.weight;
        
        assertEquals(exp, act);
    }
    
}
