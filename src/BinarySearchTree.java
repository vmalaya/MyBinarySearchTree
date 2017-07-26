import java.util.Collection;
import java.util.Iterator;

public class BinarySearchTree<T> {
    private Node<T> root;
    private int size;


    private static class Node<T> {
        private T data;
        private Node left;
        private Node right;

        public Node(T data) {
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


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return this.size == 0;
    }


    public boolean contains(T o) {
        if(root != null ){
            if(o == null){
                throw new IllegalArgumentException("Illegal parameter value.");
            }
            Node<T> node = new Node<>(o);
            Node<T> currentNode = root;
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
            throw  new RuntimeException("Tree is empty!");
        }
        return false;
    }


    public Iterator iterator() {
        return null;
    }


    public Object[] toArray() {
        return new Object[0];
    }


    public boolean add(T o) {
        if (o == null){
            throw new IllegalArgumentException("Illegal parameter value!");
        }
        Node<T> newNode = new Node<>(o);
        if (root == null){
            root = newNode;
            size++;
            return  true;
        }
        Node<T> currentNode = root;
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
            if(resultOfComparing == 0){
                throw new IllegalArgumentException("There is node with such value!");
            }
        }
        return false;
    }


    public boolean remove(T o) {
        if(this.size == 0){
            throw new RuntimeException("Tree is empty. Empty list do not support operation 'remove'.");
        }
        if (o == null){
            throw new IllegalArgumentException("Illegal parameter value!");
        }
        Node<T> removedNode = new Node(o);
        Node<T> currentNode = root;
        while(currentNode != null){
            int resultComparing =  BinarySearchTree.compare(currentNode, removedNode);
            if ( resultComparing == 0){
                if(currentNode.left != null &&  currentNode.right != null) {
                    removedNode = currentNode.right.minimum();
                    T newData = removedNode.data;
                    currentNode.data = newData;
                    removedNode = null;
                    size--;
                    return  true;
                } else if((currentNode.left == null && currentNode.right != null)
                        || (currentNode.left != null && currentNode.right == null) ){
                    if(currentNode.left == null ){
                        currentNode.data =(T)currentNode.right.data;
                        currentNode.right = null;
                        size--;
                        return true;
                    }
                    if(currentNode.right == null){
                        currentNode.data = (T) currentNode.left.data;
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


    public boolean addAll(Collection c) {
        return false;
    }


    public void clear() {
        root.right = null;
        root.left = null;
        root.data = null;
        root = null;
    }


    public boolean retainAll(Collection c) {
        return false;
    }


    public boolean removeAll(Collection c) {
        return false;
    }


    public boolean containsAll(Collection c) {
        return false;
    }


    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    private  static int compare(Node nodeCompareWith, Node nodeCompareTo){
        Object nodeCompareWith_data = nodeCompareWith.data;
        Object nodeCompareTo_data = nodeCompareTo.data;
        Comparable nodeComparableWith = (Comparable)nodeCompareWith_data;
        Comparable nodeComparableTo = (Comparable)nodeCompareTo_data;
        return nodeComparableWith.compareTo(nodeComparableTo);
    }



}
