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
public class EggTest {
    
    public EggTest() {
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
     * Test of contents method, of class Egg.
     */
    @Test
    public void testContents() {
        System.out.println("contents");
        Egg instance = new Egg("Red", "Money");
        Egg instance1 = new Egg();
        
        assertEquals(instance.color, "Red");
        assertEquals(instance.prize, "Money");
        System.out.println(instance1.contents());
        
    }

    /**
     * Test of compareTo method, of class Egg.
     */
    @Test
    public void testCompareTo() {
        // instance < to
        System.out.println("compareTo");
        Egg to = new Egg("Red", "Money"); // 0 + 3
        Egg instance = new Egg("Purple","Skittles"); // 4 +1
        int expResult = 1;
        int result = instance.compareTo(to);
//        instance > to
        assertEquals(expResult, result);
        
        
        //equals
        EasterEgg to2 = new Egg("Red", "Money");
        Egg instance2 = new Egg("Red","Money");
        int expResult2 = 0;
        int result2 = instance2.compareTo(to2);
        assertEquals(expResult2, result2);
        
        
    }

    /**
     * Test of equals method, of class Egg.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Egg instance = new Egg();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
