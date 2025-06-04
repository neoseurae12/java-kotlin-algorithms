package Trees;

/*
- Trees > BFS
    - Binary Tree에 "인덱싱"하기
 */

import datatype.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class WidestBinaryTreeLevel {
    public static class Pair {
        TreeNode node;
        int index;

        public Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public static int widestBinaryTreeLevel(TreeNode root) {
        int maxWidth = 0;

        if (root == null)
            return maxWidth;

        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int leftMostIndex = queue.peek().index;
            int rightMostIndex = leftMostIndex;
            for (int i = 0; i < levelSize; i++) {
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                int index = pair.index;

                if (node.left != null)
                    queue.offer(new Pair(node.left, index * 2 + 1));
                if (node.right != null)
                    queue.offer(new Pair(node.right, index * 2 + 2));

                rightMostIndex = index;
            }
            maxWidth = Math.max(maxWidth, rightMostIndex - leftMostIndex + 1);
        }

        return maxWidth;
    }
}
