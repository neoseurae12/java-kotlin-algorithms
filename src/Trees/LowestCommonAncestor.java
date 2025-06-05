package Trees;

/*
- Trees > DFS
 */

import datatype.TreeNode;

public class LowestCommonAncestor {
    static TreeNode lca;

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return lca;
    }

    private static boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        // Base Case: null 노드(p도 q도 아니고, subtree도 없음)인 경우 => false 반환
        if (node == null)
            return false;

        // 위치 조건 (3가지)
        int nodeIsPOrQ = (node == p || node == q) ? 1 : 0;
        int leftContainsPOrQ = dfs(node.left, p, q) ? 1 : 0;
        int rightContainsPOrQ = dfs(node.right, p, q) ? 1 : 0;

        // 위치 조건 3가지 중 2가지 만족 => LCA
        if (nodeIsPOrQ + leftContainsPOrQ + rightContainsPOrQ == 2)
            lca = node;

        // 위치 조건 3가지 중 하나라도 만족 => true 반환
        return nodeIsPOrQ + leftContainsPOrQ + rightContainsPOrQ > 0;
    }
}
