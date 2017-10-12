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
public class Color {
    
    String name;
    int weight;
    ArrayList < String > potential_colors = new ArrayList < String >(Arrays.asList("Red", "Yellow","Blue", "Orange", "Purple"));;
    
    public Color(){       
        Random randInt = new Random();        
        name = potential_colors.get(randInt.nextInt(potential_colors.size()));
        weight = potential_colors.indexOf(name);
    }
    
    public Color(String _name){
        name = _name;
        weight = potential_colors.indexOf(name);
    }
    
}
