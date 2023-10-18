package Assignment2.noiseremoving;

public class SortArray<E extends Comparable<E>> {

    E[] array;

    public SortArray(E[] array) {
        this.array = array;
    }

    public void setArray(E[] array) {
        this.array = array;
    }

    // main quickSort function
    public void quickSort() {
        quickSort(0, array.length - 1);
    }

    // helper function for quicksort
    private void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }

    // function to perform the partition and returns pivot index
    private int partition(int low, int high) {
        E pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    // function to swap elements at index i and j
    private void swap(int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
