package SlidingWindows;

/*
- Dynamic Sliding Window
    - "longest" & "specific condition"
- 1. character replacement을 최소로 하며 string을 uniform하게 만들 수 있는 가장 효율적인 방법이 무엇일지 생각해보자
    - 가장 frequent하게 나타나는 문자로 다른 모든 문자를 대체하는 것일 것이다!
    - 바꿔야 할 문자의 개수 = substring의 길이 - highestFreq
    - '바꿔야 할 문자의 개수' & k 비교
        - 바꿔야 할 문자의 개수 <= k => uniform 가능
        - 바꿔야 할 문자의 개수 > k => uniform 불가능
    - frequency 기록 => Hash Map
- 2. "longest" uniform substring 을 어떻게 판별할 것인지 생각해보자
    - Dynamic Sliding Window 의 "specific condition"
    - specific condition: '바꿔야 할 문자의 개수 <= k'
        - 만족 시 => expand
        - 불만족 시 => shrink / slide
            - 여기서는 어차피 '최대' 길이를 알아야 하다보니까 slide 를 하는 편이 더 최적임
 */

import java.util.HashMap;
import java.util.Map;

public class LongestUniformSubstringAfterReplacements {
    public static int longestUniformSubstringAfterReplacements(String s, int k) {
        int maxLen = 0;
        int highestFreq = 0;
        Map<Character, Integer> freqs = new HashMap<>();
        int left, right;
        left = right = 0;

        while (right < s.length()) {
            freqs.put(s.charAt(right), freqs.getOrDefault(s.charAt(right), 0) + 1);
            highestFreq = Math.max(highestFreq, freqs.get(s.charAt(right)));

            int numCharsToReplace = (right - left + 1) - highestFreq;
            // 적정한 window 를 초과했을 경우 => slide
            if (numCharsToReplace > k) {
                freqs.put(s.charAt(left), freqs.get(s.charAt(left)) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            // 적정한 window 이하일 경우 => expand
            right++;
        }

        return maxLen;
    }
}
