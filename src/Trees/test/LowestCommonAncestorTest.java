package Trees.test;

import Trees.LowestCommonAncestor;
import datatype.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LowestCommonAncestorTest {
    @Test
    void testLCA_TypicalCase() {
        /*
                 1
                / \
               2  (3) <-- LCA
              / \ / \
             4  5 6 (7)
                 / \
               (8)  9
        */
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node6.left = node8;
        node6.right = node9;

        // LCA가 될 수 있는 상태 조건 (3가지)
        // Case 1: 오른쪽 subtree & 왼쪽 subtree
        assertEquals(node3, LowestCommonAncestor.lowestCommonAncestor(root, node7, node8));
        // Case 2: 본인 & 오른쪽 subtree
        assertEquals(node3, LowestCommonAncestor.lowestCommonAncestor(root, node3, node7));
        // Case 3: 본인 & 왼쪽 subtree
        assertEquals(node3, LowestCommonAncestor.lowestCommonAncestor(root, node3, node8));
    }

    @Test
    void testLCA_OnlyTwoNodes() {
        //    1  <-- LCA
        //   /
        //  2
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root.left = node2;

        assertEquals(root, LowestCommonAncestor.lowestCommonAncestor(root, root, node2));
    }

    @Test
    void testLCA_OneNodeNotInTree() {
        //    1  <->  3
        //   /
        //  2
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        root.left = node2;

        assertNull(LowestCommonAncestor.lowestCommonAncestor(root, node2, node3));
    }
}