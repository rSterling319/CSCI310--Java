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
public class ClassTest {
    
    public ClassTest() {
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
     * Test of set_title method, of class Class.
     */
    @Test
    public void testSet_AND_Get_title() {
        System.out.println("set_title : get_title");
        String _title = "Art";
        Class instance = new Class();
        instance.set_title(_title);
        assertEquals(instance.getTitle(), _title);
    }

    /**
     * Test of set_id method, of class Class.
     */
    @Test
    public void testSet_AND_Get_id() {
        System.out.println("set_id : get_id");
        Long _id = 12345L;
        Class instance = new Class();
        instance.set_id(_id);
        assertEquals((Long) instance.getId(),(Long) _id);
    }

        
}
