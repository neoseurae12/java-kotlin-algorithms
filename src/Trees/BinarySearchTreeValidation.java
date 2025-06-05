package Trees;

/*
- Trees > DFS
 */

import datatype.TreeNode;

public class BinarySearchTreeValidation {
    public static boolean binarySearchTreeValidation(TreeNode root) {
        // root 노드부터 validation 시작
        // 초기 lower bound, upper bound => (-infinity, +infinity)
        return isWithinBounds(root, null, null);
    }

    static boolean isWithinBounds(TreeNode node, Integer lowerBound, Integer upperBound) {
        // Base case: null인 노드 => true
        if (node == null)
            return true;

        // 현재 노드가 valid bounds에 해당하지 않을 경우 => false
        if (lowerBound != null && node.val <= lowerBound || upperBound != null && node.val >= upperBound)
            return false;

        // 현재 노드의 왼쪽, 오른쪽 subtree 모두의 validation 확인
        // minor optimization: 현재 노드의 왼쪽 subtree가 invalid하다면 => 오른쪽 subtree 볼 것 없이 곧바로 false 반환
        if (!isWithinBounds(node.left, lowerBound, node.val))
            return false;
        return isWithinBounds(node.right, node.val, upperBound);
    }
}
