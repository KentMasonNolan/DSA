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

    public void addToTree(Student student, Float score) {
        bTreeScore.addElement(student, score);
    }

    public void addToTree(Student student, String name) {
        bTreeName.addElement(student, name);
    }

//    public Student findStudent(E key) {
//        if (key instanceof Float) {
//            return bTreeScore.searchElement((Float) key);
//        } else if (key instanceof String) {
//            // If the key is a String, we assume it's a name and perform a full tree search
//            return searchStudentByName(bTreeName.root, (String) key);
//        }
//        return null;
//    }

    public Student findStudent(F key) {
        if (key instanceof Float) {
            for (int i = 0; i < bTreeScore.nodeList.length; i++) {
                if (bTreeScore.nodeList[i].key.equals(key)) {
                    Student student = (Student) bTreeScore.nodeList[i].element;
                    return student;
                }
            }
        } else if (key instanceof String) {
            for (int i = 0; i < bTreeName.nodeList.length; i++) {
                if (bTreeName.nodeList[i].key.equals(key)) {
                    Student student = bTreeName.nodeList[i].element;
                    return student;
                }
            }
        }
        return null;
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
