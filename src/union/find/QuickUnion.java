package union.find;

public class QuickUnion {
    private int N;
    private int[] id;

    public QuickUnion(int n) {
        N = n;
        id = new int[N];
        for (int i = 0; i<n; i++)
            id[i] = i;
    }

    private int root(int p){
        while (id[p]!=p)
            p = id[p];
        return p;
    }

    public void union(int p, int q){
        int pId = root(p);
        int qId = root(q);
        id[pId] = qId;
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public static void main(String[] args) {
        QuickUnion quickUnion = new QuickUnion(10);
        quickUnion.union(0, 5);
        quickUnion.union(5, 6);
        quickUnion.union(1, 2);
        quickUnion.union(2, 7);
        quickUnion.union(3, 4);
        quickUnion.union(4, 9);
        quickUnion.union(3, 8);

        System.out.println("0->6 "+ quickUnion.connected(0,6));
        System.out.println("1->7 "+ quickUnion.connected(1,7));
        System.out.println("3->9 "+ quickUnion.connected(3,9));
        System.out.println("8->9 "+ quickUnion.connected(8,9));
        System.out.println("0->7 "+ quickUnion.connected(0,7));
        System.out.println("2->9 "+ quickUnion.connected(2,9));
    }
}
