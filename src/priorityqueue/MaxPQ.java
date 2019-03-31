package priorityqueue;

public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N;

    public MaxPQ(int capacity) {
        pq = (Key[])new Comparable[capacity+1];
    }

    public boolean isEmpty(){
        return N ==0;
    }

    public void insert(Key k){
        pq[++N] = k;
        swim(N);
    }

    public Key deleteMax(){
        Key max = pq[1];
        exhg(1, N);
        N--;
        sink(1);
        pq[N+1] = null;
        return max;
    }

    private void swim(int k){
        while (k>1 && less(k/2, k)) {
            exhg(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k){
        while (2*k<=N) {
            int j = 2*k;
            if(j<N && less(j, j+1)) j = j+1;
            if(!less(k, j)) break;
            exhg(k, j);
            k = j;
        }
    }

    private boolean less(int p, int q){
        return pq[p].compareTo(pq[q]) < 0;
    }

    private void exhg(int p, int q){
        Key temp = pq[p];
        pq[p] = pq[q];
        pq[q] = temp;
    }

    public static void main(String[] args) {
        MaxPQ<Integer> maxPQ = new MaxPQ<>(5);
        maxPQ.insert(10);
        maxPQ.insert(25);
        maxPQ.insert(50);
        maxPQ.insert(2);
        maxPQ.insert(6);
        System.out.println(maxPQ.deleteMax());
    }
}
