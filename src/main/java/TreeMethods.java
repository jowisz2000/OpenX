public class TreeMethods {
    static int sumOfNodesWithoutChild = 0;
    static public void numberOfLeaves(Node current){
        if(current == null){
            return;
        }

        if(current.getLeft() == null && current.getRight() == null){
            sumOfNodesWithoutChild++;
        }

        numberOfLeaves(current.getLeft());
        numberOfLeaves(current.getRight());
    }

    public static void main(String[] args){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n5.setLeft(n6);
        n5.setRight(n7);

        numberOfLeaves(n1);
        System.out.println(sumOfNodesWithoutChild);
    }
}
