/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2.maze;

public class Node {

    private String name;
    private int x;
    private int y;
    private Node left;
    private Node right;

    public Node(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.left = null;
        this.right = null;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setVisited(boolean b) {
    }

//    public Node[] getNeighbors() {
//    }

//    public boolean isVisited() {
//    }

    public void addNeighbor(Node node) {
    }
}
