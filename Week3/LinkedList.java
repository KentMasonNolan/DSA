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


    public boolean contains(E data){
        return false;
        //TODO expand
    }

    public String toStringReversely(){
        return toStringReversely(head);
    }

    public String toStringReversely(SetNode head){
        return "Banana";
        //TODO expand
    }


    public String toString() {
        return "Pants";
        //TODO expand
    }
}
