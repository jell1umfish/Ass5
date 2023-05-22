public class BinaryTree {
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
            left=right=null;
        }
    }
    Node root;

    public BinaryTree(){
        root = null;
    }

    private Node insert(Node current, int data){
        if(current == null){
            return new Node(data);
        }
        if(data < current.data){
            current.left = insert(current.left, data);
        } else if (data > current.data) {
            current.right = insert(current.right, data);
        }
        return current;
    }
    public void insert(int data){
        root = insert(root, data);
    }

    private Node remove(Node current, int data){
        if(current == null)
            return null;
        if(data < current.data){
            current.left = remove(current.left, data);
        } else if (data > current.data) {
            current.right = remove(current.right, data);
        }
        else {
            //childfree
            if(current.left == null && current.right == null){
                return null;
            };
            //child
            if(current.left == null){
                return current.right;
            }
            if(current.right == null){
                return current.left;
            }
            //two child
            int smallestValue = findSmallestValue(current.right);
            current.data = smallestValue;
            current.right = remove(current.right, smallestValue);
        }
        return current;
    }

    public void remove(int data){
        root = remove(root, data);
    }
    private int findSmallestValue(Node root){
        return root.left == null ? root.data : findSmallestValue(root.left);
    }
    private void inOrder(Node node){
        if(node !=null){
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }
    public void inOrder(){
        inOrder(root);
    }
    private Node getValue(Node current, int data){
        if(current == null)
            return null;
        if(data < current.data){
            current.left = getValue(current.left, data);
        } else if (data > current.data) {
            current.right = getValue(current.right, data);
        }
        if(data == current.data){
            System.out.println();
            System.out.print(current.data);
            return current;
        }
        return current;
    }
    public void getValue(int data){
        getValue(root, data);
    }
}