/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1.Question_2;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author xhu
 */

public class Panel extends JPanel implements KeyListener {
    private Snake snake; // Add a reference to the Snake object
    private char[][] grid; // Add the grid to represent the game area

    public Panel(Snake snake) {
        this.addKeyListener(this);
        this.setFocusable(true);

        this.snake = snake; // Assign the passed Snake object to the panel

        // Initialize the grid
        grid = new char[10][10]; // Adjust the grid size as needed

        // Place letters and numbers randomly on the grid
        // For example:
        // grid[3][4] = 'A';
        // grid[7][2] = '2';
        // ...
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Clear the panel
        g.clearRect(0, 0, getWidth(), getHeight());

        // Render the grid
        int cellSize = getWidth() / grid.length;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] != 0) {
                    g.drawString(String.valueOf(grid[row][col]),
                            col * cellSize + cellSize / 2,
                            row * cellSize + cellSize / 2);
                }
            }
        }

        // Render the snake and other game elements here

        repaint();
    }

    void updateGridWithSnakePosition() {
        // Clear the grid
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                grid[row][col] = 0; // Clear the cell
            }
        }

        // Update the grid with the snake's head position
        grid[snake.getHeadY()][snake.getHeadX()] = 'S'; // Use a suitable character
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        // Handle key typed events
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        // Handle key pressed events to control the snake
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
}