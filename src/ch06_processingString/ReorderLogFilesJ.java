package ch06_processingString;

/* Trial 1
- Array, String, Sorting
- 문자 로그 vs. 숫자 로그 로 구분하여 각각 처리

- 정렬
    - static <T> void Collections.sort(List<T> list, Comparator<? super T> c)
    - default void List<E>.sort(Comparator<? super E> c)
- 비교
    - int Comparator<T>.compare(T o1, T o2)
    - int Comparable<T>.compareTo(T o)
    - 람다 표현식
- 분리
    - String[] split(String regex, int limit)
- 합체
    - boolean Collection<E>.addAll(Collection<? extends E> c)
- 변환
    - <T> T[] Collection<E>.toArray(T[] a)
    - List<String> vs. String[]
 */

import java.util.ArrayList;
import java.util.List;

public class ReorderLogFilesJ {
    public String[] reorderLogFiles(String[] logs) {
        // 분리: 문자 로그 vs. 숫자 로그
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }

        // 문자 로그에 대한 정렬
        letterLogs.sort(((s1, s2) -> {  // 람다 표현식
            // 분리: 식별자 vs. 비식별자
            String[] s1x = s1.split(" ", 2);
            String[] s2x = s2.split(" ", 2);

            // 순서 비교 => 앞(1) / 동일(0) / 뒤(-1)
            int compared = s1x[1].compareTo(s2x[1]);
            if (compared == 0) {    // 문자가 서로 같을 경우 => 식별자순
                return s1x[0].compareTo(s2x[0]);
            } else {                // 문자가 서로 다를 경우 => 사전순
                return compared;
            }
        }));

        // 합체: 문자 로그 + 숫자 로그
            // 숫자 로그는 따로 정렬하지 않음 ('입력 순서대로')
        letterLogs.addAll(digitLogs);

        // 변환: Collection (List<String>) -> Array (String[])
        return letterLogs.toArray(new String[0]);
    }
}
