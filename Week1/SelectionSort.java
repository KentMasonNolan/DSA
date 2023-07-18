package Week1;

public class SelectionSort  {


    public static void main(String[] args) {

        int[] list = new int[]{5, 3, 1, 234, 123, 1234, 2345, 3456, 23, 3, 234, 2345, 23, 5, 567, 7856, 7, 5};

        printArray(list);

        SelSort(list);



    }

    private static int[] SelSort(int[] inputList) {

        for (int i = 0; i < inputList.length; i++) {
            int lowestIndex = i;
            for (int j = i; j < inputList.length; j++) {
                if (inputList[j] <= inputList[lowestIndex]){
                    lowestIndex = j;
                }
            }
            int temp = inputList[i];
            inputList[i] = inputList[lowestIndex];
            inputList[lowestIndex] = temp;
        }
    printArray(inputList);
        return inputList;
    }


    public static void printArray(int[] inputList){
        String output = "";
        for (int i = 0; i < inputList.length; i++) {
            output = output + inputList[i] + " ";
        }
        System.out.println(output);
    }


}
