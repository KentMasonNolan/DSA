/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2.studentapp;

/**
 * @author Kent
 */
public class BinaryTree<E, F extends Comparable> {
    public Node<E, F> root;
    public int number_of_nodes;
    private Node<E, F>[] nodeList;

    private int index = 0;

    public BinaryTree(Node node) {
        this.root = node;
    }

    public BinaryTree(E element, F key) {
        this.root = new Node(element, key);
        this.number_of_nodes = 1;

    }

    public BinaryTree() {
        this.root = null;
    }

    public void addElement(E element, F key) {
        Node node = new Node(element, key);
        if (root == null) {
            root = node;
        } else {
            addNode(this.root, node);
        }
        number_of_nodes++;
    }

    private void addNode(Node current, Node nodeToAdd) {
        if (current.key.compareTo(nodeToAdd.key) > 0) {
            if (current.left == null) {
                current.left = nodeToAdd;
            } else {
                addNode(current.left, nodeToAdd);
            }
        } else {
            if (current.right == null) {
                current.right = nodeToAdd;
            } else {
                addNode(current.right, nodeToAdd);
            }
        }
    }


    public Node[] toSortedList() {
        index = 0; // Reset the index
        nodeList = new Node[number_of_nodes];
        toSortedList(root);
        return nodeList;
    }


    private void toSortedList(Node root) {
        if (root == null) {
            return;
        }
        toSortedList(root.left);
        nodeList[index++] = root;
        toSortedList(root.right);
    }

    public E searchElement(F key) {
        Node<E, F> result = searchNode(root, key);
        if (result != null) {
            return result.element;
        }
        return null;
    }


    public Node searchNode(Node current, F key) {
        if (current == null || current.key.equals(key)) {
            return current;
        }
        if (current.key.compareTo(key) > 0) {
            return searchNode(current.left, key);
        } else {
            return searchNode(current.right, key);
        }
    }

    public Student searchStudentByName(Node root, String name) {
        if (root == null) {
            return null;
        }

        // Assuming 'element' is of type 'Student' and 'name' is a public field.
        // Cast 'element' to 'Student' and compare 'name' field directly.
        Student student = (Student) root.element;
        if (student.name.equals(name)) {
            return student;
        }

        // Then check the left subtree
        Student foundStudent = searchStudentByName(root.left, name);
        if (foundStudent != null) {
            return foundStudent;
        }

        // Then check the right subtree
        return searchStudentByName(root.right, name);
    }



    public void reverseOrder() {
        swapChildren(root);
    }

    private void swapChildren(Node root) {
        if (root == null) {
            return;
        }

        // Swap left and right children
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively swap children of left and right subtrees
        swapChildren(root.left);
        swapChildren(root.right);
    }

    private void reverseOrder(Node root) {
        if (root == null) {
            return;
        }
        reverseOrder(root.right);
        System.out.println(root.toString());
        reverseOrder(root.left);
    }

    private void traverse(Node node) {
        if (node == null) {
            return;
        }
        traverse(node.left);
        System.out.println(node.toString());
        traverse(node.right);
    }


    private void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.toString());  // or any other way you're displaying the node's data
        inOrderTraversal(node.right);
    }

    private void reverseOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        reverseOrderTraversal(node.right);
        System.out.println(node.toString());
        reverseOrderTraversal(node.left);
    }
}
