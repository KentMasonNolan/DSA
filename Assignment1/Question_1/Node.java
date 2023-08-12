/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1.Question_1;

/**
 * @author xhu
 */


public class Node<E extends Comparable<E>> {

    private E data;
    private Node<E> next;

    public Node(E data) {
        this.data = data;
        this.next = null;
    }

    public E getData() {
        return data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public boolean equals(Node node) {
        if (this == node) {
            return true;
        }
        if (node == null) {
            return false;
        }
        Node<?> other = (Node<?>) node;
        return data.equals(other.data);
    }

    public int compareTo(Node<E> node) {
        return data.compareTo(node.data);
    }
}
