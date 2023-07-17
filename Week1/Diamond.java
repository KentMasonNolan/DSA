package Week1;

public class Diamond {
    public static void main(String[] args) {
        diamond(6, 1);
    }

    public static void repeatlyPrint(int amount, String pattern) {
        if (amount > 0) {
            // print a pattern once
            System.out.print(pattern);
            // recursively call the function itself
            repeatlyPrint(amount - 1, pattern);
        }
    }

    public static void diamond(int totalHeight, int currentRow) {
        // Print spaces (outside of diamond)
        repeatlyPrint(currentRow - 1, " ");

        // Print asterisks and spaces
        repeatlyPrint(2 * (totalHeight - currentRow) + 1, "* ");

        System.out.println();

        if (currentRow < totalHeight) {
            diamond(totalHeight, currentRow + 1);
        }

        // Print spaces
        repeatlyPrint(currentRow - 1, " ");

        // Print asterisks and spaces
        repeatlyPrint(2 * (totalHeight - currentRow) + 1, "* ");

        System.out.println();

        // Print spaces (outside of diamond)
        repeatlyPrint(currentRow - 1, " ");
    }
}