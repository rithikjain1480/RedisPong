package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by rithikjain on 12/4/16.
 */
public class Board extends JComponent {

    private static int bx,by;
    private int py1, py2;
    private static Rectangle2D.Double paddle1, paddle2;
    private static Ellipse2D.Double ball;

    Board(int bx, int by, int py1, int py2){
        this.bx = bx;
        this.by = by;
        this.py1 = py1;
        this.py2 = py2;
    }

    public void update(int bx, int by, int py1, int py2){
        this.bx = bx;
        this.by = by;
        this.py1 = py1;
        this.py2 = py2;
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;//creates a new Graphics2D object, and casts it b/c u are going from higher to lower dependency
        ball = new Ellipse2D.Double(bx, by, 25, 25);//creates a new ball, uses the instance field variables specified by the user
        g2.setColor(Color.black);
        g2.fill(ball);//fills the ball in the graphics2d object
        paddle1 = new Rectangle2D.Double(25, py1, 20, 100);//creates a new paddle, uses the instance field variables specified by the user
        g2.setColor(Color.black);
        g2.fill(paddle1);//fills the paddle in the graphics2d object
        paddle2 = new Rectangle2D.Double(655, py2, 20, 100);//creates a new paddle, uses the instance field variables specified by the user
        g2.setColor(Color.black);
        g2.fill(paddle2);//fills the paddle in the graphics2d object
    }

}
