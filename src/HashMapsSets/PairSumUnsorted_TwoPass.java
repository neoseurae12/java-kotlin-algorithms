package HashMapsSets;

/*
- Hash Map
    - 특징
        - 키 -> 값
        - Hash Map 의 모든 키 값은 unique (중복 X) 하다
        - 순서를 보장하지 않음
    - 시간 복잡도
        - 빠른 접근, 삽입, 삭제
        - 최선: O(1)
        - 최악: O(N) -- 해시 값의 충돌이 발생했을 경우
    - 주요 시나리오
        - 딕셔너리
        - 빈도(frequency) 측정
        - 키-값 저장
        - 빠른 조회
        - 데이터 캐싱 (e.g. 웹 브라우저 캐시)
- 풀이 방식에 따른 시간 및 공간 복잡도의 차이
    - 브루트 포스 방식 => O(N^2)
    - Pair Sum - Sorted 버전 방식 => O(N*logN) -- 정렬
    - Pair Sum - Unsorted 버전 방식
        - 시간복잡도: O(N) -- 가장 빠름!
        - 공간복잡도: O(N)
- "Complement"
    - x + y = target 인 (x, y) 페어를 찾아야 함
    - x와 y, 둘 중 하나만 알아도 다른 나머지 하나를 알게 됨에 주목
    - 즉, y = target - x => "y는 x의 'complement' 이다"
- Hash Map => [현재 숫자의 complement -> 그 인덱스] 의 빠른 조회
- Two passes
    - 1. [수 -> 인덱스]로 Hash Map 채워놓기
    - 2. Hash Map 에 현재 요소의 complement 가 존재하는지 검사하기. 만약 있다면, [현재 인덱스, complement의 인덱스] 반환.
- Hash Map & Sets 에 대해 더 알아보기
    - 해시 함수
    - 충돌 & 충돌 처리 기법
    - Load Factor & Rehashing
 */

import java.util.HashMap;
import java.util.Map;

public class PairSumUnsorted_TwoPass {
    public static int[] pairSumUnsortedTwoPass(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        // 1. [수 -> 인덱스]로 Hash Map 채워놓기
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        // 2. Hash Map에 현재 요소의 complement 가 존재하는지 검사하기
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // 있다면 => return [현재 인덱스, complement의 인덱스]
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {map.get(complement), i};
            }
        }

        // 없다면 => 빈 배열 반환
        return new int[] {};
    }
}
