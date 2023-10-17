/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment2.maze;

/**
 *
 * @author Kent
 */
public class Node {

    public String identifier;
    public int posX;
    public int posY;
    public String leftNodeName;
    public String rightNodeName;
    public Node leftConnection;
    public Node rightConnection;
    public Node prior;

    public Node() {
        this.identifier = null;
        this.posX = 0;
        this.posY = 0;
        this.leftNodeName = null;
        this.rightNodeName = null;
        this.leftConnection = null;
        this.rightConnection = null;
        this.prior = null;
    }

    public Node(String identifier, int posX, int posY, String leftNodeName, String rightNodeName) {
        this.identifier = identifier;
        this.posX = posX;
        this.posY = posY;
        this.leftNodeName = leftNodeName;
        this.rightNodeName = rightNodeName;
        this.leftConnection = null;
        this.rightConnection = null;
        this.prior = null;
    }
}

