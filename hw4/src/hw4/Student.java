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
public class Student {
    
    private String fName;
    private String lName;
    private Long id;
    
    Student(){
        fName = "New";
        lName = "Student";
    }
    Student(String _fName, String _lName, Long _id){
        fName = _fName;
        lName = _lName;
        id = _id;
    }
    
    Student(String _fName, String _lName){
        fName = _fName;
        lName = _lName;
    }
    
    public void set_fName(String _fName){
        fName = _fName;
    }
    
    public void set_lName(String _lName){
        lName = _lName;
    }
    
    public void set_id(Long _id){
        id = _id;
    }
    
    public String getFname(){
        return fName;
    }
    
    public String getLname(){
        return lName;
    }
    
    public long getId(){
        return id;
    }
    
}
