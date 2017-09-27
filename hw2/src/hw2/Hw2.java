/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;

import java.util.Scanner;

/**
 *
 * @author rs
 */
public class Hw2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Hw2 app = new Hw2();
        app.run();
    }
    
    int x, y;
    void readInput(Scanner in){
        x = in.nextInt();
        y = in.nextInt();
        
        if((x<-1000 || x>1000) || x == 0){
            throw new IllegalStateException("Invalid value of x: " + x);
        }
        if((y<-1000 || y>1000)|| y == 0){
            throw new IllegalStateException("Invalid value of y: "+y);
        }
    }
    
    int solveProblem(){
        if(x>0 && y>0){
            return 1;
        }
        else if(x<0 && y >0){
            return 2;
        }
        else if(x<0 && y <0){
            return 3;
        }
        else{
            return 4;
        }
    }
    
    void writeOutput(){
        System.out.println(solveProblem());
    }
    
    void readInput(){
        Scanner in = new Scanner(System.in);
        readInput(in);
    }
    private void run() throws Exception {
        
        readInput();
        solveProblem();
        writeOutput();
    }
    
}
