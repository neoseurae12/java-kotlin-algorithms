package Trees;

/*
- Trees > DFS
- 통합 테스트 시, static으로 인한 공유 상태 문제 발생
    - static -> 인스턴스 필드 로 변경함
 */

import datatype.TreeNode;

import java.util.HashMap;

public class BuildABinaryTreeFromPreorderAndInorderTraversals {

    // 최적화 - HashMap
    HashMap<Integer, Integer> inorderIndexesMap = new HashMap<>();
    int preorderIndex = 0;

    public TreeNode buildBinaryTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++)
            inorderIndexesMap.put(inorder[i], i);

        // 최적화 - 오른쪽 & 왼쪽 포인터
        return buildSubtree(0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode buildSubtree(int left, int right, int[] preorder, int[] inorder) {
        // Base Case: subarray의 empty 여부
        if (left > right)
            return null;

        // Preorder => 현재 노드 생성
        int val = preorder[preorderIndex];
        TreeNode subtreeRoot = new TreeNode(val);

        // preorderIndex++의 위치 조심!
        // buildSubtree()로 서브트리를 생성하기 '전'에 선언되어야 함
        preorderIndex++;

        // Inorder => 현재 노드을 기준 삼아 왼쪽 & 오른쪽 subtree 구분 및 연결
        int inorderIndex = inorderIndexesMap.get(val);
        subtreeRoot.left = buildSubtree(left, inorderIndex - 1, preorder, inorder);
        subtreeRoot.right = buildSubtree(inorderIndex + 1, right, preorder, inorder);

        return subtreeRoot;
    }
}
