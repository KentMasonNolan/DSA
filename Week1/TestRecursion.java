package Week1;

public class TestRecursion {

    public static void main(String[] args) {
        countdown(6);

    }

    public static void countdown(int count){

        if (count <=0){
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.print("* ");
        }
        System.out.print("\n");
        countdown(count-1);
    }
}
