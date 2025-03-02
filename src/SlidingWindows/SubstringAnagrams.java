package SlidingWindows;

/*
- Sliding Window
    - Two-pointer 패턴의 일종
        - left & right 포인터 => iterable한 자료구조(e.g. 문자열, 배열 등) 내 window의 bounds 정의
        - window => subcomponent of the data structure
        - 자료구조 내부를 unidirectional하게 slide 해나감
    - subcomponent 찾기에 유리한 방식
        - 원래: two nested loops 사용해서 O(N^2) 이상 소요
        - Sliding Window 사용 시: O(N)만에 원하는 subcomponent 탐색 가능
    - 용어
        - expand => right++
        - shrink => left++
        - slide => right++ & left++
    - 종류 (2가지)
        - Fixed Sliding Window
        - Dynamic Sliding Window
    - Fixed Sliding Window
        - 일정한 길이의 subcomponent 찾기
    - Dynamic Sliding Window
        - 특정 조건을 만족하는 가장 짧은/긴 subcomponent 찾기
            - 조건 만족 시 => expand
            - 조건 불만족 시 => shrink
    - left & right 포인터의 움직임에 주목할 것
    - 실세계 예제: Buffering in video streaming

- Fixed Sliding Window
    - Two-pointers; left & right
- 배열 => frequency of each letter 기록
- 최적화: 만약 s의 길이 < t의 길이 일 경우 => 바로 0 반환
- 시간복잡도: O(N)
- 공간복잡도: O(1)
 */

import java.util.Arrays;

public class SubstringAnagrams {
    public static final int ALPHABET = 26;

    public static int substringAnagrams(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();

        // 최적화: s의 길이 < t의 길이 => 0 반환
        if (lenS < lenT)
            return 0;

        int[] windowFreqs = new int[ALPHABET];
        int[] expectedFreqs = new int[ALPHABET];
        int cnt = 0;

        for (char c : t.toCharArray())  {
            expectedFreqs[c - 'a']++;
        }

        int left, right;
        left = right = 0;

        while (right < lenS) {
            windowFreqs[s.charAt(right) - 'a']++;

            if (right - left + 1 == lenT) {
                if (Arrays.equals(windowFreqs, expectedFreqs)) {
                    cnt++;
                }

                windowFreqs[s.charAt(left) - 'a']--;
                left++;
            }

            right++;
        }

        return cnt;
    }
}
