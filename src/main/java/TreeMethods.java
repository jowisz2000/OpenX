import java.util.ArrayList;

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

    static public ArrayList<Node> findLongestBranch(Node current){
        if (current == null){
            return new ArrayList<>();
        }

        ArrayList<Node> leftBranch = findLongestBranch(current.getLeft());
        ArrayList<Node> rightBranch = findLongestBranch(current.getRight());

        if(leftBranch.size() > rightBranch.size()){
            leftBranch.add(current);
            return leftBranch;
        }
        else{
            rightBranch.add(current);
            return rightBranch;
        }

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
        n2.setRight(n3);
        n2.setLeft(n4);
        n3.setRight(n5);
        n3.setLeft(n6);
        n4.setRight(n7);

        numberOfLeaves(n1);
        System.out.println("Number fo nodes wothout child: "+sumOfNodesWithoutChild+"\n-------------");
        ArrayList<Node> branch = findLongestBranch(n1);
        for(Node i:branch){
            System.out.println(i.getValue());
        }

        int length = branch.size()-1;
        System.out.println("Length of the longest branch: " + length);
    }
}
