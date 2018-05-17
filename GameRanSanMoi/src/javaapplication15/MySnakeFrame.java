/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication15;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author nghia
 */
public class MySnakeFrame implements KeyListener{
    
    private JFrame jf;
    private MySnakePanel tp;

    public MySnakeFrame(int map, int speed){
        tp = new MySnakePanel(map);
        jf = new JFrame("Java Snake");
        jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jf.setSize(MyStaticVar.X + 180, MyStaticVar.Y + 150);
        jf.setContentPane(tp);
        jf.setVisible(true);
        jf.addKeyListener(this);

        while(true){
            tp.repaint();
            try {
                Thread.currentThread().sleep(speed);
            } catch (InterruptedException ex) {
                Logger.getLogger(MySnakeFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && tp.getD() != 2){
            tp.setD(1);
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT && tp.getD() != 1){
            tp.setD(2);
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN && tp.getD() != 4){
            tp.setD(3);
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP && tp.getD() != 3){
            tp.setD(4);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    
}
