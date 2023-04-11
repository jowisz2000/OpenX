import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TreeMethodsTest {
//    First tree:
//         0
//        / \
//       1   2
//          /  \
//         4    3
//          \  / \
//          7  5  6
        Node root1 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

//      Second tree:
//                      5
//                    /   \
//                   3     7
//                  /\    / \
//                  2 5   1  0
//                           /\
//                          2  8
//                              \
//                               5
        Node root2 = new Node(5);
        Node n8 = new Node(3);
        Node n9 = new Node(7);
        Node n10 = new Node(2);
        Node n11 = new Node(5);
        Node n12 = new Node(1);
        Node n13 = new Node(0);
        Node n14 = new Node(2);
        Node n15 = new Node(8);
        Node n16 = new Node(5);

        @BeforeEach
        void setLeaves(){
//          set structure of trees
            root1.setLeft(n1);
            root1.setRight(n2);
            n2.setRight(n3);
            n2.setLeft(n4);
            n3.setRight(n5);
            n3.setLeft(n6);
            n4.setRight(n7);

            root2.setLeft(n8);
            root2.setRight(n9);
            n8.setLeft(n10);
            n8.setRight(n11);
            n9.setLeft(n12);
            n9.setRight(n13);
            n13.setLeft(n14);
            n13.setRight(n15);
            n15.setRight(n16);
        }

    @Test
    void testNumberOfLeaves() {
        TreeMethods.numberOfLeaves(root1);
        assertEquals(TreeMethods.sumOfNodesWithoutChild, 4);
//      sumOfNodesWithoutChild variable is static, so it needs to be set to 0 after every invocation of method
        TreeMethods.sumOfNodesWithoutChild = 0;
        TreeMethods.numberOfLeaves(null);
        assertEquals(TreeMethods.sumOfNodesWithoutChild, 0);
        TreeMethods.sumOfNodesWithoutChild = 0;
        TreeMethods.numberOfLeaves(root2);
        assertEquals(TreeMethods.sumOfNodesWithoutChild, 5);
    }

    @Test
    void testFindingLongestBranch(){
//      there are n-1 edges in list of n elements
        ArrayList<Node> firstBranch = TreeMethods.findLongestBranch(root1);
        assertEquals(firstBranch.size()-1, 3);
        ArrayList<Node> secondBranch = TreeMethods.findLongestBranch(root2);
        assertEquals(secondBranch.size()-1, 4);
        ArrayList<Node> thirdBranch = TreeMethods.findLongestBranch(null);
        assertEquals(thirdBranch.size(), 0);
    }

    @Test
    void TestComparingNodes() {
            assertFalse(TreeMethods.compareNodes(root1, root2));
            assertTrue(TreeMethods.compareNodes(root1, root1));
            assertTrue(TreeMethods.compareNodes(root2, root2));
            assertFalse(TreeMethods.compareNodes(root1, null));
            assertFalse(TreeMethods.compareNodes(root2, null));
            assertTrue(TreeMethods.compareNodes(null, null));
    }
}