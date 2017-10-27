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
public class GradesTest {

    public GradesTest() {
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
     * Test of addQuiz method, of class Grades.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddQuiz() {
        System.out.println("addQuiz");
        Grades instance = new Grades();

        for (int i = 1; i <= 4; ++i) {
            instance.addQuiz((double) i);
        }
        for (int i = 1; i <= 4; ++i) {
            assertEquals((Double) instance.quizes.get(i - 1), (Double) ((double) i));
        }

        //this should throw IndexOutOfBoundsException
        instance.addQuiz((Double) 95.3);

    }

    /**
     * Test of addTest method, of class Grades.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddTest() {
        System.out.println("addTest");
        Grades instance = new Grades();
        for (int i = 0; i < 2; i++) {
            instance.addTest((double) i);
        }
        for (int i = 0; i < 2; i++) {
            assertEquals((Double) instance.tests.get(i), (Double) (double) i);
        }
        //this should throw IndexOutOfBoundsException 
        instance.addTest((double) 44.8);
    }

    /**
     * Test of setQuizAvg method, of class Grades.
     */
    @Test
    public void test_Set_Get_QuizAvg() {
        System.out.println("set/getQuizAvg");
        Grades instance = new Grades();

        instance.addQuiz(5.0);
        instance.addQuiz(10.0);
        instance.addQuiz(15.0);
        instance.addQuiz(20.0);
        instance.setQuizAvg();
        assertEquals(instance.getQuizAvg(), (Double) ((5.0 + 10.0 + 15.0 + 20.0) / 4));

    }

    /**
     * Test of setTestAvg method, of class Grades.
     */
    @Test
    public void test_Set_Get_TestAvg() {
        System.out.println("set/getTestAvg");
        Grades instance = new Grades();
        instance.addTest(10.0);
        instance.addTest(20.0);
        instance.setTestAvg();
        assertEquals(instance.getTestAvg(), (Double) 15.0);

    }

    @Test
    public void test_Set_Get_FinalGrade() {
        System.out.println("set/getFinalGrade");
        Grades instance = new Grades();
        for (int i = 0; i < 4; ++i) {
            instance.addQuiz(100.0);
            if (i < 2) {
                instance.addTest(100.0);
            }
        }
        instance.setFinalGrade();
        
        assertEquals((Double) instance.getFinalGrade(), (Double) 100.0);
    }

    
    
    /**
     * Test of setLetGrade method, of class Grades.
     */
    @Test
    public void test_Set_Get_LetGrade() {
        System.out.println("set/getLetGrade");
        Grades instance = new Grades();
        for (int i = 0; i < 4; ++i) {
            instance.addQuiz(100.0);
            if (i < 2) {
                instance.addTest(100.0);
            }
        }
        instance.setLetGrade();
        assertEquals(instance.getLetGrade(), "A");
    }

    

}
