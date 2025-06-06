package Trees.test;

import Trees.MaximumSumOfAContinuousPathInABinaryTree;
import datatype.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSumOfAContinuousPathInABinaryTreeTest {
    @Test
    void testBasicCase() {
        /*
                     5
                    / \
                 -10   8
                / \   / \
               1  -7 9   7
              /   /     / \
             11 -1     6  -3
         */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(-10);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(-7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(11);
        root.left.right.left = new TreeNode(-1);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(-3);

        MaximumSumOfAContinuousPathInABinaryTree solver = new MaximumSumOfAContinuousPathInABinaryTree();
        assertEquals(30, solver.maxPathSum(root));
    }

    @Test
    void testBalancedTree() {
        /*
              1
             / \
            2   3
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        MaximumSumOfAContinuousPathInABinaryTree solver = new MaximumSumOfAContinuousPathInABinaryTree();
        assertEquals(6, solver.maxPathSum(root));   // 2 + 1 + 3
    }

    @Test
    void testWithNegativeValues() {
        /*
              -10
              /  \
             9   20
                 / \
                15  7
        */
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaximumSumOfAContinuousPathInABinaryTree solver = new MaximumSumOfAContinuousPathInABinaryTree();
        assertEquals(42, solver.maxPathSum(root)); // 15 + 20 + 7
    }

    @Test
    void testSingleNode() {
        TreeNode root = new TreeNode(5);

        MaximumSumOfAContinuousPathInABinaryTree solver = new MaximumSumOfAContinuousPathInABinaryTree();
        assertEquals(5, solver.maxPathSum(root));
    }

    @Test
    void testAllNegativeValues() {
        /*
              -3
             /  \
           -2   -1
        */
        TreeNode root = new TreeNode(-3);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-1);

        MaximumSumOfAContinuousPathInABinaryTree solver = new MaximumSumOfAContinuousPathInABinaryTree();
        assertEquals(-1, solver.maxPathSum(root));
    }

    @Test
    void testSkewedTree() {
        /*
        10
          \
           20
             \
              30
        */
        TreeNode root = new TreeNode(10);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(30);

        MaximumSumOfAContinuousPathInABinaryTree solver = new MaximumSumOfAContinuousPathInABinaryTree();
        assertEquals(60, solver.maxPathSum(root)); // 10 + 20 + 30
    }
}