import java.util.Random;

public class InsertionSortTricks {
    
    // Original Insertion Sort (for sammenligning)
    public static <T extends Comparable<T>> void insertionSortOriginal(T[] a) {
        for (int i = 1; i < a.length; i++) {
            T temp = a[i];
            int j = i - 1;
            while (j >= 0 && a[j].compareTo(temp) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }
    }

    public static <T extends Comparable<T>> void insertionSortMinFirst(T[] a) {
        if (a.length > 0) {
            T min = a[0];
            int minIndex = 0;
            for (int i = 1; i < a.length; i++) {
                if (a[i].compareTo(min) < 0) {
                    min = a[i];
                    minIndex = i;
                }
            }
            for (int i = minIndex; i > 0; i--) {
                a[i] = a[i - 1];
            }
            a[0] = min;

            for (int i = 1; i < a.length; i++) {
                T temp = a[i];
                int j = i - 1;
                while (j >= 0 && a[j].compareTo(temp) > 0) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = temp;
            }
        }
    }

    public static <T extends Comparable<T>> void insertionSortTwoAtATime(T[] a) {
        for (int i = 1; i < a.length; i += 2) {
            T temp1 = a[i];
            T temp2 = (i + 1 < a.length) ? a[i + 1] : null;

            int j = i - 1;
            while (j >= 0 && a[j].compareTo(temp1) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j+1] = temp1;

            if (temp2 != null) {
                j = i;
                while (j >= 0 && a[j].compareTo(temp2) > 0) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = temp2;
            }
        }
    }

    public static <T extends Comparable<T>> void insertionSortCombined(T[] a) {
        if (a.length > 0) {
            T min = a[0];
            int minIndex = 0;
            for (int i = 1; i < a.length; i++) {
                if (a[i].compareTo(min) < 0) {
                    min = a[i];
                    minIndex = i;
                }
            }
            for (int i = minIndex; i > 0; i--) {
                a[i] = a[i - 1];
            }
            a[0] = min;

            for (int i = 1; i < a.length; i += 2) {
                T temp1 = a[i];
                T temp2 = (i + 1 < a.length) ? a[i + 1] : null;

                int j = i - 1;
                while (j >= 0 && a[j].compareTo(temp1) > 0) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = temp1;

                if (temp2 != null) {
                    j = i;
                    while (j >= 0 && a[j].compareTo(temp2) > 0) {
                        a[j + 1] = a[j];
                        j--;
                    }
                    a[j + 1] = temp2;
                }
            }
        }
    }


    public static <T extends Comparable<T>> boolean isSorted(T[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(array[i - 1]) < 0) {
                return false;  
            }
        }
        return true; 
    }

    public static <T extends Comparable<T>> void measureSortingTime(T[] array, String methodName) {
        long startTime = System.nanoTime();
        switch (methodName) {
            case "original":
                insertionSortOriginal(array);
                break;
            case "minFirst":
                insertionSortMinFirst(array);
                break;
            case "twoAtATime":
                insertionSortTwoAtATime(array);
                break;
            case "combined":
                insertionSortCombined(array);
                break;
            default:
                throw new IllegalArgumentException("Ukjent metode");
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; 
        System.out.println("Tid for " + methodName + ": " + duration + " ms");
    }

    public static void main(String[] args) {
        int arraySize = 100000; 
        Random random = new Random();
        Integer[] originalArray = new Integer[arraySize];

        for (int i = 0; i < arraySize; i++) {
            originalArray[i] = random.nextInt(arraySize); 
        }

        Integer[] arrayForOriginal = originalArray.clone();
        Integer[] arrayForMinFirst = originalArray.clone();
        Integer[] arrayForTwoAtATime = originalArray.clone();
        Integer[] arrayForCombined = originalArray.clone();

        measureSortingTime(arrayForOriginal, "original");
        measureSortingTime(arrayForMinFirst, "minFirst");
        measureSortingTime(arrayForTwoAtATime, "twoAtATime");
        measureSortingTime(arrayForCombined, "combined");

        System.out.println(isSorted(arrayForOriginal));
        System.out.println(isSorted(arrayForMinFirst));
        System.out.println(isSorted(arrayForTwoAtATime));
        System.out.println(isSorted(arrayForCombined));
    }
}
