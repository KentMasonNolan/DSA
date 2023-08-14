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


}


