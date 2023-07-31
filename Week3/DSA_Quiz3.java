package Week3;

public class DSA_Quiz3 {

    public static void main(String[] args) {
        String[] stringList = {"Hello", "Hello", "Data", "Structures", "and", "Algorithms", "Students" };
        LinkedSet<String> linkedSet = new LinkedSet();
        for (int i = 0; i < stringList.length; i++) {
            linkedSet.add(stringList[i]);
        }
        System.out.println(linkedSet.toString());
        System.out.println(linkedSet.toStringReversely());
    }
}
