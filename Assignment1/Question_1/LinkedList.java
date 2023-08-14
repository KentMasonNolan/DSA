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
public class LinkedList <E extends Comparable<E>>{
    
    public int size = 0;
    public Node<E> head;

    public void addHead(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public Node<E> getHead() {
        return head;
    }

    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    
    private void add(Node head, Node node)
    {

    }

    public void printLinkedList() {
        printLinkedList(head);
    }

    private void printLinkedList(Node<E> node) {
        if (node == null) {
            System.out.println("Linked list is empty.");
            return;
        }
        Node<E> current = node;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public boolean contains(Node<E> node) {
        return contains(head, node);
    }

    private boolean contains(Node<E> current, Node<E> target) {
        if (current == null) {
            return false;
        }
        if (current.equals(target)) {
            return true;
        }
        return contains(current.next, target);
    }

    // todo up to here


    public void remove(Node node)
    {

    }
    
    public void remove(int position)
    {
        
    }
    
    private void removeByIndex(Node head, int position)
    {

    }
    
    private void removeFromBody(Node head, Node node)
    {

    }
    
    public Node removeFromHead()
    {
        return null;
    }
    
    public Node removeFromTail()
    {
        return null;
    }
    
    private Node removeFromTail(Node node)
    {
        return null;
    }
    
    public void addInOrder(E data)
    {

    }
    
    private void addInOrder(Node currentNode, Node newNode)
    {

    }
    
    public Node getNode(int index)
    {
        return null;
    }
    
    private Node getNode(int index, Node head)
    {
        return null;
    }
    
    public E getData(int index)
    {
        return null;
    }
    
    private E getData(int index, Node head)
    {
        return null;
    }    
}
