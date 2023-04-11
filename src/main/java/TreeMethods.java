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

    static public boolean compareNodes(Node first, Node second){
        if(first == null && second == null){
            return true;
        }

        if(first == null || second == null){
            return false;
        }

        try {
            if (first.getValue() != second.getValue()) {
                return false;
            }

            if (first.getRight().getValue() != second.getRight().getValue()) {
                return false;
            }

            if (first.getLeft().getValue() != second.getLeft().getValue()) {
                return false;
            }
        }
        catch(NullPointerException ignored){
        }

        return compareNodes(first.getLeft(), second.getLeft()) && compareNodes(first.getRight(), second.getRight());
    }
}
