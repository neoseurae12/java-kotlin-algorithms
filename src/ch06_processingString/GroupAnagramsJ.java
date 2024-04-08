package ch06_processingString;

/* Trial 1

- 정렬
    - 애너그럼을 이루는 단어들을 정렬하면 모두 같은 값을 갖게 된다.
    - Arrays.sort(char[] a)
- [차이점] String.valueOf() vs. Arrays.toString()
 */

import java.util.*;

public class GroupAnagramsJ {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 애너그램 결과를 보관하기 위한 '맵' 선언
        Map<String, List<String>> result = new HashMap<>();

        for (String s : strs) {
            // 전환: 문자열 -> 문자 배열
            char[] chars = s.toCharArray();
            // 문자 배열 정렬
            Arrays.sort(chars);
            // 전환: 문자 배열 -> 문자열
                // '키'로 사용하기 위함
            String key = String.valueOf(chars);         // "aet"
            //String keyWrong = Arrays.toString(chars);   // "[a, e, t]"

            // 만약 기존에 없던 키라면 => 빈 리스트 생성 및 삽입
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }
            // 키에 해당하는 값 리스트에 문자열 추가
            result.get(key).add(s);
        }

        // 문제에서 요구하는 출력값의 형태로 리턴
        return new ArrayList<>(result.values());
    }
}
