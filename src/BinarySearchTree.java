import java.util.Collection;
import java.util.Iterator;

public class BinarySearchTree implements Collection{
    private Node root;
    private int size;


    public class Node {
        private Object data;
        private Node left;
        private Node right;

        public Node(Object data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public Node minimum() {
            if (this.left == null) {
                return this;
            } else {
                return this.left.minimum();
            }
        }
    }

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if(root != null ){
            Node node = new Node(o);

            Node currentNode = root;
            while(currentNode != null){
                int resultComparing = BinarySearchTree.compare(currentNode, node);
                if(resultComparing == 0){
                    return true;
                }
                if(resultComparing > 0){
                    currentNode = currentNode.left;
                }
                if(resultComparing < 0){
                    currentNode = currentNode.right;
                }
            }

        } else {
            System.out.println("Tree is empty!");
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        Node newNode = new Node(o);
        if (root == null){
            root = newNode;
            size++;
            return  true;
        }
        Node currentNode = root;
        while (currentNode != null) {
            int resultOfComparing = BinarySearchTree.compare(currentNode, newNode);
            if (resultOfComparing > 0) {
                if(currentNode.left == null){
                    currentNode.left = newNode;
                    size++;
                    return true;
                } else {
                    currentNode = currentNode.left;
                }
            }
            if (resultOfComparing < 0){
                if(currentNode.right == null){
                    currentNode.right = newNode;
                    size++;
                    return true;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        Node removedNode = new Node(o);
        Node currentNode = root;
        while(currentNode != null){
            int resultComparing =  BinarySearchTree.compare(currentNode, removedNode);
            if ( resultComparing == 0){
                if(currentNode.left != null &&  currentNode.right != null) {
                    removedNode = currentNode.right.minimum();
                    Object newData = removedNode.data;
                    currentNode.data = newData;
                    removedNode = null;
                    size--;
                    return  true;
                } else if((currentNode.left == null && currentNode.right != null)
                        || (currentNode.left != null && currentNode.right == null) ){
                    if(currentNode.left == null ){
                        currentNode.data = currentNode.right.data;
                        currentNode.right = null;
                        size--;
                        return true;
                    }
                    if(currentNode.right == null){
                        currentNode.data = currentNode.left.data;
                        currentNode.left = null;
                        size--;
                        return  true;
                    }
                } else if (currentNode.left == null && currentNode.right == null){
                    currentNode = null;
                    size--;
                    return true;
                }
            }
            if(resultComparing > 0){
                currentNode = currentNode.left;
            }
            if(resultComparing < 0){
                currentNode = currentNode.right;
            }

        }

        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {
        root.right = null;
        root.left = null;
        root.data = null;
        root = null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    public static int compare(Node nodeCompareWith, Node nodeCompareTo){
        Object nodeCompareWith_data = nodeCompareWith.data;
        Object nodeCompareTo_data = nodeCompareTo.data;
        Comparable nodeComparableWith = (Comparable)nodeCompareWith_data;
        Comparable nodeComparableTo = (Comparable)nodeCompareTo_data;
        return nodeComparableWith.compareTo(nodeComparableTo);
    }



}
