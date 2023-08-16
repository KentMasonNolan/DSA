/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1.Question_1;

/**
 *
 * @author xhu
 */
public class Queue<E extends Comparable<E>> {

    private LinkedList<E> queue = new LinkedList<>();

    public void enqueue(E data) {
        queue.add(data);
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        E data = queue.getHead().data;
        queue.removeFromHead();
        return data;
    }

    public void printQueue() {
        queue.printLinkedList();
    }

    public int getSize() {
        return queue.getSize();
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }
}

