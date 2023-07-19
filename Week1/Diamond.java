package Week1;

public class Diamond {
    public static void main(String[] args) {
        diamond(6, 1);
    }

    public static void repeatlyPrint(int amount, String pattern) {
        if (amount > 0) {
            System.out.print(pattern);
            repeatlyPrint(amount - 1, pattern);
        }
    }

    public static void diamond(int totalHeight, int currentRow) {
        repeatlyPrint(currentRow - 1, " ");
        repeatlyPrint(2 * (totalHeight - currentRow) + 1, "* ");
        System.out.println();

        if (currentRow < totalHeight) {
            diamond(totalHeight, currentRow + 1);
        }

        repeatlyPrint(currentRow - 1, " ");
        repeatlyPrint(2 * (totalHeight - currentRow) + 1, "* ");
        System.out.println();
        repeatlyPrint(currentRow - 1, " ");
    }
}