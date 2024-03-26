package Programmers;

/*
- 수학적인 지식을 활용해 '등차수열의 합 공식'을 사용했으면 됐다.
- long 타입 => 오버플로우에 유의할 것.
 */

public class P12912_SumBetweenTwoIntsJ_1 {
    public long solution(int a, int b) {
        int start = Math.min(a, b);
        int end = Math.max(a, b);

        return sumFromStartToEnd(start, end);
    }

    private long sumFromStartToEnd(long start, long end) {
        // long numOfInts = end - start + 1;    // 개수
        // long avgOfInts = (start + end) / 2;  // 평균

        /*
        numOfInts, avgOfInts 각각의 변수로 선언하여 둘을 곱하는 식으로 코드를 짜면
        테스트 케이스 4, 5, 12, 14, 16에서 '실패'가 떠버린다.
        아마 오버플로우로 인한 오류인 것으로 추정됨.
        */

        // return avgOfInts * numOfInts;
        return (end - start + 1) * (start + end) / 2;   // 등차수열의 합 공식: 개수 * 평균
    }
}
