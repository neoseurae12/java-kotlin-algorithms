package Trees;

/*
- Trees > DFS > Iterative ver.
 */

import java.util.ArrayDeque;
import java.util.Deque;
import datatype.TreeNode;

public class InvertBinaryTreeIterative {
    public static TreeNode invertBinaryTreeIterative(TreeNode root) {
        // Base case: node가 null일 경우 => 반전(invert)할 것이 없음
        if (root == null)
            return root;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            // 1. process(node)
            // 현재 노드의 왼쪽과 오른쪽 하위 트리를 반전(invert)시키기
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            // -> 2. dfs(node.left) -> 3. dfs(node.right)
            // 스택에 왼쪽 & 오른쪽 하위 트리 넣기(push)
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }

        return root;
    }
}
