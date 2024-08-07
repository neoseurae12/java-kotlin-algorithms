package ch09_stack_queue;

/* Trial 1

- 재귀 & 집합(Set) 를 이용한 분리
    - 재귀 => a + (c + (d + (b + ("")))) => "acdb"
    - 집합 => 중복된 문자가 제거된 자료형
- 문제의 "the smallest in lexicographical order"(사전식 순서) 라는 표현에 대한 확실한 이해를 바탕으로 풀어야 하는 문제
- String 간의 비교: == vs. equals()
    - == => String 간의 주소값 비교
    - equals() => String 간의 내용 비교
- TreeSet vs. HashSet
    - TreeSet => 정렬 지원 O
    - HashSet => 정렬 지원 X
- 재귀 & replace()
    - 일종의 분할 정복 => suffix 의 크기가 점점 줄어듦
    - 백트래킹 => 결과가 조합됨
- 언박싱
    - `for (char c : toSortedSet(s))`
    - Character -> char
- 본 Trial 1 의 풀이 방법의 실행 속도가 Trial 2 에 비해 훨씬 느린 이유
    - 기본적으로 재귀 풀이의 실행 속도는 좀 더 느린 편
    - 그렇다고 해도 Trial 1 (151 밀리초) vs. Trial 2 (8 밀리초) -- 이렇게까지 많이 차이가 나는 이유
        - 문자열을 매번 정렬된 집합으로 만드는 과정에서 각 엘리먼트를 순회해 처리하는 부분에 부담이 큼
        - 전체 집합과 suffix 집합의 일치 여부를 판단하는 과정도 매우 긴 문자열인 경우 부담이 큼
- 개선: 익명 클래스 방식 -> 람다 표현식 방식
    - 익명 클래스 방식 vs. 람다 표현식 방식
        - 익명 클래스 방식 => 메소드명을 명시함
        - 람다 표현식 방식
            - 메소드명 없이 구현함
            - 훨씬 더 간결한 표현
            - 더 좋은 성능
    - 함수형 인터페이스
        - 단 하나의 메소드만 있는 인터페이스
            - ex. Comparator, Runnable, Callable 등
        - 따라서 람다 표현식으로 구현하는 것이 가능함 & 권장됨
 */

import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicateLettersJ {

    // String -> 정렬된 Set 로 변환해주는 함수 (직접 구현 필요)
    public Set<Character> toSortedSet(String s) {
        Set<Character> set = new TreeSet<>();
        /* 비교 기준을 명시적으로 정의할 수도 있을 것 (개선: 익명 클래스 방식 -> 람다 표현식 방식)
        Set<Character> set = new TreeSet<>((o1, o2) -> {
            if (o1 == o2)
                return 0;
            else if (o1 > o2)
                return 1;
            else
                return -1;
        });
         */

        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        return set;
    }

    public String removeDuplicateLetters(String s) {
        // 문자열 s 에 존재하는, 중복 문자를 제외한 문자들의 알파벳 순서(a->b->c->...)에 따라 suffix 를 분리해 확인한다
        for (char c : toSortedSet(s)) {
            String suffix = s.substring(s.indexOf(c));
            // 분리 가능 여부 판별 방법: '전체 집합'과 'suffix 집합'이 일치하는가
                // 즉, suffix 집합이 접두사(prefix)의 문자들까지 모두 포함하고 있다면 => '중복'이라는 의미
                // 따라서 prefix 는 버리고 suffix 만 취하면 된다
            if (toSortedSet(s).equals(toSortedSet(suffix))) {
                return c + removeDuplicateLetters(suffix.replace(String.valueOf(c), ""));   // 재귀 호출 & replace()
            }
        }

        return "";
    }
}
