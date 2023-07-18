package Week1;

public class DecimalToBinary {
    public static String decimalToBinary(int number) {
        if (number == 0) {
            return "0";  // Base case: If the number is 0, its binary representation is "0".
        } else {
            String binary = decimalToBinary(number >> 1);  // Recursive call with the number shifted to the right by 1.
            int bit = number & 1;  // Extract the least significant bit.
            return binary + bit;  // Append the bit to the binary representation obtained from the recursive call.
        }
    }

    public static void main(String[] args) {
        int decimalNumber = 10;  // Example decimal number to convert
        String binaryNumber = decimalToBinary(decimalNumber);
        System.out.println("Binary representation of " + decimalNumber + ": " + binaryNumber);
    }
}
