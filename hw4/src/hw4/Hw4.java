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
        
        Class art =new Class();
        art.set_title("Art");
        art.set_id(db.insertClass(art));
        
        Grades gradesHist = new Grades();
        gradesHist.addQuiz(90.2);
        gradesHist.addQuiz(87.5);
        gradesHist.addQuiz(94.2);
        gradesHist.addQuiz(84.7);
        gradesHist.addTest(95.3);
        gradesHist.addTest(90.4);
        db.insertGrades(bob, gradesHist, history);
        
        Grades gradesArt = new Grades();
        gradesArt.addQuiz(67.8);
        gradesArt.addQuiz(72.9);
        gradesArt.addQuiz(23.8);
        gradesArt.addQuiz(80.7);
        gradesArt.addTest(69.8);
        gradesArt.addTest(72.1);
        db.insertGrades(bob, gradesArt, art);
        
        System.out.println(db.getStudent(bob.getId()));
        System.out.println(bob.getId());
        System.out.println(db.getStudentInfoByLast("Dole"));
        System.out.println(db.getClass(history.getId()));
        System.out.println(history.getId());
        System.out.println("History Grade = " + db.getGrade(bob, history));
        System.out.println("Art Grade = " + db.getGrade(bob, art));
    }

}
