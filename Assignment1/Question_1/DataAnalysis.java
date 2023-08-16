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
public class DataAnalysis<E extends Comparable<E>> {
    private Queue<E> queue = new Queue<>();
    private Stack<E> stack = new Stack<>();
    private E[] data;

    public DataAnalysis(E[] data) {
        this.data = data;
        for (E element : data) {
            queue.enqueue(element);
            stack.push(element);
        }
    }

    public boolean isPalindrome() {
        while (!stack.isEmpty() && !queue.isEmpty()) {
            if (!stack.pop().equals(queue.dequeue())) {
                return false;
            }
        }
        return true;
    }
}
