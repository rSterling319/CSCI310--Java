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
public class EasterEggTest {
    
    public EasterEggTest() {
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
     * Test of contents method, of class EasterEgg.
     */
    @Test
    public void testContents() {
        System.out.println("contents");
        EasterEgg instance = new EasterEggImpl();
        String expResult = "";
        String result = instance.contents();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class EasterEggImpl implements EasterEgg {

        public String contents() {
            return "";
        }
    }
    
}
