/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2.maze;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Kent
 */
public class MazeApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame window = new JFrame("Maze");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel mainPanel = new Panel();
        window.add(mainPanel);
        window.setSize(700, 600);
        window.setVisible(true);
        window.setResizable(false);
    }

}
