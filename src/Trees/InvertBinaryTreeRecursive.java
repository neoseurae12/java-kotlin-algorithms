package Trees;

/*
- Trees > DFS > Recursive ver.
 */

import datatype.TreeNode;

public class InvertBinaryTreeRecursive {
    public static TreeNode invertBinaryTreeRecursive(TreeNode root) {
        // Base case: node가 null일 경우 => 반전(invert)할 것이 없음
        if (root == null)
            return root;

        // 1. process(node)
        // 현재 노드의 왼쪽과 오른쪽 하위 트리를 반전(invert)시키기
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // -> 2. dfs(node.left) -> 3. dfs(node.right)
        // 왼쪽 & 오른쪽 하위 트리 재귀
        invertBinaryTreeRecursive(root.left);
        invertBinaryTreeRecursive(root.right);

        return root;
    }
}
