package tree;

public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int count;

        public Node(Key key, Value value, int count) {
            this.key = key;
            this.value = value;
            this.count = count;
        }
    }

    public boolean isEmpty(){
        return root == null;
    }

    public Value get(Key key){
        Node x = root;
        while (x!=null) {
            int cmp = key.compareTo(x.key);
            if(cmp < 0) x = x.left;
            else if(cmp > 0) x = x.right;
            else return x.value;
        }
        return null;
    }

    public void put(Key key, Value value){
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if(x == null) return new Node(key, value, 0);
        int cmp = key.compareTo(x.key);
        if(cmp < 0 ) x.left = put(x.left, key, value);
        else if(cmp > 0 ) x.right = put(x.right, key, value);
        else x.value = value;
        x.count = size(x.left) + size(x.right) +1;
        return x;
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if(x==null) return 0;
        return x.count;
    }

    public Value getMin(){
        if(isEmpty()) return null;
        Node x = root;
        while (x.left!=null) {
            x = x.left;
        }
        return x.value;
    }

    public Value getMax(){
        if(isEmpty()) return null;
        Node x = root;
        while (x.right!=null) {
            x = x.right;
        }
        return x.value;
    }

    public Value floor(Key key){
        Node x = floor(root, key);
        if(x!=null) return x.value;
        else return null;
    }

    private Node floor(Node x, Key key){
        if(x==null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0) return x;
        else if(cmp < 0) return floor(x.left, key);
        else {
            Node t = floor(x.right, key);
            if(t != null) return t;
            else return x;
        }
    }

    public Value ceil(Key key){
        Node x = ceil(root, key);
        if(x!=null) return x.value;
        else return null;
    }

    private Node ceil(Node x, Key key){
        if(x==null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0) return x;
        else if(cmp > 0) return ceil(x.right, key);
        else {
            Node t = ceil(x.left, key);
            if(t != null) return t;
            else return x;
        }
    }

    public int rank(Key key){
        return rank(root, key);
    }

    private int rank(Node x, Key key){
        if(x==null) return 0;
        int cmp = key.compareTo(x.key);
        if(cmp<0) return rank(x.left, key);
        else if(cmp>0) return 1+size(x.left)+rank(x.right, key);
        else return size(x.left);
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node x){
        if(x==null) return;
        inOrder(x.left);
        System.out.println(x.value);
        inOrder(x.right);
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node x){
        if(x==null) return;
        System.out.println(x.value);
        preOrder(x.left);
        preOrder(x.right);
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node x){
        if(x==null) return;
        postOrder(x.left);
        postOrder(x.right);
        System.out.println(x.value);
    }

    public void deleteMin(){

    }

    private Node deleteMin(Node x){
        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.count = 1+ size(x.left)+size(x.right);
        return x;
    }
}
