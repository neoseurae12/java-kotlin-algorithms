package SlidingWindows;

/*
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
