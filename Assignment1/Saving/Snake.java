/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1.Saving;


/**
 *
 * @author xhu
 */

import java.util.LinkedList;

public class Snake {
    private LinkedList<Character> body; // Stores the letters eaten by the snake
    private int length;
    private int headX, headY;

    public LinkedList<Character> getBody() {
        return body;
    }

    public void setBody(LinkedList<Character> body) {
        this.body = body;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeadX() {
        return headX;
    }

    public void setHeadX(int headX) {
        this.headX = headX;
    }

    public int getHeadY() {
        return headY;
    }

    public void setHeadY(int headY) {
        this.headY = headY;
    }

    public int getDirectionX() {
        return directionX;
    }

    public void setDirectionX(int directionX) {
        this.directionX = directionX;
    }

    public int getDirectionY() {
        return directionY;
    }

    public void setDirectionY(int directionY) {
        this.directionY = directionY;
    }

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

