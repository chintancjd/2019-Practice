package sortring;

public class Heap implements Sort{

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int k = N/2; k>=1; k--)
            sink(a, k, N);

        while (N>1) {
            exhg(1, N, a);
            N--;
            sink(a, 1, N);
        }
    }

    private void sink(Comparable[] a, int k, int N){
        while (2*k<= N) {
            int j = 2*k;
            if(j< N && less(j, j+1, a)) j = j+1;
            if(less(j, k, a)) break;
            exhg(j, k, a);
            k = j;
        }
    }

    @Override
    public void exhg(int p, int q, Comparable[] a) {
        Comparable temp = a[p-1];
        a[p-1] = a[q-1];
        a[q-1] = temp;
    }

    public boolean less(int p, int q, Comparable[] a) {
        return a[p-1].compareTo(a[q-1]) < 0;
    }
}
