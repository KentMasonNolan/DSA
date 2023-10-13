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

    public void addStudent(float score, String name, String comments) {
        Student student = new Student(name, score, comments); // Assuming you have a Student class defined with appropriate constructor
        addToTree(student, score); // Add to bTreeScore
        addToTree(student, name); // Add to bTreeName
    }

    public void addToTree(Student student, F key) {
        if (key instanceof Float) {
            bTreeScore.addElement(student, (Float) key);
        } else if (key instanceof String) {
            bTreeName.addElement(student, (String) key);
        }
    }

    public Student findStudent(E key) {
        if (key instanceof Float) {
            return bTreeScore.searchElement((Float) key);
        } else if (key instanceof String) {
            return bTreeName.searchElement((String) key);
        }
        return null;
    }


    public Student[] getSortedStudentList(E key) {
        BinaryTree<Student, ?> tree = (key instanceof Float) ? bTreeScore : bTreeName;
        Node<Student, ?>[] nodes = tree.toSortedList();
        Student[] students = new Student[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            students[i] = nodes[i].element;
        }
        return students;
    }
    public void reverseOrder() {
        bTreeScore.reverseOrder();
        bTreeName.reverseOrder();
    }
    
}
