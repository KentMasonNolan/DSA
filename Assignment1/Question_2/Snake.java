/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1.Question_2;


/**
 *
 * @author xhu
 */

import java.util.LinkedList;

public class Snake {
    private LinkedList<Character> body; // Stores the letters eaten by the snake
    private int length;
    private int headX, headY;
    private int directionX, directionY;

    public Snake(int x, int y) {
        body = new LinkedList<>();
        length = 1;
        headX = x;
        headY = y;
        directionX = 1; // Initial direction (right)
        directionY = 0;
    }

    public void changeDirection(int newDirX, int newDirY) {
        // Avoid 180-degree turns (prevent moving directly back)
        if (directionX != -newDirX && directionY != -newDirY) {
            directionX = newDirX;
            directionY = newDirY;
        }
    }

    public void move() {
        headX += directionX;
        headY += directionY;
    }

    public boolean collidesWith(int x, int y) {
        return headX == x && headY == y;
    }

    public void eatLetter(char letter) {
        body.addLast(letter);
        length++;
    }

    public void dropLetter(int value) {
        if (value < body.size()) {
            body.remove(value);
            length--;
        }
    }

    public void handleCollision(int value) {
        if (value >= 0 && value < body.size()) {
            dropLetter(value);
        } else {
            // Implement game over logic here
        }
    }
}

