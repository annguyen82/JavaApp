/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication15;

/**
 *
 * @author nghia
 */
public class Snake {
    private int length;
    private Point[] point;
    public Snake(){
        length = 3;
        point = new Point[MyStaticVar.maxLengthSnake];
        for(int i = 0; i < MyStaticVar.maxLengthSnake; i++){
            point[i] = new Point(0, 0);
        }
        
        point[0].setX(MyStaticVar.Y/MyStaticVar.sizeCell/2);
        point[0].setY(MyStaticVar.X/MyStaticVar.sizeCell/2 + 1);
        
        point[1].setX(MyStaticVar.Y/MyStaticVar.sizeCell/2);
        point[1].setY(MyStaticVar.X/MyStaticVar.sizeCell/2);
        
        point[2].setX(MyStaticVar.Y/MyStaticVar.sizeCell/2);
        point[2].setY(MyStaticVar.X/MyStaticVar.sizeCell/2 - 1);
    }
    
    public int getLength(){
        return length;
    }
    public void setLength(int length){
        this.length = length;
    }
    public Point getPoint(int i){
        return point[i];
    }
    public void setPoint(int i, Point p){
        this.point[i].setX(p.getX());
        this.point[i].setY(p.getY());
    }
}
