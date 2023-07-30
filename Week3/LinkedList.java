package Week3;

import java.security.PublicKey;

public class LinkedList <E extends Comparable>{

    SetNode head;
    int size;

    public LinkedList(){

        head = null;
        size = 0;

    }

    public void add(E data){

        SetNode<E> newNode = new SetNode();
        newNode.data = data;

        if (size == 0){
            head = newNode;
            size = 1;
        }
        else {
            if (!contains(data)){
                SetNode currentNode = head;
                for(; currentNode.next!=null; currentNode = currentNode.next);
                currentNode.next = newNode;
                size++;
            }
        }
    }


    public boolean contains(E data) {
        if (size == 0 || data == null) {
            return false; //exit because there is nothing to go over.
        }

        SetNode<E> currentNode = head;
        while (currentNode != null) { //loop
            if (currentNode.data.equals(data)) {
                return true; //we found what we want
            }
            currentNode = currentNode.next;
        }
        return false; //data not there
    }


    public String toStringReversely(){
        return toStringReversely(head);
    }

    public String toStringReversely(SetNode head){
        return "Banana";
        //TODO expand
    }


    public String toString() {

        SetNode<E> currentNode = this.head; //sets current header
        String output = ""; //we add everything to this

        if (this.size == 0) {
            return "Nothing there man"; //nothing there my man
        }

        for (int i = 0; i < this.size; i++) { //loop
            output = output + currentNode.data.toString() + " "; //adds data to output string
            currentNode = currentNode.next; // moves to the next node.
        }
        return output;
    }
}
