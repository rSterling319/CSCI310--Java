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
public class Hw3Test {
    
    public Hw3Test() {
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
     * Test of field_init method, of class Hw3.
     */
    @Test
    public void testField_init() {
        System.out.println("field_init");
        int numOfEggs = 10;
        int counted_Eggs=0;
        Hw3 instance = new Hw3();
        boolean[][] result = instance.field_init(numOfEggs);
        for(int i=0; i<10;++i){
            for(int j= 0; j<10; ++j){
                if(result[i][j] == true){
                    counted_Eggs++;
                }
            }
        }
        
        assertEquals(numOfEggs, counted_Eggs);
    }

    /**
     * Test of run method, of class Hw3.
     */
    @Test
    public void testRun() throws Exception {
        System.out.println("run");
        Hw3 instance = new Hw3();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Hw3.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        Hw3.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
