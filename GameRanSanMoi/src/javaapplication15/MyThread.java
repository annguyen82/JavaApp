/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication15;

/**
 *
 * @author nghia
 */
public class MyThread implements Runnable {

    private int map;
    private int speed;
    public void setMap(int map){
        this.map = map;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    @Override
    public void run() {
        new MySnakeFrame(map, speed);
    }
    
}
