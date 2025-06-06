package Trees;

/*
- Trees > DFS
 */

import datatype.TreeNode;

public class MaximumSumOfAContinuousPathInABinaryTree {
    // sum이 '음수'일 경우 고려 => 초기화 값: 0 (X), Integer.MIN_VALUE (O)
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxSum;
    }

    private int maxPathSumHelper(TreeNode node) {
        if (node == null)
            return 0;

        // 왼쪽 & 오른쪽 path 각각의 sum 구하기
        // sum이 '음수'일 경우 => max sum을 구하는 데 전혀 도움 안 됨 => sum에서 제외 => 0으로 초기화
        int leftSum = Math.max(maxPathSumHelper(node.left), 0);
        int rightSum = Math.max(maxPathSumHelper(node.right), 0);

        // maxSum 업데이트하기
        maxSum = Math.max(maxSum, node.val + leftSum + rightSum);

        // 현재 node가 path의 루트인 경우에서, single + continuous path의 최댓값 반환하기
        return node.val + Math.max(leftSum, rightSum);
    }
}
