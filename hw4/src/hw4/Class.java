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
public class Class {
    
    String title;
    Long id;
    
    public void set_name(String _title){
        title = _title;
    }
    
    public void set_id(Long _id){
        id = _id;
    }
    
    public String getTitle(){
        return title;
    }
    
    public long getId(){
        return id;
    }
    
}
