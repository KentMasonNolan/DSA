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
public class BinaryTree <E, F extends Comparable> {
    public Node root;
    public int number_of_nodes;
    private Node[] nodeList;
    
    public BinaryTree(Node node)
    {
        this.root = node;
    }
    
    public BinaryTree(E element, F key)
    {
        Node node = new Node(element, key);
        this.number_of_nodes = 0;

    }
    
    public BinaryTree()
    {
        this.root = null;
    }
    
    public void addElement(E element, F key)
    {


    }

    private void addNode(Node root, Node node) {
        if (root.compareTo(node.left) < 0) {
            if (root.left == null) {
                root.left = node;
            }
            else {
                addNode(root.left, node);
                }
            } else {
            if (root.right == null) {
                root.right = node;
            }
        }
    }

    public void traversal(Node root)
    {

    }
    
    public Node[] toSortedList()
    {
        return null;
    }
    
    private void toSortedList(Node root)
    {

    }
    
    public E searchElement(F key)
    {
        return null;
    }
       
    public Node searchNode(Node root, Node node)
    {
        return null;
    }
    
    public void reverseOrder()
    {

    }
    
    private void reverseOrder(Node root)
    {

    }
    
}
