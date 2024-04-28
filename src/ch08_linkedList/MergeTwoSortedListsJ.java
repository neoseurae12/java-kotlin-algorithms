package ch08_linkedList;

/* Trial 1

- '재귀 구조'로 연결한 방식의 풀이
    - [장점] 풀이가 명확함 / 코드가 길지 않음
    - [단점] 짧은 코드에 많은 내용이 함축되어 있어 이해하기가 쉽지 않음. 특히, 재귀가 포함되어 더욱 까다로움.
- "정렬된 리스트"
    - 사실상 병합 정렬의 마지막 조합과 동일한 방식으로 풀이 가능
    - 첫 번째부터 비교하면서 리턴하는 방식
 */

import datatype.ListNode;

public class MergeTwoSortedListsJ {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val > list2.val) {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        } else {
            list1.next = mergeTwoLists(list2, list1.next);
            return list1;
        }
    }
}
