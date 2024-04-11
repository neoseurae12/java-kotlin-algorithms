package ch06_processingString;

/* Trial 0

- '재귀'를 사용해서 그런지, 그리 직관적이지 않고 애매한 풀이
 */

public class LongestPalindromeSubstringJ {
    int maxLen = 0;
    int maxStart;
    int maxEnd;

    public String longestPalindrome(String s) {
        int len = s.length();

        if (len < 2) {
            return s;
        }

        for (int i = 0; i < len; i++) {
            extendPalindrome(s, i, i+1);    // 짝수 길이
            extendPalindrome(s, i, i+2);    // 홀수 길이
        }

        return s.substring(maxStart, maxEnd + 1);
    }

    public void extendPalindrome(String s, int start, int end) {
        if (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            extendPalindrome(s, start-1, end+1);

            int subLen = end - start + 1;
            if (subLen > maxLen) {
                maxLen = subLen;
                maxStart = start;
                maxEnd = end;
            }
        }
    }
}