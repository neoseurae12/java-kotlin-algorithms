package ch09_stack_queue;

/* Trial 1

- 큐를 이용한 스택 구현 (ImplementStackUsingQueuesJ.java) vs. 스택을 이용한 큐 구현 (본 문제)
    - 큐를 이용한 스택 구현
        - 추가 공간 필요 없었음
            - 원래의 큐에 엘리먼트를 삽입 후 전체를 재정렬하는 방식
        - push() 연산이 복잡한 편
    - 스택을 이용한 큐 구현
        - 추가 공간 필요함 => "스택 2개"
            - 큐 => 가장 먼저 삽입된 아이템을 끄집어 내야 함
            - BUT 스택 1개만을 사용한다면 아무리 추가, 삭제를 반복해도 가장 마지막에 삽입된 아이템만 넣고 뺄 수 있을 뿐임
        - pop() 연산이 복잡한 편
- pop() & peek()
    - '추출 스택에 대한 선처리'라는 겹치는 작업 => peek() 에서 담당
    - pop() => peek() 호출 + 추출
- peek() 연산의 분할 상환 분석에 따른 시간 복잡도: O(1)
    - 추출 스택 `output`의 값이 텅텅 비기 전까지는 다시 삽입을 하지 않기 때문
- 추출 스택에 대한 선처리
    - 추출 스택이 텅텅 비게 되면 삽입 스택의 엘리먼트들을 추출 스택에 옮겨 들이붓는다.
    - 이때 삽입 스택의 엘리먼트들이 추출 스택에 '역순으로' 저장되게 된다.
- 시행착오
    - 개선 전
        - 삽입 시 => '삽입 스택 <- 추출 스택'
        - 추출 시 => '삽입 스택 -> 추출 스택'
        - 즉, 엘리먼트들에 대한 옮기는 행위가 삽입 스택 & 추출 스택 사이에서 "양방향"으로 진행됨
        - 치명적인 단점: 최악의 경우 삽입 연산의 시간 복잡도가 O(n) 가 될 수 있음
    - 개선 후
        - 삽입 시 => 삽입 스택에 단순 추가
        - 추출 시 => (추출 스택이 텅텅 비게 될 경우에만 한해) '삽입 스택 -> 추출 스택'
        - 즉, 엘리먼트들에 대한 옮기는 행위가 '삽입 스택 -> 추출 스택'의 "단방향"으로만 진행됨
        - 장점: 삽입 연산의 시간 복잡도가 항상 O(1) 임
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQueueUsingStacksJ {
    // 총 2개의 스택
    // 1) '삽입'할 때 사용하는 스택
    Deque<Integer> input = new ArrayDeque<>();
    // 2) '추출'할 때 사용하는 스택
    Deque<Integer> output = new ArrayDeque<>();

    public void push(int x) {
        // 삽입
            // 삽입 스택에 단순 추가
        input.push(x);
    }

    public int pop() {
        // 추출
            // pop() & peek() => 어차피 '가장 먼저 삽입된 아이템'이라는 '같은' 데이터에 대한 처리
            // pop() => peek() (추출 스택에 대한 선처리) + 추출
        peek();

        return output.pop();
    }

    public int peek() {
        // 추출 스택에 대한 선처리
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.peek();
    }

    public boolean empty() {
        // 두 개의 스택 모두가 비어 있어야 한다.
        return input.isEmpty() && output.isEmpty();
    }
}
