package sortring;

public class Quick implements Sort{

    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length-1);
    }

    private void sort(Comparable[] a, int lo, int hi){
        if(hi<=lo) return;
        int p = partition(a, lo, hi);
        sort(a, lo, p-1);
        sort(a, p+1, hi);
    }

    private int partition(Comparable[] a, int lo, int hi){
        int i = lo;
        int j = hi+1;

        while (true) {
            while (less(a[++i], a[lo]))
                if(i==hi) break;

            while (less(a[lo], a[--j]))
                if(j==lo) break;

            if(i>=j) break;

            exhg(i, j, a);
        }

        exhg(lo, j, a);
        return j;
    }
}
