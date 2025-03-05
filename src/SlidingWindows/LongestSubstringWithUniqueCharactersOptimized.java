package SlidingWindows;

/*
- Optimization
    - duplicate 가 제외될 때까지 while 돌려서 left 포인터 옮기는 게 아니라, duplicate 가 제외되는 위치로 left 포인터를 바로 옮겨버림
    - Hash Map => 특정 문자의 previous occurrence 의 인덱스 기록
    - 특정 문자의 previous index 가 window 안에 있는가 체크!
    - 시간복잡도: O(N)
    - 공간복잡도: O(M)
 */

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithUniqueCharactersOptimized {
    public static int longestSubstringWithUniqueCharsOptimized(String s) {
        int maxLen = 0;

        int left, right;
        left = right = 0;

        Map<Character, Integer> prevIndexes = new HashMap<>();

        while (right < s.length()) {
            if (prevIndexes.containsKey(s.charAt(right)) && prevIndexes.get(s.charAt(right)) >= left)
                left = prevIndexes.get(s.charAt(right)) + 1;

            prevIndexes.put(s.charAt(right), right);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}
