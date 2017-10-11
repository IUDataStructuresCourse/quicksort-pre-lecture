import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.Random;

public class StudentTest {

    @Test(timeout=100)
    public void smallPartition() throws Exception {
        int[] A_orig = {2,8,7,1,3,5,6,4};
        int[] A = A_orig.clone();
        int pivot = QuickSort.partition(A, 0, A.length);
        for (int i = 0; i != pivot; ++i)
            assertTrue(A[i] <= A[pivot]);
        for (int i = pivot + 1; i != A.length; ++i)
            assertTrue(A[pivot] < A[i]);
    }

    @Test(timeout=100)
    public void smallQuicksort() throws Exception {
        int[] A_orig = {2,8,7,1,3,5,6,4};
        int[] A_sorted = A_orig.clone();
        Arrays.sort(A_sorted);
        int[] A = A_orig.clone();
        QuickSort.quicksort(A, 0, A.length);
        assertTrue(Arrays.equals(A, A_sorted));
    }

    @Test(timeout=300)
    public void sortedQuicksort() throws Exception {
        Random gen = new Random();
        for (int k = 0; k != 10; ++k) {
            int n = 10000;
            int[] A_orig = new int[n];
            for (int i = 0; i != n; ++i)
                A_orig[i] = gen.nextInt(n);

            int[] A = A_orig.clone();
            Arrays.sort(A);
            QuickSort.quicksort(A, 0, A_orig.length);

            int[] A_sorted = A_orig.clone();
            Arrays.sort(A_sorted);
            assertTrue(Arrays.equals(A, A_sorted));
        }
    }

}