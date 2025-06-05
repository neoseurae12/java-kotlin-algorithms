package Trees.test;

import Trees.BuildABinaryTreeFromPreorderAndInorderTraversals;
import datatype.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuildABinaryTreeFromPreorderAndInorderTraversalsTest {
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    @Test
    public void testBuildBinaryTree_basic() {
        BuildABinaryTreeFromPreorderAndInorderTraversals builder = new BuildABinaryTreeFromPreorderAndInorderTraversals();

        int[] preorder = {5, 9, 2, 3, 4, 7};
        int[] inorder = {2, 9, 5, 4, 3, 7};

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(9);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(7);

        TreeNode expected = root;
        TreeNode result = builder.buildBinaryTree(preorder, inorder);

        assertTrue(isSameTree(expected, result));
    }

    @Test
    public void testBuildBinaryTree_singleNode() {
        BuildABinaryTreeFromPreorderAndInorderTraversals builder = new BuildABinaryTreeFromPreorderAndInorderTraversals();

        int[] preorder = {1};
        int[] inorder = {1};

        TreeNode expected = new TreeNode(1);
        TreeNode result = builder.buildBinaryTree(preorder, inorder);

        assertTrue(isSameTree(expected, result));
    }

    @Test
    public void testBuildBinaryTree_empty() {
        BuildABinaryTreeFromPreorderAndInorderTraversals builder = new BuildABinaryTreeFromPreorderAndInorderTraversals();

        int[] preorder = {};
        int[] inorder = {};

        TreeNode result = builder.buildBinaryTree(preorder, inorder);

        assertNull(result);
    }
}