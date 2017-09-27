/*
 * Richard Sterling
 * CSCI 310--Java
 * HW2-TEST Kattis problem https://open.kattis.com/problems/quadrant
 */
package hw2;

import java.util.Scanner;
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
public class Hw2Test {
    
    public Hw2Test() {
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
     * Test of main method, of class Hw2.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        Hw2.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of readInput method, of class Hw2.
     */
    @Test
    public void testReadInput_Scanner() {
        System.out.println("readInput");
        Scanner in = new Scanner("10\n"+"6");
        Hw2 app = new Hw2();
        app.readInput(in);
        
        assertEquals(10, app.x);
        assertEquals(6, app.y);
    }
    
     @Test
    public void testReadInput_Scanner2() {
        System.out.println("readInput");
        Scanner in = new Scanner("9\n"+"-13");
        Hw2 app = new Hw2();
        app.readInput(in);
        
        assertEquals(9, app.x);
        assertEquals(-13, app.y);
    }

    /**
     * Test of solveProblem method, of class Hw2.
     */
    @Test
    public void testSolveProblem() {
        System.out.println("solveProblem");
        Scanner in = new Scanner("10\n"+"6");
        Hw2 app = new Hw2();
        app.readInput(in);
        int expResult = 1;
        int result = app.solveProblem();
        assertEquals(expResult, result);
        
    }
    
     @Test
    public void testSolveProblem2() {
        System.out.println("solveProblem");
        Scanner in = new Scanner("9\n"+"-13");
        Hw2 app = new Hw2();
        app.readInput(in);
        int expResult = 4;
        int result = app.solveProblem();
        assertEquals(expResult, result);
        
    }

    
    
}
