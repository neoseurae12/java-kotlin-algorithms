package FastAndSlowPointers;

/*
- Cycle Detection
    - Perfect Cycle
    - Delayed Cycle
    - No Cycle
- 직관적인 접근 방법 => Hash Set
- 시간복잡도: O(N)
- 공간복잡도: O(N) -- cost of extra space
 */

import datatype.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListLoopHashSet {
    public static boolean linkedListLoopHashSet(ListNode head) {
        ListNode node = head;
        Set<ListNode> visited = new HashSet<>();

        while (node != null) {
            if (visited.contains(node))
                return true;

            visited.add(node);
            node = node.next;
        }

        return false;
    }
}
