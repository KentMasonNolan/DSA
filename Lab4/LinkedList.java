package Lab4;

public class LinkedList {
    Node head;

    public void add(Node head, Node newNode){
        if (head == null){
            head = newNode;
        }
        else {
            add(head, newNode);
        }
    }

    public void print(){
        for (Node n = head; n != null; n = n.next)
        {
            System.out.println(n.data);
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 5; i++) {
            Node node = new Node();
            node.data = ""+i;
            list.add(node);
        }
        list.print();
    }



}
