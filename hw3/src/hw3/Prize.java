/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author rs
 */
public class Prize {
    String name;
    int weight;
    ArrayList < String > potential_prizes = new ArrayList < String >(Arrays.asList("Rock", "Skittles","Reeses" , "Money"));;
    
    public Prize(){
        Random randInt = new Random();
        name = potential_prizes.get(randInt.nextInt(potential_prizes.size()));
        weight = potential_prizes.indexOf(name);
        
    }
    
    public Prize(String _name){
        name = _name;
        weight = potential_prizes.indexOf(name);
    }
}
