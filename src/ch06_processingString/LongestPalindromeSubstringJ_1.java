package ch06_processingString;

/* Trial 1

- 중심으로부터 확장하는 팰린드롬
- 투 포인터 (Two Pointer), 슬라이딩 윈도우 (Sliding Window)

- 짝수/홀수 길이의 팰린드롬
- 길이가 1인 경우에 대한 예외처리
- 조건 + 반복 => while 문 고려
 */

public class LongestPalindromeSubstringJ_1 {
    int maxLen = 0;
    int start;
    // end => 곧 start + maxLen - 1 이므로 굳이 선언하는 것을 생략함

    public void extendPalindrome(String s, int j, int k) {    // 1, 2
        // 팰린드롬 확장 조건: 투 포인터가 유효한 범위 내에 있음 && 양쪽 끝 문자가 일치함
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;    // 0
            k++;    // 3
        }

        // 기존 maxLen 보다 더 긴 팰린드롬 발견 시 값 갱신
        int subLen = k - j - 1;   // 2
        if (subLen > maxLen) {
            maxLen = subLen;
            start = j + 1;   // 1
        }
    }

    public String longestPalindrome(String s) {
        // 예외 처리: 길이가 1인 경우
        if (s.length() < 2) return s;

        // 팰린드롬의 중심(center) 조사
        for (int i = 0; i < s.length() - 1; i++) {
            extendPalindrome(s, i, i + 1); // '짝수' 길이의 팰린드롬
            extendPalindrome(s, i, i + 2); // '홀수' 길이의 팰린드롬
        }

        return s.substring(start, start + maxLen);    // 주의: substring() 에서 endIndex 는 포함되지 않는다.
    }
}
