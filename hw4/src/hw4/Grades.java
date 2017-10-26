/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4;

import java.util.ArrayList;

/**
 *
 * @author rs
 */
public class Grades {
    ArrayList< Double > quizes;
    ArrayList< Double > tests;
    Double quizAvg;
    boolean quizCache = false;
    private final int maxQuizNum= 4;
    Double testAvg;
    boolean testCache = false;
    private final int maxTestNum = 2;
    Double finalGrade;
    boolean finalCache = false;
    char letGrade;
    boolean letCache = false;
    
    Grades (){
        quizes = new ArrayList<Double>();
        tests = new ArrayList < Double > ();
    }
    
    void addQuiz(Double quiz){
        if(quizes.size()< maxQuizNum){
            quizes.add(quiz);
            quizCache = false;
        }
        else{
            throw new IndexOutOfBoundsException("Cannot add more than "+ maxQuizNum +" quizes;");
        }
    }
    void addTest(Double test){
        if(tests.size()<maxTestNum){
            tests.add(test);
            testCache = false;
        }
        else{
            throw new IndexOutOfBoundsException("Cannot add more than "+ maxTestNum +" Tests;");

        }
    }
    
    void setQuizAvg(){
        if(!quizCache){
            quizAvg = quizes.stream().mapToDouble(Double::doubleValue).sum()/quizes.size();
            quizCache = true;
        }
        
    }
    
    Double getQuizAvg(){
        if(!quizCache){
            setQuizAvg();
        }
        return quizAvg;
    }
    
    void setTestAvg(){
        if(!testCache){
            testAvg = tests.stream().mapToDouble(Double::doubleValue).sum()/tests.size();
            quizCache=true;
        }
    }
    
    Double getTestAvg(){
        if(!testCache){
            setTestAvg();
        }
        return testAvg;
    }
    
    void setFinalGrade(){
        if(!finalCache){
            finalGrade = getTestAvg() * .6 + getQuizAvg() * .4 * 100;
        }
    }
    
    double getFinalGrade(){
        if(!finalCache){
            setFinalGrade();
        }
        return finalGrade;
    }
    
    void setLetGrade(){
        if(!letCache){
            setFinalGrade();
            if(finalGrade >= 90) letGrade = 'A';
            else if (finalGrade >=80 && finalGrade <90) letGrade = 'B';
            else if (finalGrade >=70 && finalGrade <80) letGrade = 'C';
            else if (finalGrade >= 60 && finalGrade <70) letGrade = 'D';
            else letGrade = 'F';
            }
     }
    
    char getLetGrade(){
        if(!letCache){
            setLetGrade();
        }
        return letGrade;
    }
    
}
