/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1;

/**
 *
 * @author Richard Sterling
 * 
 * This program finds the volume of a cone given a radius and a height using 
 * the formula:
 *              V= 1/3 pi r^2 h
 */
public class Hw1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Hw1 app = new Hw1();
        app.run();
    }
    
    void run(){
        double radius = 1.0;
        double height = 3.0;
        double volume = getVolume(radius, height);
        System.out.println("Volume of a cone with radius: " + radius + " and height: " + height + " is " + volume);
    }
    
    double getVolume(double radius, double height){
        double volume = .333333333333 * height * Math.pow(radius, 2.0) * Math.PI;
        return volume;
    }
    
}
