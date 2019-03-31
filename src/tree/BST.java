package tree;

public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    class Node {
        Key key;
        Value value;
        Node left;
        Node right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
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
        if(x == null) return new Node(key, value);
        int cmp = key.compareTo(x.key);
        if(cmp < 0 ) x.left = put(x.left, key, value);
        else if(cmp > 0 ) x.right = put(x.right, key, value);
        else x.value = value;
        return x;
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
}
