package Trees;

import java.util.Stack;
import datatype.TreeNode;

public class InvertBinaryTreeIterative {
    public TreeNode invertBinaryTreeIterative(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // 현재 노드의 왼쪽과 오른쪽 하위 트리를 바꾸기(swap)
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            // 스택에 왼쪽 & 오른쪽 하위 트리 넣기(push)
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }
}
