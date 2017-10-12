/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author rs
 */
public class Hunter {
    String name;
    Set<Egg> basket = new TreeSet <Egg> ();
    
    public Hunter(String _name){
        name = _name;
    }
    
 
    void collect(){
        Egg egg = new Egg();
        System.out.println(name + " Found "+ egg.contents());
        basket.add(egg);
    }
   
    boolean hunt(boolean [][] field){
        int x, y;

        Random rand = new Random();
        x = rand.nextInt(10);
        y = rand.nextInt(10);

        if(field[x][y] == true){
            collect();
            field[x][y] = false;
            return true;
        }
        else{
            return false;
        }
     
 }
    
    
    
}
