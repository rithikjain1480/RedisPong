package com.company;

/**
 * Created by rithikjain on 12/4/16.
 */

import java.awt.geom.*;
import java.awt.Color;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
//imports all neccessary components

public class Ball extends JComponent {

    // instance variables - replace the example below with your own
    private static int x,y,radius;
    private static double dx,dy;
    private static Paddle p1, p2;
    private static Ellipse2D.Double ball;
    private static Color c;//instance field variables for the Ball class

    public Ball(int x, int y, int radius, Paddle p1, Paddle p2){//the explicit parameters for the BAll constructor
        this.x = x;
        this.y = y;
        this.radius = radius;
        dx = (Math.random()*6) +5;
        dy = (Math.random()*6) +5;
        this.p1 = p1;
        this.p2 = p2;
    }

    public void paintComponent(Graphics g){//necessary overriden method, the result of extending JFrame
        Graphics2D g2 = (Graphics2D) g;//creates a new Graphics2D object, and casts it b/c u are going from higher to lower dependency
        ball = new Ellipse2D.Double(x, y, radius, radius);//creates a new ball, uses the instance field variables specified by the user
        g2.setColor(Color.black);
        g2.fill(ball);//fills the ball in the graphics2d object
    }

    public void move(){
        repaint();//repaints the frame and also adds to the speed that the ball is moving in
        x+=dx;
        y+=dy;

        if(x<=p1.getX()+p1.getW() && y>=p1.getY() && y<=p1.getY()+p1.getH()){
            dx +=0.3;
            dx = -dx;
        } else if(x>=p2.getX()-radius && y>=p2.getY() && y<=p2.getY()+p2.getH()){
            dx +=0.3;
            dx = -dx;
        }

        if(y<=0){
            dy +=0.3;
            dy = -dy;
        } else if(y>=650){
            dy +=0.3;
            dy = -dy;
        }
    }

    public static int getx(){return x;}
    public static int gety(){return y;}
    public static int getRadius(){return radius;}


}
