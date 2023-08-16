/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1.Question_2;

import javax.swing.JFrame;

/**
 * @author xhu
 */
public class SnakeGame {

    /**
     * @param args the command line arguments
     */


    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel panel = new Panel();

        frame.getContentPane().add(panel);
        frame.setSize(500, 500);
        frame.setVisible(true);

        Snake snake = new Snake(5, 5); // Initialize snake at position (5, 5)

        // Game loop
        while (true) {
            snake.move(); // Move the snake

            // Update the panel to repaint
            panel.repaint();

            try {
                Thread.sleep(100); // Adjust the delay for the desired game speed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
