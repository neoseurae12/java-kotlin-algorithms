package FastAndSlowPointers;

/*
- Sequence Analysis
- "infinite loop (cycle)"
    => slow & fast pointers
    - 언젠가는 무조건 만난다!
    - Floyd's Cycle Detection algorithm
- 문제를 visualize 하자!
    - 다이어그램 등
    - visualize 하다보면 숨겨진 규칙 또는 해결책에 도달할 수 있는 data structure 를 발견하는 데 도움을 크게 얻을 수 있다.
- sequence 에서 next number 구하기
    - modulo 연산
    - divide 연산
    - '함수'로 구현
- 시간복잡도
    - O(logN)
        - 왜 이런 시간복잡도가 나오는지는 수학적으로 증명되는 거라 추가로 알아보자
- 공간복잡도
    - O(1)
 */

public class HappyNumber {
    public static boolean happy_number(int n) {
        int slow, fast;
        slow = fast = n;

        while (true) {
            slow = getNextNumber(slow); // 1 step 씩
            fast = getNextNumber(getNextNumber(fast));  // 2 steps 씩

            // Happy Number => 1 도달
            if (fast == 1)
                return true;
            // Unhappy Number => infinite loop => fast & slow pointers 로 판별 가능
            if (slow == fast)
                return false;
        }
    }

    public static int getNextNumber(int n) {
        int nextNumber = 0;

        while (n > 0) {
            int digit = n % 10;
            nextNumber += (int) Math.pow(digit, 2);
            n /= 10;
        }

        return nextNumber;
    }
}
