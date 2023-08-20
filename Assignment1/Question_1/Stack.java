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
public class Stack<E extends Comparable<E>> {

    private LinkedList<E> stack = new LinkedList<>();

    public void push(E data) {
        stack.addHead(data);
    }

    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        E data = stack.getHead().data;
        stack.removeFromHead(); // Remove from the current instance, not from a variable named 'stack'
        return data;
    }


    public void printStack() {
        stack.printLinkedList();
    }

    public int getSize() {
        return stack.getSize();
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }
}