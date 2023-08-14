package Week5;

import java.util.Scanner;

public class DSA_Quiz5 {
    static String[] elements = new String[10];
    static int size = 5;

    public static void main(String[] args) {
        String[] data = {"a", "b", "c", "d", "e"};
        LinkedList list = new LinkedList(data);
        list.printList(false);

        guessNumber(0,100);
    }

    public static void guessNumber(int lower_bound, int upper_bound) {
        Scanner scanner = new Scanner(System.in);
        String response;

        do {
            int guess = (lower_bound + upper_bound) / 2;
            System.out.println("Is the number " + guess + "? (l/h/y)");
            response = scanner.nextLine();

            if (response.equalsIgnoreCase("l")) {
                lower_bound = guess + 1;
            } else if (response.equalsIgnoreCase("h")) {
                upper_bound = guess - 1;
            } else if (!response.equalsIgnoreCase("y")) {
                System.out.println("Invalid response. Please enter 'l', 'h', or 'y'.");
            }

        } while (!response.equalsIgnoreCase("y"));

        System.out.println("Yay, I did it");
        scanner.close();
    }
}
