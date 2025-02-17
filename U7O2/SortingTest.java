import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortingTest {

    @Test
    public void testInsertionSort() {
        Integer[] arr = {5, 2, 9, 1, 5, 6, 7, 8, 3, 4};
        Sort.insertionSort(arr);
        Integer[] expected = {1, 2, 3, 4, 5, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, arr, "The array should be sorted in ascending order.");
    }

    @Test
    public void testSelectionSort() {
        Integer[] arr = {5, 2, 9, 1, 5, 6, 7, 8, 3, 4};
        Sort.selectionSort(arr);
        Integer[] expected = {1, 2, 3, 4, 5, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, arr, "The array should be sorted in ascending order.");
    }

    @Test
    public void testQuickSort() {
        Integer[] arr = {5, 2, 9, 1, 5, 6, 7, 8, 3, 4};
        Sort.quickSort(arr, 0, arr.length - 1);
        Integer[] expected = {1, 2, 3, 4, 5, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, arr, "The array should be sorted in ascending order.");
    }

    @Test
    public void testMergeSort() {
        Integer[] arr = {5, 2, 9, 1, 5, 6, 7, 8, 3, 4};
        Sort.mergeSort(arr);
        Integer[] expected = {1, 2, 3, 4, 5, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, arr, "The array should be sorted in ascending order.");
    }
}
