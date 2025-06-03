package Trees.test;

import Trees.InvertBinaryTreeIterative;
import Trees.InvertBinaryTreeRecursive;
import datatype.TreeNode;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvertBinaryTreeTest {

    private boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null || a.val != b.val) return false;
        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }

    @Nested
    class RecursiveTests {
        @Test
        void testInvertBinaryTree_basic() {
        /*
                Input Tree:          Inverted Tree:
                     1                    1
                   /   \                /   \
                  2     3     =>       3     2
                 / \                        / \
                4   5                      5   4
         */
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);

            TreeNode expected = new TreeNode(1);
            expected.left = new TreeNode(3);
            expected.right = new TreeNode(2);
            expected.right.left = new TreeNode(5);
            expected.right.right = new TreeNode(4);

            TreeNode result = InvertBinaryTreeRecursive.invertBinaryTreeRecursive(root);
            assertTrue(isSameTree(result, expected));
        }

        @Test
        void testInvertBinaryTree_singleNode() {
            TreeNode root = new TreeNode(1);
            TreeNode result = InvertBinaryTreeRecursive.invertBinaryTreeRecursive(root);

            assertEquals(1, result.val);
            assertNull(result.left);
            assertNull(result.right);
        }

        @Test
        void testInvertBinaryTree_nullRoot() {
            assertNull(InvertBinaryTreeRecursive.invertBinaryTreeRecursive(null));
        }
    }

    @Nested
    class IterativeTests {
        @Test
        void testInvertBinaryTree_basic() {
        /*
                Input Tree:          Inverted Tree:
                     1                    1
                   /   \                /   \
                  2     3     =>       3     2
                 / \                        / \
                4   5                      5   4
         */
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);

            TreeNode expected = new TreeNode(1);
            expected.left = new TreeNode(3);
            expected.right = new TreeNode(2);
            expected.right.left = new TreeNode(5);
            expected.right.right = new TreeNode(4);

            TreeNode result = InvertBinaryTreeIterative.invertBinaryTreeIterative(root);
            assertTrue(isSameTree(result, expected));
        }

        @Test
        void testInvertBinaryTree_singleNode() {
            TreeNode root = new TreeNode(1);
            TreeNode result = InvertBinaryTreeIterative.invertBinaryTreeIterative(root);

            assertEquals(1, result.val);
            assertNull(result.left);
            assertNull(result.right);
        }

        @Test
        void testInvertBinaryTree_nullRoot() {
            assertNull(InvertBinaryTreeIterative.invertBinaryTreeIterative(null));
        }
    }
}