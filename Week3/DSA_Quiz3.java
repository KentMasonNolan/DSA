package Week3;

public class DSA_Quiz3 {

    public static void main(String[] args) {
        String[] stringList = {"Hello", "Hello", "Data", "Structures", "and", "Algorithms", "Students" };
        LinkedList<String> linkedList = new LinkedList();
        for (int i = 0; i < stringList.length; i++) {
            linkedList.add(stringList[i]);
        }
        System.out.println(linkedList.toString());
        System.out.println(linkedList.toStringReversely());
    }
}
