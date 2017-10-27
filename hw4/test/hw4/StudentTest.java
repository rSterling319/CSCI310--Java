/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4;

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
public class StudentTest {
    
    public StudentTest() {
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
     * Test of set/get_fName method, of class Student.
     */
    @Test
    public void testSetGET_fName() {
        System.out.println("set/get_fName");
        String _fName = "Bob";
        Student instance = new Student();
        instance.set_fName(_fName);
        
        assertEquals(instance.getFname(), _fName);
    }

    /**
     * Test of set/get_lName method, of class Student.
     */
    @Test
    public void testSet_get_lName() {
        System.out.println("set/get_lName");
        String _lName = "Dole";
        Student instance = new Student();
        instance.set_lName(_lName);
        
        assertEquals(instance.getLname(), _lName);
    }

    /**
     * Test of set/get_id method, of class Student.
     */
    @Test
    public void testSet_get_id() {
        System.out.println("set/get_id");
        Long _id = 45L;
        Student instance = new Student();
        instance.set_id(_id);
        
        assertEquals((Long) instance.getId(), (Long) _id);
    }

    
}
