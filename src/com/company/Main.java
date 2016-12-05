package com.company;

import javax.swing.*;
import java.awt.*;

public class Main{

    private static JFrame frame = new JFrame("Pong");
    private static boolean gameOver = false;

    public static void main(String[] args) {

        Paddle p1 = new Paddle(25, 300, 20, 100, Color.black,1);
        Paddle p2 = new Paddle(655, 300, 20, 100, Color.black,2);
        Ball b = new Ball(400,300,25, p1, p2);

        Board board = new Board(Ball.getx(), Ball.gety(),p1.getY(),p2.getY());

        frame.add(board);
        frame.setSize(700,700);
        frame.setVisible(true);

        while(!gameOver){
            b.move();
            p1.move();
            p2.move();
            if(b.getx()<-10 || b.getx()>700-b.getRadius()){
                gameOver=true;
                JLabel label = new JLabel("Game Over!");
                label.setBounds(250, 325, 250, 50);
                label.setFont(new Font("Serrif", Font.PLAIN, 36));
                board.add(label);
            }
            board.update(Ball.getx(), Ball.gety(),p1.getY(),p2.getY());
            frame.repaint();
            try {
                Thread.sleep(35);
            } catch (Exception e) {

            }

        }
    }
}

