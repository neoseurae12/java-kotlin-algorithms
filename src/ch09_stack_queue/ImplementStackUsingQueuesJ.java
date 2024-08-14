package ch09_stack_queue;

/* Trial 1

- push() 시 전체 재정렬
    - 엘리먼트 삽입 시 시간 복잡도: O(n)
    - 다소 비효율적, BUT 이로써 큐의 연산만을 이용해 스택을 어렵지 않게 구현 가능
- 자바의 Queue
    - `Queue<Integer> queue = new LinkedList<>();`
- 일반적으로, 스택 => 연결 리스트, 큐 => 배열
    - 스택 => 연결 리스트
        - 삽입(push) 및 삭제(pop) 연산이 이뤄지는 곳이 동일함.
        - 연결 리스트 => 삽입 및 삭제 연산이 빠름
    - 큐 => 배열
        - 삽입(push) 연산은 큐의 뒷부분에서, 삭제(pop) 연산은 큐의 앞부분에서 이뤄짐. 즉, 삽입 및 삭제 연산이 이뤄지는 곳이 다름.
        - 배열 => 인덱스 기반 접근이 빠름
    - 하지만 본 풀이에서처럼 큐를 연결 리스트로 구현하는 것도 얼마든지 가능함
 */

import java.util.*;

public class ImplementStackUsingQueuesJ {
    Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        // 엘리먼트 삽입
        queue.add(x);
        // 전체 재정렬
        for (int i = 1; i < queue.size(); i++)
            queue.add(queue.remove());
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
