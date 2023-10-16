package Assignment2.noiseremoving;

/*
 * Question 1:
 *      Is quick sort the best way of finding median? Why?
 * Answer:
 *      Quick sort isn't necessarily the most efficient method for identifying the median. While it sorts
 *      with a time complexity of O(n log n), there are specialized techniques designed specifically for
 *      finding the median without the need to sort the entire array.
 *
 * Question 2:
 *      What is another good way of finding median? Please provide your explanation.
 * Answer:
 *      In the context of a limited dataset, such as a 9-pixel window, algorithms like insertion sort
 *      and selection sort can be quite effective. Their O(n^2) time complexity might seem high, but
 *      given the small dataset, the real-world performance is acceptable. Their inherent simplicity
 *      ensures a fast and efficient sort for small data sizes.
 *
 */

public class CollectionSort<E extends Comparable> {

    public E[] array;

    /**
     * Receives an array reference and assigns it to the class's "array" field.
     */
    public void setArray(E[] array) {
        this.array = array;
    }

    /**
     * Executes the quick sort algorithm to order the array elements.
     */
    public void quickSort() {
        if (array == null || array.length == 0 || array.length == 1) {
            return;
        }
        quickSort(0, array.length - 1);
    }

    /**
     * Implements the recursive quick sort mechanism on the given array segment.
     * Sorts the segment of the array between the provided starting and ending indices.
     */
    private void quickSort(int low, int high) {
        if (low < high) {
            int pivotPosition = partition(low, high);
            quickSort(low, pivotPosition - 1);
            quickSort(pivotPosition + 1, high);
        }
    }

    /**
     * Establishes a pivot in the array and organizes elements based on their relation to it.
     * Organizes elements of the array around a selected pivot, ensuring values less than the pivot come before it, and values greater come after.
     */
    private int partition(int low, int high) {
        E pivotValue = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivotValue) <= 0) {
                i++;
                swapElements(i, j);
            }
        }

        swapElements(i + 1, high);
        return i + 1;
    }

    /**
     * Exchanges positions of two elements within the array.
     * Switches the places of two array elements based on provided indices.
     */
    private void swapElements(int i, int j) {
        E placeholder = array[i];
        array[i] = array[j];
        array[j] = placeholder;
    }
}
