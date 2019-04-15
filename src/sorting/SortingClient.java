package sortring;

public class SortingClient {

    public static void main(String[] args) {
        Integer[] a = new Integer[]{7, 10, 5, 3, 8, 4, 2, 9, 6};

        // Selection Sort
        Selection selection = new Selection();
        selection.sort(a);
        selection.print(a, "Selection Sort");

        // Insertion Sort
        a = new Integer[]{7, 10, 5, 3, 8, 4, 2, 9, 6};
        Insertion insertion = new Insertion();
        insertion.sort(a);
        insertion.print(a, "Insertion Sort");

        // Merge Sort
        a = new Integer[]{7, 10, 5, 3, 8, 4, 2, 9, 6};
        Merge merge = new Merge();
        merge.sort(a);
        merge.print(a, "Merge Sort");

        // Quick Sort
        a = new Integer[]{7, 10, 5, 3, 8, 4, 2, 9, 6};
        Quick quick = new Quick();
        quick.sort(a);
        quick.print(a, "Quick Sort");

        // Heap Sort
        a = new Integer[]{7, 10, 5, 3, 8, 4, 2, 9, 6};
        Heap heap = new Heap();
        heap.sort(a);
        heap.print(a, "Heap Sort");
    }
}
