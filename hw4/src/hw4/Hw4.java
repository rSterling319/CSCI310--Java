/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4;



/**
 *
 * @author rs
 */
public class Hw4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Hw4 app = new Hw4();
        app.run();
    }
    
    private void run() {
        DBclass db = new DBclass();
        db.reset();
        Student bob = new Student("Bob", "Dole");
        bob.set_id(db.insertStudent(bob));
        
        Class history = new Class();
        history.set_title("History");
        history.set_id(db.insertClass(history));
        
        Grades grades = new Grades();
        grades.addQuiz(90.2);
        grades.addQuiz(87.5);
        grades.addQuiz(94.2);
        grades.addQuiz(84.7);
        grades.addTest(95.3);
        grades.addTest(90.4);
        
        db.insertGrades(bob, grades, history);
        
        System.out.println(db.getStudent(bob.getId()));
        System.out.println(bob.getId());
        System.out.println(db.getStudentInfoByLast("Dole"));
        System.out.println(db.getClass(history.getId()));
        System.out.println(history.getId());
        System.out.println(db.getGrade(bob, history));
    }

}
