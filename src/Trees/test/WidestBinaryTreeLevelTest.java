package Trees.test;

import Trees.WidestBinaryTreeLevel;
import datatype.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WidestBinaryTreeLevelTest {
    @Test
    void testFullBinaryTree() {
        //     1
        //    / \
        //   2   3
        //  / \ / \
        // 4  5 6  7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        assertEquals(4, WidestBinaryTreeLevel.widestBinaryTreeLevel(root));
    }

    @Test
    void testSparseTree() {
        //           1
        //         /   \
        //        2     3
        //       / \     \
        //      4   5     7
        //     / \   \   /
        //    8   9  11 14
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.right = new TreeNode(11);
        root.right.right.left = new TreeNode(14);

        assertEquals(7, WidestBinaryTreeLevel.widestBinaryTreeLevel(root));
    }

    @Test
    void testSingleNode() {
        TreeNode root = new TreeNode(1);
        assertEquals(1, WidestBinaryTreeLevel.widestBinaryTreeLevel(root));
    }

    @Test
    void testNullTree() {
        assertEquals(0, WidestBinaryTreeLevel.widestBinaryTreeLevel(null));
    }
}