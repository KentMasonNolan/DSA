/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2.studentapp;

/**
 *
 * @author Kent
 */
public class StudentManager<E,F  extends Comparable> {

    private BinaryTree<Student, Float> bTreeScore; // Node key is Float type (student score)
    private BinaryTree<Student, String> bTreeName; // Node key is String type (student name)

    public StudentManager() {
        this.bTreeScore = new BinaryTree<>();
        this.bTreeName = new BinaryTree<>();
    }

    // method to add a new student to both score and name binary trees
    public void addStudent(float score, String name, String comments) {
        // create a new student instance with the provided details
        Student student = new Student(name, score, comments); // Assuming you have a Student class defined with appropriate constructor
        // add student to the score-based binary tree
        addToTree(student, score); // Add to bTreeScore
        // add student to the name-based binary tree
        addToTree(student, name); // Add to bTreeName
    }


    public void addToTree(Student student, Float score) {
        bTreeScore.addElement(student, score);
    }

    public void addToTree(Student student, String name) {
        bTreeName.addElement(student, name);
    }


    // method to find a student using a given key (can be either a Float for score or a String for name)
    public Student findStudent(F key) {
        // if the key is a Float, search in the score-based binary tree
        if (key instanceof Float) {
            for (int i = 0; i < bTreeScore.nodeList.length; i++) {
                // if key matches, return the student from the node
                if (bTreeScore.nodeList[i].key.equals(key)) {
                    Student student = (Student) bTreeScore.nodeList[i].element;
                    return student;
                }
            }
            // if the key is a String, search in the name-based binary tree
        } else if (key instanceof String) {
            for (int i = 0; i < bTreeName.nodeList.length; i++) {
                // if key matches, return the student from the node
                if (bTreeName.nodeList[i].key.equals(key)) {
                    Student student = bTreeName.nodeList[i].element;
                    return student;
                }
            }
        }
        // if student is not found, return null
        return null;
    }



    // method to search for a student by their name in the binary tree
    public Student searchStudentByName(Node root, String name) {
        // base case: if the node is null, return null
        if (root == null) {
            return null;
        }
        // cast the node's element to Student to access its name
        Student student = (Student) root.element;
        // if the student's name matches the search name, return the student
        if (student.name.equals(name)) {
            return student;
        }
        // recursively search the left subtree
        Student foundStudent = searchStudentByName(root.left, name);
        // if a student is found in the left subtree, return them
        if (foundStudent != null) {
            return foundStudent;
        }
        // if not found in left, recursively search the right subtree
        return searchStudentByName(root.right, name);
    }





    public Student[] getSortedStudentList(E key) {
        // determine which tree to use based on the type of key
        BinaryTree<Student, ?> tree;
        if (key instanceof Float) {
            // if key is a score (float), use score tree
            tree = bTreeScore;
        } else {
            // otherwise, use name tree
            tree = bTreeName;
        }
        // convert the tree to a sorted list of nodes
        Node<Student, ?>[] nodes = tree.toSortedList();

        // prepare an array to hold just the student objects
        Student[] students = new Student[nodes.length];
        // loop through the nodes, extracting the student object from each one
        for (int i = 0; i < nodes.length; i++) {
            students[i] = nodes[i].element;
        }
        // return the sorted list of students
        return students;
    }


    public void reverseOrder() {
        bTreeScore.reverseOrder();
        bTreeName.reverseOrder();
    }
    
}
