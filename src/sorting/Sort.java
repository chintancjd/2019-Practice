package sortring;

import java.util.Arrays;

public interface Sort {

    void sort(Comparable[] a);

    default void exhg(int p, int q, Comparable[] a){
        Comparable temp = a[p];
        a[p] = a[q];
        a[q] = temp;
    }

    default boolean less(Comparable p, Comparable q){
        return p.compareTo(q) < 0;
    }

    default void print(Comparable[] a, String msg){
        System.out.print(msg + ": ");
        Arrays.stream(a).forEach(val->System.out.print(val+" "));
        System.out.println();
    }
}
