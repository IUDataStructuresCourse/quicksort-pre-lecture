import java.util.Arrays;

public class QuickSort {
    static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    /**
     * The partition() method returns the index of the "pivot" element.
     * The post-condition of partition() method is that all elements less than
     * or equal to the pivot are to the left (smaller indexes) of the pivot and all elements greater
     * than the pivot are to the right (larger indexes).
     * The pre-condition is that begin < end.
     * @param A The array to be partitioned.
     * @param begin The index of the first element in the range to be partitioned.
     * @param end One-past the last element in the range to be partitioned.
     * @return The index of the pivot.
     */
    static int partition(int[] A, int begin, int end) {
        int pivot = A[end-1];
        int i = begin;
        // invariants:
        // * elements in L are less-equal the pivot
        // * element in G are greater than the pivot
        // * element in T have not been processed
        // L=A[begin,i), G = A[i,j), T=A[j,end-1)
        for (int j = begin; j != end-1; ++j) {
            if (A[j] <= pivot) {
                swap(A, i, j);
                ++i;
            }
        }
        swap(A, i, end-1);
        return i;
    }

    static void quicksort(int[] A, int begin, int end) {
        if (begin != end) {
            int pivot = partition(A, begin, end);
            quicksort(A, begin, pivot);
            quicksort(A, pivot+1, end);
        }
    }
}
