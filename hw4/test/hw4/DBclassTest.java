/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class DBclassTest {
    
    public DBclassTest() {
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
     * Test of getStudent and insertStudent methods, of class DBclass.
     */
    @Test
    public void testGet_InsertStudent() {
        System.out.println("getStudent");
        DBclass db = new DBclass();
        db.reset();
        Student bob = new Student("Bob", "Dole");
        bob.set_id(db.insertStudent(bob));
        String expResult = "Bob Dole";
        String result = db.getStudent(bob.getId());
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getStudentInfoByLast method, of class DBclass.
     */
    @Test
    public void testGetStudentInfoByLast() {
        System.out.println("getStudentInfoByLast");
        String lName = "Dole";
        DBclass db = new DBclass();
        db.reset();
        Student bob = new Student("Bob", "Dole");
        db.insertStudent(bob);
        String expResult = "1 Bob Dole";
        String result = db.getStudentInfoByLast(lName);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getClass and insertClass methods, of class DBclass.
     */
    @Test
    public void testGetInsertClass() {
        System.out.println("get/insertClass");
        long id = 0L;
        DBclass db = new DBclass();
        db.reset();
        String expResult = "History";
        Class history = new Class();
        history.set_title("History");
        history.set_id(db.insertClass(history));
        
        assertEquals(expResult, db.getClass(history.getId()));
        
        
    }

   

    /**
     * Test of getGrade and insertGrades methods, of class DBclass.
     */
    @Test
    public void testGetGrade_InsertGrades() {
        System.out.println("getGrade");
        
        DBclass db = new DBclass();
        String expResult = "A";
        
        Student bob = new Student("Bob", "Dole");
        bob.set_id(db.insertStudent(bob));
        
        Class history = new Class();
        history.set_title("History");
        history.set_id(db.insertClass(history));
        
        
        Grades gradesHist = new Grades();
        gradesHist.addQuiz(90.2);
        gradesHist.addQuiz(87.5);
        gradesHist.addQuiz(94.2);
        gradesHist.addQuiz(84.7);
        gradesHist.addTest(95.3);
        gradesHist.addTest(90.4);
        db.insertGrades(bob, gradesHist, history);
        
        String result = db.getGrade(bob, history);
        assertEquals(expResult, result);
        
    }
    
}
