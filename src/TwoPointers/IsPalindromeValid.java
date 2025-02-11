package TwoPointers;

/*
- Two-pointer 전략 중 'Inward Traversal'에 해당
- 핵심 관건
    - 1) palindrome 의 여부를 탐지하기
    - 2) non-alphanumeric character 들을 처리하기
- `while (left < right)`
    - 홀수 길이, 짝수 길이 상관없이 모두 커버 가능
    - NO: `while (left != right)`
- NOTE: `isLetterOrDigit(char ch)`는 유니코드의 원래 16비트(char) 설계에서 표현할 수 없는 문자를 처리할 수 없다.
    - 즉, 이모지 같은 32비트 문자(서로게이트 페어)는 처리하지 못한다.
    - 해결방법: `Character.isLetterOrDigit(int codePoint)`
- NOTE: `str.charAt(int index)`가 반환하는 타입은 char 이다.
    - char => 16비트(2바이트) 크기의 데이터 타입
    - 따라서 유니코드에서 16비트로 표현할 수 있는 문자(BMP 영역의 문자)만 제대로 처리 가능
        - BMP: Basic Multilingual Plane, 기본 다국어 평면
    - 32비트 문자(이모지)를 다룰 때는 최대 32비트(4바이트)까지 처리 가능한 `codePointAt(int index)`를 사용해야 함
- 시간복잡도: O(N)
- 공간복잡도: O(1)
- 코딩테스트 인터뷰 팁
    - 1) 문제의 요구조건을 명확히 할 것
        - 단순한 "palindrome 여부를 체크하라"는 문제에도, 세부 요구사항(e.g. non-alphanumeric characters 의 존재 여부 및 처리, 대소문자 구별 등)에 따라 구현 난이도가 달라질 것
    - 2) in-build functions 사용에 대해 여쭤볼 것
        - '팀 플레이어'의 면모를 보여줄 기회
        - 그들의 스타일과 나의 스타일의 합치점을 찾는 모습 어필
 */

public class IsPalindromeValid {
    public static boolean isPalindromeValid(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // left 의 non-alphanumeric characters 패스
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
            // right 의 non-alphanumeric characters 패스
            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;

            // left 와 right 의 character 비교
            // 다르다면 => 바로 false 리턴
            if (s.charAt(left) != s.charAt(right))
                return false;
            // 같다면 => 양쪽 모두 안쪽으로 한 칸 더 모으기
            left++;
            right--;
        }

        // 비교가 정상적으로 모두 끝났다면 => true 리턴
        return true;
    }
}
