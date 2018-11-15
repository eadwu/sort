import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SelectionSort implements SortAlgorithm {
    private int[] arr;

    SelectionSort(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void sortGreater() {
        IntStream.range(0, this.arr.length).forEach(x -> {
            int i = x;
            for (int y = x + 1; y < this.arr.length; y++) {
                if (this.arr[y] > this.arr[x])
                    i = y;
            }
            Array.swap(this.arr, x, i);
        });
    }

    @Override
    public void sortLess() {
        IntStream.range(0, this.arr.length).forEach(x -> {
            int i = x;
            for (int y = x + 1; y < this.arr.length; y++) {
                if (this.arr[y] < this.arr[x])
                    i = y;
            }
            Array.swap(this.arr, x, i);
        });
    }

    public static void main(String[] args) {
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random() * arr.length);

        SelectionSort test = new SelectionSort(arr);

        System.out.print("Original array is ");
        System.out.println('[' + test.toString() + ']');
        test.sortGreater();
        System.out.print("New array is sorted by greater than ");
        System.out.println('[' + test.toString() + ']');
        test.sortLess();
        System.out.print("New array is sorted by less than ");
        System.out.println('[' + test.toString() + ']');
    }

    @Override
    public String toString() {
        return Arrays.stream(this.arr).mapToObj(String::valueOf).collect(Collectors.joining(", "));
    }
}
