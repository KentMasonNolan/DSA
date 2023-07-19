package Week1.Lab1;

public class insertToArray {
    public static void main(String[] args) {

        int[] arr = { 10, 20, 30, 40, 50 };
        int size = 5;
        int number = 35;

        System.out.println(printArray(arr));
        System.out.println(printArray(addToArray(number,arr,size)));
    }

    public static String printArray(int[] list){
        String output = "";

        for (int i = 0; i < list.length; i++) {
            output = output + list[i] + " ";
        }
        return output;
    }


    public static int[] addToArray(int number, int[] list, int size){

        int[] newArray = new int[size+1];
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (list[i] >= number){
                index = i;
                break;
            }
        }

        if (index == -1){
            index = size+1;
        }

        for (int i = 0; i < index; i++) {
            newArray[i] = list[i];
        }

        newArray[index] = number;

        for (int i = index; i < size; i++) {
            newArray[i+1] = list[i];
        }

        return newArray;
    } 
}
