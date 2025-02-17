import java.util.Random;
import java.util.function.Consumer;

public class Sort {
    public static void main(String[] args) {
        int[] sizes = {32000, 64000, 128000}; 
        int numTrials = 1; 

        for (int size : sizes) {
            Integer[] arr = generateRandomArray(size);

            System.out.println("\nN = " + size);
            benchmarkSort("Insertion Sort", arr, Sort::insertionSort, numTrials);
            benchmarkSort("Selection Sort", arr, Sort::selectionSort, numTrials);
            benchmarkSort("Quick Sort", arr, a -> quickSort(a, 0, a.length - 1), numTrials);
            benchmarkSort("Merge Sort", arr, Sort::mergeSort, numTrials);
        }

        Integer[] identicalArray = new Integer[10000];
        for (int i = 0; i < identicalArray.length; i++) {
            identicalArray[i] = 5; 
        }

        long startTime = System.nanoTime();
        quickSort(identicalArray, 0, identicalArray.length - 1);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("QS Identical Array: " + duration + " ns = " + duration / 1_000_000 + "ms");
    }
    
    private static void benchmarkSort(String name, Integer[] originalArray, Consumer<Integer[]> sortFunction, int numTrials) {
        long totalTime = 0;

        for (int i = 0; i < numTrials; i++) {
            Integer[] arr = originalArray.clone();
            long startTime = System.nanoTime();
            sortFunction.accept(arr);
            long endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }

        long avgTime = totalTime / numTrials;
        System.out.println(name + " Average Time: " + avgTime + "ns = " + avgTime / 1_000_000 + "ms");
    }

    public static Integer[] generateRandomArray(int size) {
        Integer[] arr = new Integer[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt();
        }
        return arr;
    }


    public static void insertionSort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Integer key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void selectionSort(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            Integer temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void quickSort(Integer[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);  
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(Integer[] arr, int low, int high) {
        Integer pivot = arr[high];
        int i = (low - 1); 

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                Integer temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Integer temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    public static void mergeSort(Integer[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        Integer[] left = new Integer[mid];
        Integer[] right = new Integer[arr.length - mid];
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(Integer[] arr, Integer[] left, Integer[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}
