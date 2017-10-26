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
        
        System.out.println(db.getStudent(bob.getId()));
    }

}
