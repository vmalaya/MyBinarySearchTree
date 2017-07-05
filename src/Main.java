
public class Main {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        Integer i = new Integer(67);
        Integer r = new Integer(8);
        Integer t = 10;
        Integer e = 5;
        Integer l = 80;
        Integer x = 100;
        Integer k = 70;
        binarySearchTree.add(i);
        System.out.println(binarySearchTree.add(r));
        System.out.println(binarySearchTree.size());
        binarySearchTree.add(t);
        binarySearchTree.add(e);
        System.out.println(binarySearchTree.contains(t));
        binarySearchTree.add(l);
        binarySearchTree.add(x);
        binarySearchTree.add(k);
        System.out.println(binarySearchTree.remove(i));
        binarySearchTree.add(97);
        binarySearchTree.remove(100);



    }
}
