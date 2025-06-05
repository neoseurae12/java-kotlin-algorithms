package Trees.test;

import Trees.BinarySearchTreeValidation;
import datatype.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeValidationTest {
    @Test
    void testValidBST() {
        //       5
        //      / \
        //     3   7
        //    / \   \
        //   2   4   9
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(9);

        assertTrue(BinarySearchTreeValidation.binarySearchTreeValidation(root));
    }

    @Test
    void testInvalidBST_DuplicateValue() {
        //       5
        //      / \
        //     2   7
        //    /   / \
        //   1   7   9  <-- 7의 왼쪽 subtree에는 7보다 '작은' 수들이 와야 함. 즉, 같은 수도 안 됨.
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        assertFalse(BinarySearchTreeValidation.binarySearchTreeValidation(root));
    }

    @Test
    void testInvalidBST_OutOfBounds() {
        //       5
        //      / \
        //     2   7
        //    / \   \
        //   1   6   9  <-- 6은 5보다 큼 => 6은 5의 '오른쪽' subtree에 있어야 함
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(9);

        assertFalse(BinarySearchTreeValidation.binarySearchTreeValidation(root));
    }

    @Test
    void testSingleNode() {
        TreeNode root = new TreeNode(1);
        assertTrue(BinarySearchTreeValidation.binarySearchTreeValidation(root));
    }

    @Test
    void testEmptyTree() {
        assertTrue(BinarySearchTreeValidation.binarySearchTreeValidation(null));
    }
}