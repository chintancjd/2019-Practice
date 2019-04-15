package sortring;

public class Insertion implements Sort{

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;

        for (int i = 0; i<N; i++){
            for (int j = i; j>0; j--){
                if(less(a[j], a[j-1]))
                    exhg(j, j-1, a);
                else break;
            }
        }
    }
}
