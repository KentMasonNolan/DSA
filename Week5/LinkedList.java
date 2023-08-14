package Week5;

public class LinkedList {

    Node head, tail;
    boolean isDoublyLinkedList = false;
    int size = 0;

    public LinkedList(String[] dataList) {
        Node node = new Node();
        head = node;
        Node current = head;
        node.data = dataList[0];

        for (int i = 1; i < dataList.length; i++) {
            node = new Node();
            node.data = dataList[i];
            node.prev = null;
            node.next = null;

            current.next = node;
            current = current.next;
            size++;

        }
        tail = current;
    }

    public void printList(boolean reversely){
        if (reversely)

            printListReversly(head);

        else printList(head);
    }

    public void printList(Node current){
        System.out.println(current.data);

        if (current.next != null){
            printList(current.next);
        }
    }

    private void printListReversly(Node current){
        if (current.next != null){
            printListReversly(current.next);
        }
        System.out.println(current.data);
    }

    public void printListByLinker(){
        for(Node current = head; current != null; current = current.next){
            System.out.println(current.data);
        }
        for (Node current = tail; current != null; current = current.prev){
            System.out.println(current.data);
        }

    }

    public void toDoublyLinkedList(){
        toDoublyLinkedList(head);
        isDoublyLinkedList = true;
    }

    private Node toDoublyLinkedList(Node current){
        Node next;
        if (current.next != null){
            next = toDoublyLinkedList(current.next);
            next.prev = current;
        }
        return current;
    }

    public void toCircularlyLinkedList(){
        tail.next = head;
        if (tail.prev != null){
            head.prev = tail;
        }
    }


}


