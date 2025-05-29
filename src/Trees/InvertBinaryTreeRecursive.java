package Trees;

import datatype.TreeNode;

public class InvertBinaryTreeRecursive {
    public TreeNode invertBinaryTreeRecursive(TreeNode root) {
        // node가 null일 경우 =? 반전(invert)할 것이 없음
        if (root == null) {
            return root;
        }
        // 현재 노드의 왼쪽과 오른쪽 하위 트리를 바꾸기(swap)
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        // 재귀적으로 왼쪽 & 오른쪽 하위 트리를 반전(invert)시키기
        invertBinaryTreeRecursive(root.left);
        invertBinaryTreeRecursive(root.right);
        return root;
    }
}
