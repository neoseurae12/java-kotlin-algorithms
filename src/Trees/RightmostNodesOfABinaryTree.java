package Trees;

import datatype.TreeNode;

/*
- Trees > BFS
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RightmostNodesOfABinaryTree {
    public static List<Integer> rightmostNodesOfABinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 각 level의 노드 개수를 기억해서 반복하기
            int levelSize = queue.size();

            // 현재 level의 모든 자식 노드들을 큐에 집어넣기
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

                // 현재 level의 가장 rightmost한 노드일 경우 => result에 기록하기
                if (i == levelSize - 1)
                    result.add(node.val);
            }
        }

        return result;
    }
}
