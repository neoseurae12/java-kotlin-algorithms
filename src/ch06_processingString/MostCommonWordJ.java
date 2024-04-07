package ch06_processingString;

/* Trial 1
- 데이터 클렌징(Data Cleansing): 입력값에 대한 전처리(Preprocessing) 작업
    - 구두점 무시 / 대소문자 구분 X / 단어 분리
- 정규식
    - \W: 단어 문자(Word Character)가 아닌 것
    - \w: 단어 문자인 것
- 각 단어별 개수 저장
    - default V Map<K, V>.getOrDefault(Object key, V defaultValue)
- 가장 흔하게 등장하는 단어 찾기
    - static <T> T Collections.max(Collections<? extends T> coll, Comparator<? super T> Comp)
    - Set<Map.Entry<K, V>> Map<K, V>.entrySet()
    - static <K, V extends Comparable<? super V>> Comparator<Map.Entry<K, V>> Map.Entry<K, V>.comparingByValue()
    - K Map.Entry<K, V>.getKey()
- HashSet(Collection<? extends E> c)
 */

import java.util.*;

public class MostCommonWordJ {
    public static String mostCommonWord(String paragraph, String[] banned) {
        // 전환: String[] -> Set<String>
            // Set 이 '비교 메소드'를 제공하기 때문
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        // 각 단어별 개수를 저장할 키-값 맵
        Map<String, Integer> counts = new HashMap<>();

        // 데이터 클렌징
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

        // 자세히 알아보기: trim() & split()
        String wordsBeforeSplitWithNoTrim = paragraph.replaceAll("\\W+", " ").toLowerCase();    // trim() 안 함
        String wordsBeforeSplitWithTrim = paragraph.replaceAll("\\W+", " ").toLowerCase().trim();
        String[] wordsWithNoTrim = wordsBeforeSplitWithNoTrim.split(" ");   // trim() 안 함
        String[] wordsWithTrim = wordsBeforeSplitWithTrim.split(" ");

        System.out.println(wordsBeforeSplitWithNoTrim);         // " 4me to good you to good "
        System.out.println(wordsBeforeSplitWithTrim);           // "4me to good you to good"
        System.out.println(Arrays.toString(wordsWithNoTrim));   // [, 4me, to, good, you, to, good] // Kotlin 과의 차이 발생 지점
        System.out.println(Arrays.toString(wordsWithTrim));     // [4me, to, good, you, to, good]
        // 끝 -------

        for (String word : words) {
            // 금지된 단어가 아닐 경우에만 개수 처리
            if (!ban.contains(word)) {
                // 각 단어별 개수 저장
                counts.put(word, counts.getOrDefault(word, 0) + 1);
            }
        }

        // 가장 흔하게 등장하는 단어 찾기
        return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        mostCommonWord(",/%4me to good ^you to **good*", new String[]{"to"});
    }
}
