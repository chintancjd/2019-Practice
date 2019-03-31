package priorityqueue;

public class MinPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    public MinPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity+1];
    }

    public boolean isEmpty(){
        return N ==0;
    }

    public void insert(Key k){
        pq[++N] = k;
        swim(N);
    }

    public Key deleteMin(){
        Key min = pq[1];
        exhg(1, N);
        N--;
        sink(1);
        pq[N+1] = null;
        return min;
    }

    private void swim(int k){
        while (k>1 && !less(k/2, k)) {
            exhg(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k){
       while (2*k <= N) {
           int j = 2*k;
           if(j<N && less(j+1, j)) j = j+1;
           if(less(k, j)) break;
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
        MinPQ<Integer> minPQ = new MinPQ<>(5);
        minPQ.insert(10);
        minPQ.insert(5);
        minPQ.insert(2);
        minPQ.insert(15);
        System.out.println(minPQ.deleteMin());
    }
}
