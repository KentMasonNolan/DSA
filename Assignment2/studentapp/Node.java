/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2.studentapp;

/**
 *
 * @author xhu
 */
public class Node <E, F extends Comparable> implements Comparable <Node>{


    public E element;
    F key;
    public Node left;
    public Node right;

    @Override
    public String toString() {
        return "Node{" +
                "element=" + element +
                ", key=" + key +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public Node(E element, F key) {
        this.element = element;
        this.key = key;
        this.left = null;
        this.right = null;
    }

    @Override
    public int compareTo(Node t) {
        return key.compareTo(t.key);
    }

}
