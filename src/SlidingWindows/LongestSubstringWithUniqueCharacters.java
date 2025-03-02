package SlidingWindows;

/*
- 풀이 방식에 따른 복잡도 차이
    - 브루트포스 방식
        - Hash Set 를 이용하여 substring 의 uniqueness 체크하기 => O(N)
        - 가능한 "모든" substring 에 대하여 반복하기 => O(N^2)
        => 시간복잡도: O(N^3)
    - Sliding window 방식
        - 시간복잡도: O(N)
        - 공간복잡도: O(M)
- Sliding window
    - "longest" & "satisfy a specific condition" => Dynamic Sliding Window
    - 본 문제에서의 window 의 종류 (2가지)
        - A. unique character 들로만 구성된 window
            - right 포인터 확장
        - B. duplicate character 가 존재하는 window
            - left 포인터 축소 (duplicate 가 없어질 때까지)
    - 핵심 요소
        - left & right 포인터
        - Hash Set
        - maxLen
 */

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithUniqueCharacters {
    public static int longestSubstringWithUniqueChars(String s) {
        int maxLen = 0;
        int left, right;
        left = right = 0;
        Set<Character> charFreqs = new HashSet<>();

        while (right < s.length()) {
            while (charFreqs.contains(s.charAt(right))) {
                charFreqs.remove(s.charAt(left));
                left++;
            }

            charFreqs.add(s.charAt(right));
            right++;
            maxLen = Math.max(maxLen, s.substring(left, right).length());
        }

        return maxLen;
    }
}
