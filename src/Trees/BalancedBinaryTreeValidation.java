package Trees;

/*
- Trees > DFS
 */

import datatype.TreeNode;

public class BalancedBinaryTreeValidation {
    public static boolean balancedBinaryTreeValidation(TreeNode root) {
        return getHeightImbalance(root) != -1;
    }

    private static int getHeightImbalance(TreeNode node) {
        // Base case: node가 null일 경우 => 높이: 0
        if (node == null)
            return 0;

        // 재귀적으로 왼쪽 & 오른쪽 하위 트리의 높이 구하기
        int leftHeight = getHeightImbalance(node.left);
        int rightHeight = getHeightImbalance(node.right);
        // 만약 현재보다 아래에 위치한 subtree들 중에 하나라도 imbalanced라면 => 전체 tree가 imbalanced하다고 판정
        if (leftHeight == -1 || rightHeight == -1)
            return -1;
        // 만약 현재 subtree가 imbalanced라면 => 전체 tree가 imbalanced하다고 판정
        int heightDifference = Math.abs(leftHeight - rightHeight);
        if (heightDifference > 1)
            return -1;

        // 현재 subtree의 높이 반환
        return Math.max(rightHeight, leftHeight) + 1;
    }
}
