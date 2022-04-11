public class Node {
    Node left;
    Node right;
    String value;

    public Node(String value){
        this.value = value;
    }
    public Node(String value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
