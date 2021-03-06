import java.util.Arrays;
import java.util.stream.Collectors;

public class InsertionSort implements SortAlgorithm {
    private int[] arr;

    InsertionSort(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void sortGreater() {
        int i = 1;
        while (i < this.arr.length) {
            int j = i;
            while (j > 0 && this.arr[j - 1] > this.arr[j]) {
                Array.swap(this.arr, j, j - 1);
                j = j - 1;
            }
            i = i + 1;
        }
    }

    @Override
    public void sortLess() {
        int i = 1;
        while (i < this.arr.length) {
            int j = i;
            while (j > 0 && this.arr[j - 1] < this.arr[j]) {
                Array.swap(this.arr, j, j - 1);
                j = j - 1;
            }
            i = i + 1;
        }
    }

    @Override
    public String toString() {
        return Arrays.stream(this.arr).mapToObj(String::valueOf).collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random() * arr.length);

        InsertionSort test = new InsertionSort(arr);

        System.out.println("Original array is [" + test.toString() + "]");
        long t0 = Profiler.tick();
        test.sortGreater();
        System.out.println("sortGreater() took approx " + Profiler.diff(t0, Profiler.tick()) + " ns");
        System.out.println("New array is sorted by greater than [" + test.toString() + "]");

        System.out.println("Original array is [" + test.toString() + "]");
        long t1 = Profiler.tick();
        test.sortLess();
        System.out.println("sortLess() took approx " + Profiler.diff(t1, Profiler.tick()) + " ns");
        System.out.println("New array is sorted by less than [" + test.toString() + "]");
    }
}
