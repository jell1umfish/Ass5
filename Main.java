public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
        tree.put(2, "1");
        tree.put(5, "2");
        tree.put(1, "3");
        tree.put(8, "4");
        tree.put(9, "5");
        tree.put(7, "6");
        tree.put(3, "7");
        for (BinarySearchTree.elem<Integer, String> elem : tree) {
            System.out.println("key is " + elem.key + " and value is " + elem.value);
        }
        System.out.println(tree.get(5));
        System.out.println(tree.size());
        tree.remove(4);
        System.out.println(tree.get(4));
        System.out.println(tree.size());
    }
}