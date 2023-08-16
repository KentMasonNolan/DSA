/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1.Question_1;

/**
 * @author xhu
 */
public class LinkedList<E extends Comparable<E>> {

    public int size = 0;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

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

    private void add(Node head, Node node) {

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

    public void remove(Node<E> node) {
        if (head == null) {
            return; // List is empty
        }
        if (head.equals(node)) {
            head = head.next;
            size--;
            return;
        }
        removeFromBody(head, node);
    }

    public void remove(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        if (position == 0) {
            head = head.next;
            size--;
            return;
        }
        removeByIndex(head, position - 1);
    }

    private void removeByIndex(Node<E> current, int position) {
        if (position < 0 || current == null || current.next == null) {
            return;
        }
        if (position == 0) {
            current.next = current.next.next;
            size--;
            return;
        }
        removeByIndex(current.next, position - 1);
    }

    private void removeFromBody(Node<E> current, Node<E> target) {
        if (current == null || current.next == null) {
            return; // Target node not found
        }
        if (current.next.equals(target)) {
            current.next = current.next.next;
            size--;
            return;
        }
        removeFromBody(current.next, target);
    }

    public Node<E> removeFromHead() {
        if (head == null) {
            return null; // List is empty
        }
        Node<E> removedNode = head;
        head = head.next;
        size--;
        return removedNode;
    }

    public Node<E> removeFromTail() {
        if (head == null) {
            return null; // List is empty
        }
        if (head.next == null) {
            Node<E> removedNode = head;
            head = null;
            size--;
            return removedNode;
        }
        return removeFromTail(head);
    }

    private Node<E> removeFromTail(Node<E> current) {
        if (current.next.next == null) {
            Node<E> removedNode = current.next;
            current.next = null;
            size--;
            return removedNode;
        }
        return removeFromTail(current.next);
    }

    public void addInOrder(E data) {
        Node<E> newNode = new Node<>(data);
        if (head == null || data.compareTo(head.data) < 0) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }
        addInOrder(head, newNode);
    }

    private void addInOrder(Node<E> current, Node<E> newNode) {
        if (current.next == null || newNode.data.compareTo(current.next.data) < 0) {
            newNode.next = current.next;
            current.next = newNode;
            size++;
            return;
        }
        addInOrder(current.next, newNode);
    }

    public Node<E> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return getNode(index, head);
    }

    private Node<E> getNode(int index, Node<E> current) {
        if (index == 0) {
            return current;
        }
        return getNode(index - 1, current.next);
    }

    public E getData(int index) {
        return getNode(index).data;
    }

    private E getData(int index, Node<E> current) {
        return getNode(index, current).data;
    }
}
