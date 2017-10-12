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
    String color;
    String prize;
    ArrayList < String > potential_colors;
    ArrayList < String > potential_prizes;
    
    public Egg(){
        Random randInt = new Random();
        potential_colors = new ArrayList < String >(Arrays.asList("Red", "Yellow","Blue", "Orange", "Purple"));
        potential_prizes = new ArrayList < String >(Arrays.asList("Money", "Reeses", "Skittles", "Rock"));
        color = potential_colors.get(randInt.nextInt(5));
        prize = potential_prizes.get(randInt.nextInt(4));
    }
    public Egg(String _color, String _prize){
        color = _color;
        prize = _prize;
    }
    
    @Override
    public String contents(){
        return color +" egg with " + prize +" prize!";
    }

    //This was a bad idea! oh well!
    @Override
    public int compareTo(EasterEgg to) {
        if(to instanceof Egg){
            Egg egg = (Egg) to;
            if(prize == "Money" && egg.prize != "Money") return 1;
            if(prize!= "Money" && egg.prize == "Money") return -1;
            if(prize == "Reeses" && egg.prize != "Reeses") return 1;
            if(prize!= "Reeses" && egg.prize == "Reeses") return -1;
            if(prize == "Skittles" && egg.prize != "Skittles") return 1;
            if(prize!= "Skittles" && egg.prize == "Skittles") return -1;
            if(prize == "Rock" && egg.prize != "Rock") return 1;
            if(prize!= "Rock" && egg.prize == "Rock") return -1;
            if(color == "Red" && egg.color != "Red")return 1;
            if(color != "Red" && egg.color == "Red")return 1;
            if(color == "Purple" && egg.color != "Purple")return 1;
            if(color != "Purple" && egg.color == "Purple")return 1;
            if(color == "Blue" && egg.color != "Blue")return 1;
            if(color != "Blue" && egg.color == "Blue")return 1;
            if(color == "Yellow" && egg.color != "Yellow")return 1;
            if(color != "Yellow" && egg.color == "Yellow")return 1;
            if(color == "Orange" && egg.color != "Orange")return 1;
            if(color != "Orange" && egg.color == "Orange")return 1;
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
