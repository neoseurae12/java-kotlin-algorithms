package ch06_processingString;

/* Trial 0
- 정규식
- StringIndexOutOfBoundsException 에러에 유의하여 적절히 처리
 */

public class ValidPalindromeJ {
    /*
    [x] 모든 문자 '소문자' 처리
    [x] non-alphanumeric(문자+숫자 이외의) 문자들 없애기
    [x] 앞뒤로 한 칸씩 옮기며 비교
     */

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");   // 정규식 => non-alphanumeric 문자들 제거

        if (s.isEmpty()) return true;   // StringIndexOutOfBoundsException 에러 처리

        int startIndex = 0;
        int endIndex = s.length() - 1;  // s에 대한 변경이 앞에서 이뤄지기 때문에 endIndex를 변경 '뒤'에 구해줘야 함

        for (int i = startIndex; i <= s.length() / 2; i++) {
            if (s.charAt(startIndex + i) != s.charAt(endIndex - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input1 = "A man, a plan, a canal: Panama";
        String input2 = "race a car";
        String input3 = " ";
        boolean output = isPalindrome(input3);
        System.out.println(output);
    }
}
