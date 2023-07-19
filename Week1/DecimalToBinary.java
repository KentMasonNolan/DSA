package Week1;

public class DecimalToBinary {
    public static String decimalToBinary(int number) {
        if (number == 0) {
            return "0";
        } else {
            String binary = decimalToBinary(number >> 1);
            int bit = number & 1;
            return binary + bit;
        }
    }

    public static void main(String[] args) {
        int decimalNumber = 10;
        String binaryNumber = decimalToBinary(decimalNumber);
        System.out.println("Binary representation of " + decimalNumber + ": " + binaryNumber);
    }
}
