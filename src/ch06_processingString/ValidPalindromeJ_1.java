package ch06_processingString;

public class ValidPalindromeJ_1 {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        // 서로 중앙을 향해 이동해나가다 겹치는 지점에 도달하면 종료하는 종료 조건
        while (start < end) {
            // 영숫자인지 판별
                // 영숫자가 아니라면 => 그냥 pass
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else {    // 영숫자라면 => 소문자로 변경 후 비교
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    // 하나라도 일치하지 않을 시 => 바로 false 리턴 및 종료
                    return false;
                }
                // 비교 후 마저 진행
                start++;
                end--;
            }
        }

        // 모두 일치할 시 => true 리턴 (즉, 팰린드롬)
        return true;
    }
}
