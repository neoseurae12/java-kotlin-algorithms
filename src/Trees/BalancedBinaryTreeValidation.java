package Trees;

import datatype.TreeNode;

public class BalancedBinaryTreeValidation {
    public boolean balancedBinaryTreeValidation(TreeNode root) {
        return getHeightImbalance(root) != -1;
    }

    private int getHeightImbalance(TreeNode node) {
        // node가 null일 경우 =? 높이: 0
        if (node == null) {
            return 0;
        }
        // 재귀적으로 왼쪽 & 오른쪽 하위 트리의 높이 구하기
        int leftHeight = getHeightImbalance(node.left);
        int rightHeight = getHeightImbalance(node.right);
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        // 현재 하위 트리의 높이 반환
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
