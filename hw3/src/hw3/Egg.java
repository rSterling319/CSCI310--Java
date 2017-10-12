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


public class Egg implements EasterEgg{
    Color color;
    Prize prize;
    int weight;
    
    
    public Egg(){
        color = new Color();
        prize = new Prize();
        weight = color.weight + prize.weight;
    }
    public Egg(String _color, String _prize){
        color = new Color(_color);
        prize = new Prize(_prize);
        weight = color.weight + prize.weight;
    }
    
    @Override
    public String contents(){
        return color.name +" egg with " + prize.name +" prize!";
    }

    
    
    @Override
    public int compareTo(EasterEgg to) {
        if(to instanceof Egg){
            Egg egg = (Egg) to;
            if(weight  > egg.weight) return 1;
            if(weight < egg.weight) return -1;
            return 0;
         
        }
        else{
            return this.getClass().getName().compareTo(to.getClass().getName());
        }
    }
    
    @Override
    public boolean equals(Object o){
        return compareTo((EasterEgg) o) ==0;
    }
   
    
    
}
