/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author rs
 */
public class Hw3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Hw3 app = new Hw3();
        app.run();
    }
    
    boolean [][] field_init(int numOfEggs){
        if(numOfEggs >100){
           numOfEggs = 100;
        }
        int max = 10;
        int x;
        int y;
        Random randomNum = new Random();
        
        boolean [][] field = new boolean[10][10];
        for(int i=0; i< 10; ++i){
            for(int j = 0; j< 10; ++j){
                field[i][j]= false;
            }
        }
        
        int placed_eggs=0;
        while(placed_eggs< numOfEggs){
            x = randomNum.nextInt(max);
            y = randomNum.nextInt(max);
            if(field[x][y] != true){
                field[x][y] = true;
                placed_eggs++;
            }
        }
        
        return field;
    }
    void run() throws Exception{
        int eggs_hidden = 10;
        boolean[][] field = field_init(eggs_hidden);
        int eggs_found = 0;
        
        Hunter bob = new Hunter("Bob");
        Hunter jane = new Hunter("Jane");
        
        
        while(eggs_found < eggs_hidden){
            if(bob.hunt(field) || jane.hunt(field)){
                eggs_found++;
                System.out.println("Remaining eggs to find: " + (eggs_hidden - eggs_found));
            }
        }
        
        System.out.println(bob.name + " Found " + bob.basket.size() +" Different Easter Eggs");
        System.out.println(jane.name + " Found " + jane.basket.size() +" Different Easter Eggs");
    }
    
}
