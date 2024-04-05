package ch06_processingString;

/* Trial 1
- 문자 배열(array of characters)로 스왑(Swap)
 */

public class ReverseStringJ {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        // 서로 중앙을 향해 이동해나가다 겹치는 지점에 도달하면 종료하는 종료 조건
        while (start < end) {
            // 스왑
            char tmp = s[start];    // 임시 변수
            s[start] = s[end];
            s[end] = tmp;

            start++;
            end--;
        }
    }
}
