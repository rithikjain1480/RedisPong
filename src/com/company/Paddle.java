package com.company;

import redis.clients.jedis.Jedis;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by rithikjain on 12/4/16.
 */
public class Paddle extends JComponent{

    private int x, y, w, h, player;
    private static Color color;
    private static Rectangle2D.Double paddle;

    Paddle(int x, int y, int w, int h, Color color, int player){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
        this.player = player;
    }

    public static Jedis jedis = new Jedis("127.0.0.1");

    public void paintComponent(Graphics g){//necessary overriden method, the result of extending JFrame
        Graphics2D g2 = (Graphics2D) g;//creates a new Graphics2D object, and casts it b/c u are going from higher to lower dependency
        paddle = new Rectangle2D.Double(x, y, w, h);//creates a new paddle, uses the instance field variables specified by the user
        g2.setColor(Color.black);
        g2.fill(paddle);//fills the paddle in the graphics2d object
    }

    public void move() {
        if (player==1) {
            if (y <= 0) {
                y += 1;
                return;
            }
            if (y >= 600) {
                y -= 1;
                return;
            }
            repaint();//repaints the frame and also adds to the speed that the ball is moving in
            String x = jedis.lindex("list", 0);
            int value = Integer.parseInt(x);
            if (value > 0) {
                y -= 10;
            } else if (value < 0) {
                y += 10;
            }
        } else if (player==2) {
            if (y <= 0) {
                y += 1;
                return;
            }
            if (y >= 600) {
                y -= 1;
                return;
            }
            repaint();//repaints the frame and also adds to the speed that the ball is moving in
            String x = jedis.lindex("list", 1);
            int value = Integer.parseInt(x);
            if (value > 0) {
                y -= 10;
            } else if (value < 0) {
                y += 10;
            }
        }
    }
    public int getX(){return x;}
    public int getY(){return y;}
    public int getW(){return w;}
    public int getH(){return h;}

}