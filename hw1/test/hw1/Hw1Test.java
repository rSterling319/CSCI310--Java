/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1;

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
public class Hw1Test {
    
    public Hw1Test() {
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
     * Test of getVolume method, of class Hw1.
     */
    @Test
    public void testGetVolume() {
        System.out.println("getVolume");
        double radius = 0.0;
        double height = 0.0;
        Hw1 instance = new Hw1();
        double expResult = 0.0;
        double result = instance.getVolume(radius, height);
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Test of getVolume method, of class Hw1.
     */
    @Test
    public void testGetVolume1() {
        System.out.println("getVolume1");
        double radius = 5.0;
        double height = 2.0;
        Hw1 instance = new Hw1();
        double expResult = 52.35987756;
        double result = instance.getVolume(radius, height);
        assertEquals(expResult, result, 10e-5);
    }
    
    @Test
    public void testGetVolumeIceCreamCone() {
        System.out.println("getVolumeIceCreamCone");
        double radius = 40.0;
        double height = 78.0;
        Hw1 instance = new Hw1();
        double expResult = 130690.2544;
        double result = instance.getVolume(radius, height);
        assertEquals(expResult, result, 10e-3);
    }
    
}
