package Assignment2.studentapp;

/**
 * @author Kent
 */
public class BinaryTree<E, F extends Comparable> {
    public Node<E, F> root;
    public int number_of_nodes;
    Node<E, F>[] nodeList;

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
        // create a new node with the given element and key
        Node node = new Node(element, key);

        // if the tree is empty, set the new node as root
        if (root == null) {
            root = node;
        } else {
            // otherwise, find the right spot in the tree to add the new node
            addNode(this.root, node);
        }

        // increment the total number of nodes in the tree
        number_of_nodes++;
    }


    // method to add a node to the binary tree
    private void addNode(Node current, Node nodeToAdd) {
        // if the current key is greater than the key of the node to add
        if (current.key.compareTo(nodeToAdd.key) > 0) {
            // if left child is empty, add it there
            if (current.left == null) {
                current.left = nodeToAdd;
            } else {
                // otherwise, continue looking on the left subtree
                addNode(current.left, nodeToAdd);
            }
        } else {
            // if right child is empty, add it there
            if (current.right == null) {
                current.right = nodeToAdd;
            } else {
                // otherwise, continue looking on the right subtree
                addNode(current.right, nodeToAdd);
            }
        }
    }

    // method to convert the binary tree to a sorted list
    public Node[] toSortedList() {
        // start with resetting the index
        index = 0;
        // initialize the node list based on the number of nodes
        nodeList = new Node[number_of_nodes];
        // populate the node list in order
        toSortedList(root);
        // return the sorted list of nodes
        return nodeList;
    }


    // recursive method to populate the nodeList in sorted order
    private void toSortedList(Node root) {
        // base case: if the node is null, just return
        if (root == null) {
            return;
        }
        // traverse the left subtree
        toSortedList(root.left);
        // add the current node to the nodeList
        nodeList[index++] = root;
        // traverse the right subtree
        toSortedList(root.right);
    }

    // method to search for an element based on its key
    public E searchElement(F key) {
        // start searching from the root
        Node<E, F> result = searchNode(root, key);
        // if we found the node with the desired key
        if (result != null) {
            // return its element
            return result.element;
        }
        // if we didn't find the node, return null
        return null;
    }


    // method to search for a node in the binary tree based on its key
    public Node searchNode(Node current, F key) {
        // if the current node is null or the key matches, return the current node
        if (current == null || current.key.equals(key)) {
            return current;
        }
        // if the current key is greater than the search key, search in the left subtree
        if (current.key.compareTo(key) > 0) {
            return searchNode(current.left, key);
        } else {
            // otherwise, search in the right subtree
            return searchNode(current.right, key);
        }
    }

    // method to search for a student in the binary tree based on their name
    public Student searchStudentByName(Node root, String name) {
        // if we've reached a null node, return null
        if (root == null) {
            return null;
        }

        // cast the current element to a Student type and check if the name matches
        Student student = (Student) root.element;
        if (student.name.equals(name)) {
            return student;
        }

        // if the name doesn't match, first search in the left subtree
        Student foundStudent = searchStudentByName(root.left, name);
        if (foundStudent != null) {
            return foundStudent;
        }

        // if not found in the left subtree, continue searching in the right subtree
        return searchStudentByName(root.right, name);
    }

    // method to reverse the order of the entire binary tree
    public void reverseOrder() {
        // start the reverse process from the root of the tree
        swapChildren(this.root);
    }

    // method to swap the left and right children of a node
    private void swapChildren(Node root) {
        // if the node is null, just return
        if (root == null) {
            return;
        }

        // swap the left and right child of the current node
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        // continue swapping for the left and right subtrees of the current node
        swapChildren(root.left);
        swapChildren(root.right);
    }

    // method to print the binary tree in reverse order
    private void reverseOrder(Node root) {
        // if the node is null, just return
        if (root == null) {
            return;
        }
        // first print the right subtree
        reverseOrder(root.right);
        // then print the current node
        System.out.println(root.toString());
        // finally print the left subtree
        reverseOrder(root.left);
    }


    // method to traverse and print the tree in in-order
    private void traverse(Node node) {
        // if the node is null, just return
        if (node == null) {
            return;
        }
        // first traverse the left subtree
        traverse(node.left);
        // then print the current node's data
        System.out.println(node.toString());
        // finally traverse the right subtree
        traverse(node.right);
    }

    // method to traverse and print the tree in reverse in-order
    private void reverseOrderTraversal(Node node) {
        // if the node is null, just return
        if (node == null) {
            return;
        }
        // first traverse the right subtree
        reverseOrderTraversal(node.right);
        // then print the current node's data
        System.out.println(node.toString());
        // finally traverse the left subtree
        reverseOrderTraversal(node.left);
    }

}
