package union.find;

public class QuickFind {

    private int N;
    private int[] id;

    public QuickFind(int n) {
        N = n;
        id = new int[N];
        for (int i = 0; i<n; i++)
            id[i] = i;
    }

    public void union(int p, int q){
        int pId = id[p];
        int qId = id[q];
        for(int i = 0; i<N; i++) {
            if(id[i] == pId)
                id[i] = qId;
        }
    }

    public boolean connected(int p, int q){
        return id[p] == id[q];
    }

    public static void main(String[] args) {
        QuickFind quickFind = new QuickFind(10);
        quickFind.union(0, 5);
        quickFind.union(5, 6);
        quickFind.union(1, 2);
        quickFind.union(2, 7);
        quickFind.union(3, 4);
        quickFind.union(4, 9);
        quickFind.union(3, 8);

        System.out.println("0->6 "+ quickFind.connected(0,6));
        System.out.println("1->7 "+ quickFind.connected(1,7));
        System.out.println("3->9 "+ quickFind.connected(3,9));
        System.out.println("8->9 "+ quickFind.connected(8,9));
        System.out.println("0->7 "+ quickFind.connected(0,7));
        System.out.println("2->9 "+ quickFind.connected(2,9));
    }
}
