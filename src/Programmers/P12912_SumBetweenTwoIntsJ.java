package Programmers;

public class P12912_SumBetweenTwoIntsJ {
    public long solution(int a, int b) {
        int start = Math.min(a, b);  // `a > b ? b : a` -> Math.min() 변경 권장
        int end = Math.max(a, b);    // `a > b ? a : b` -> Math.max() 변경 권장
        long answer = 0;
        for (int i = start; i <= end; i++) {
            answer += i;
        }
        return answer;
    }
}
