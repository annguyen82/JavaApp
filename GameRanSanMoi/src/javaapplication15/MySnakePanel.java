/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication15;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author nghia
 */
public class MySnakePanel extends JPanel{
    
    public MySnakePanel(int map){
        System.out.println(map);
        food = false;
        foodColor = false;
        isLose = false;
        scores = 0;
        this.setBackground(Color.black);
        matrix = new int[MyStaticVar.Y/MyStaticVar.sizeCell][MyStaticVar.X/MyStaticVar.sizeCell];
 
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[i].length; j++)
            {
                if(i == 0) {
                    matrix[i][j] = 1;
                }
                else if(i == matrix.length - 1) {
                    matrix[i][j] = 1;
                }
                else if(j == 0) {
                    matrix[i][j] = 1;
                }
                else if(j == matrix[i].length - 1) {
                    matrix[i][j] = 1;
                }
                else {
                    matrix[i][j] = 0;
                }
             }
        }
        if(map == 1){
            int a = 10;
            int b = matrix.length - 10;;
            for(int j = 11; j < matrix[0].length - 11; j++){
                matrix[a][j] = 1;
                matrix[b][j] = 1;
            }
  
        }
        else if(map == 2){
            int a = 10;
            int b = matrix.length - 10;;
            for(int j = 12; j < matrix[0].length - 12; j++){
                matrix[a][j] = 1;
                matrix[b][j] = 1;
            }
            for(int i = a; i <= b; i++){
                for(int j = 5; j < 8; j++){
                    matrix[i][matrix[0].length - j] = 1;
                    matrix[i][j] = 1;
                }
            }
            
        }
        sn = new Snake();
        for(int i = 0; i < sn.getLength(); i++){
            matrix[sn.getPoint(i).getX()][sn.getPoint(i).getY()] = 2;
        }
                
        d = 1;
        
       
    }
    public void setMatrix(int i, int j, int num){
        matrix[i][j] = num;
    }
    public int getMatrix(int i, int j){
        return matrix[i][j];
    }
    public void setD(int d){
        this.d = d;
    }
    public int getD(){
        return this.d;
    }
    @Override
    @SuppressWarnings("empty-statement")
    protected void paintComponent(Graphics g){
        
        super.paintComponent(g);
        if(scores == 100){
            isLose = true;
        }
        if(!isLose){
            Point p = new Point(0, 0);

            for(int i = sn.getLength(); i > 0; i--){
                // point thứ i bằng point thứ i-1
                p = sn.getPoint(i-1);
                sn.setPoint(i, p);
                matrix[sn.getPoint(i).getX()][sn.getPoint(i).getY()] = 2; 
            }
            // xét point đầu tiên của snake
            if(d == 1){
                p.setX(sn.getPoint(0).getX());
                p.setY(sn.getPoint(0).getY() + 1);
                sn.setPoint(0, p);
            }
            else if(d == 2){
                p.setX(sn.getPoint(0).getX());
                p.setY(sn.getPoint(0).getY() - 1);
                sn.setPoint(0, p);
            }
            else if(d == 3){
                p.setX(sn.getPoint(0).getX() + 1);
                p.setY(sn.getPoint(0).getY());
                sn.setPoint(0, p);
            }
            else if(d == 4){
                p.setX(sn.getPoint(0).getX() - 1);
                p.setY(sn.getPoint(0).getY());
                sn.setPoint(0, p);
            }
            if(matrix[sn.getPoint(0).getX()][sn.getPoint(0).getY()] == 3){

                // nếu vị trí đầu của snake là thức ăn
                sn.setLength(sn.getLength() + 1); // tăng chiều dài snake lên 1
                matrix[sn.getPoint(0).getX()][sn.getPoint(0).getY()] = 2;
                food = false;
                scores++;
            }
            else if(matrix[sn.getPoint(0).getX()][sn.getPoint(0).getY()] == 0){
                // nếu là 0 thì cho phép di,  xóa vị trí cuối của snake
                matrix[sn.getPoint(sn.getLength()).getX()][sn.getPoint(sn.getLength()).getY()] = 0;
            }
            else if(matrix[sn.getPoint(0).getX()][sn.getPoint(0).getY()] == 2 || matrix[sn.getPoint(0).getX()][sn.getPoint(0).getY()] == 1){
                isLose = true;
            }

            matrix[sn.getPoint(0).getX()][sn.getPoint(0).getY()] = 2; // vị trí đầu tiên của snake

            if(!food){
                // tạo vị trí ngẫu nhiên của thức ăn
                Random rd = new Random();

                int randomX = rd.nextInt(matrix.length);
                int randomY = rd.nextInt(matrix[0].length);
                if(matrix[randomX][randomY] != 0){
                    outerloop:
                    for(int i = 0; i < matrix.length; i++){
                        for(int j = 0; j < matrix[i].length; j++){
                            if(matrix[i][j] == 0){   
                                matrix[i][j] = 3;
                                break outerloop; 
                            }
                        }
                    }
                }
                else{
                    matrix[randomX][randomY] = 3;
                }
                food = true;
            }

            // vẽ trên panel dựa trên ma trận
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length; j++){
                    if(matrix[i][j] == 1){
                        g.setColor(Color.red);  
                        g.fill3DRect(j * MyStaticVar.sizeCell, i * MyStaticVar.sizeCell, MyStaticVar.sizeCell, MyStaticVar.sizeCell, true);
                    } 
                    else if(matrix[i][j] == 2){
                        g.setColor(Color.GREEN);  
                        g.fill3DRect(j * MyStaticVar.sizeCell, i * MyStaticVar.sizeCell, MyStaticVar.sizeCell, MyStaticVar.sizeCell, true);
                    }
                    else if(matrix[i][j] == 3){
                        if(foodColor){
                            g.setColor(Color.CYAN); 
                        }
                        else{
                            g.setColor(Color.blue); 
                        }
                        foodColor = !foodColor;
                        g.fill3DRect(j * MyStaticVar.sizeCell, i * MyStaticVar.sizeCell, MyStaticVar.sizeCell, MyStaticVar.sizeCell, true);
                    }
                 }
            }
            
            g.setColor(Color.LIGHT_GRAY);
            Font font = new Font("Book Antiqua", Font.PLAIN, 35);
            g.setFont(font);
            char [] data = {'S', 'c', 'o', 'r', 'e', 's'};
            g.drawChars(data, 0, data.length, MyStaticVar.X + 30, 40);
            String s = scores + " / " + MyStaticVar.maxLengthSnake;
            data = s.toCharArray();
            g.setColor(Color.MAGENTA);
            g.drawChars(data, 0, data.length, MyStaticVar.X + 30, 80);
            
        }
        else{
            g.setColor(Color.red);
            Font font = new Font("Book Antiqua", Font.PLAIN, 60);
            g.setFont(font);
            char [] data = {'G', 'a', 'm', 'e', ' ', ' ', 'O', 'v', 'e', 'r'};
            g.drawChars(data, 0, data.length, 100, 100);
            
            g.setColor(Color.LIGHT_GRAY);
            font = new Font("Book Antiqua", Font.PLAIN, 40);
            g.setFont(font);
            String s = "Scores";
            data = s.toCharArray();
            g.drawChars(data, 0, data.length, 100, 190);
            s = scores + " / " + MyStaticVar.maxLengthSnake;
            data = s.toCharArray();
            g.setColor(Color.MAGENTA);
            g.drawChars(data, 0, data.length, 100, 240);
        }
    }
    
    private int matrix[][];
    private int d; // 1 là từ trái qua phải, 2 là từ phải qua trái, 3 là từ trên xuống dưới, 4 là từ dưới lên trên
    private Snake sn;
    private boolean food; // true là có thức ăn, false là không có
    private boolean foodColor; // dùng để thay đổi màu sắc cho thức ăn
    private boolean isLose; // true là thua
    private int scores;
}