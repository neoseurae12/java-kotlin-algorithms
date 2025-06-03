package Trees.test;

import Trees.BalancedBinaryTreeValidation;
import datatype.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalancedBinaryTreeValidationTest {

    @Test
    void testBalancedTree() {
        //       1
        //      / \
        //     2   3
        //    /
        //   4
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        assertTrue(BalancedBinaryTreeValidation.balancedBinaryTreeValidation(root));
    }

    @Test
    void testUnbalancedTree() {
        //       1
        //      /
        //     2
        //    /
        //   3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        assertFalse(BalancedBinaryTreeValidation.balancedBinaryTreeValidation(root));
    }

    @Test
    void testSingleNode() {
        TreeNode root = new TreeNode(1);
        assertTrue(BalancedBinaryTreeValidation.balancedBinaryTreeValidation(root));
    }

    @Test
    void testEmptyTree() {
        assertTrue(BalancedBinaryTreeValidation.balancedBinaryTreeValidation(null));
    }

    @Test
    void testBalancedDeepTree() {
        //       1
        //      / \
        //     2   4
        //    /     \
        //   5       6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        assertTrue(BalancedBinaryTreeValidation.balancedBinaryTreeValidation(root));
    }

    @Test
    void testUnbalancedDueToDeepLeaf() {
        //       5
        //      / \
        //     2   7
        //    / \   \
        //   1   4   9
        //      /   /
        //     3   6
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(6);

        assertFalse(BalancedBinaryTreeValidation.balancedBinaryTreeValidation(root));
    }
}