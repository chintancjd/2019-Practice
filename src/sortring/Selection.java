package sortring;

public class Selection implements Sort{

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for(int i = 0; i<N; i++){
            int min = i;
            for(int j = i; j<N; j++){
                if(less(a[j], a[min]))
                    min = j;
            }
            exhg(i, min, a);
        }
    }
}
