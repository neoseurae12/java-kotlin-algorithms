package Trees.test;

import Trees.RightmostNodesOfABinaryTree;
import datatype.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RightmostNodesOfABinaryTreeTest {

    @Test
    void testEmptyTree() {
        TreeNode root = null;
        List<Integer> expected = Collections.emptyList();
        assertEquals(expected, RightmostNodesOfABinaryTree.rightmostNodesOfABinaryTree(root));
    }

    @Test
    void testSingleNode() {
        TreeNode root = new TreeNode(1);
        List<Integer> expected = List.of(1);
        assertEquals(expected, RightmostNodesOfABinaryTree.rightmostNodesOfABinaryTree(root));
    }

    @Test
    void testCompleteBinaryTree() {
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        List<Integer> expected = List.of(1, 3, 6);
        assertEquals(expected, RightmostNodesOfABinaryTree.rightmostNodesOfABinaryTree(root));
    }

    @Test
    void testRightSkewedTree() {
        //  1
        //   \
        //    2
        //     \
        //      3
        //       \
        //        4
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        List<Integer> expected = List.of(1, 2, 3, 4);
        assertEquals(expected, RightmostNodesOfABinaryTree.rightmostNodesOfABinaryTree(root));
    }

    @Test
    void testLeftSkewedTree() {
        //        1
        //       /
        //      2
        //     /
        //    3
        //   /
        //  4
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        List<Integer> expected = List.of(1, 2, 3, 4);
        assertEquals(expected, RightmostNodesOfABinaryTree.rightmostNodesOfABinaryTree(root));
    }

    @Test
    void testBasicCase() {
        //         1
        //       /  \
        //     2     3
        //    / \   /
        //   4  5  6
        //  / \  \
        // 8  9   11
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.right = new TreeNode(11);

        List<Integer> expected = Arrays.asList(1, 3, 6, 11);
        assertEquals(expected, RightmostNodesOfABinaryTree.rightmostNodesOfABinaryTree(root));
    }
}