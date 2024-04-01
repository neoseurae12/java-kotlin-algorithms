package ch06_processingString;

/* Trial 2
- 문자열(String) 직접 비교

- 정규식
- StringBuilder
- StringBuilder StringBuilder.reverse()
- String String.replaceAll(String regex, String replacement)

- StringBuilder: 스레드 안전(Thread Safe)하지 않음에 유의
- '클래스'를 비교 => Trial 1에서 '원시형'을 비교할 때보다 속도가 느려짐
- '정규식'을 사용 => 속도 저하 커짐
 */

public class ValidPalindromeJ_2 {
    public boolean isPalindrome(String s) {
        // 유효한 문자만 추출 & 소문자로 변경
        String s_filtered = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase(); // 정규식 사용
        // 문자열 뒤집기
        String s_reversed = new StringBuilder(s_filtered).reverse().toString();
        // 두 문자열 비교
        return s_filtered.equals(s_reversed);
    }
}
