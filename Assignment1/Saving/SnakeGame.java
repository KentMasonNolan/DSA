/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1.Saving;

import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author xhu
 */
public class SnakeGame {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize the Snake object and the Panel
        Snake snake = new Snake(5, 5); // Initialize snake at position (5, 5)
        Panel panel = new Panel(snake); // Pass the Snake object to the Panel

        frame.getContentPane().add(panel);
        frame.setSize(500, 500);
        frame.setVisible(true);

        // Add a KeyListener to the panel for controlling the snake
        panel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                // Handle key typed events
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                char keyChar = ke.getKeyChar();

                if (keyChar == 'w') {
                    snake.changeDirection(0, -1); // Up
                } else if (keyChar == 'a') {
                    snake.changeDirection(-1, 0); // Left
                } else if (keyChar == 's') {
                    snake.changeDirection(0, 1); // Down
                } else if (keyChar == 'd') {
                    snake.changeDirection(1, 0); // Right
                }

                // Implement other controls if needed
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                // Handle key released events
            }
        });



        // Start the game loop
        new Thread(() -> {
            while (true) {
                snake.move(); // Move the snake
                panel.updateGridWithSnakePosition(); // Update grid with snake's position
                panel.repaint(); // Update the panel to repaint

                try {
                    Thread.sleep(100); // Adjust the delay for the desired game speed
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}