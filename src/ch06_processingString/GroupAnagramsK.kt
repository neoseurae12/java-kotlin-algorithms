package ch06_processingString

/* Trial 2
- Trial 1에 대한 코틀린 풀이

- 코틀린으로 구현 시 자바에 비해 간결하게 할 수 있는 부분
  - 문자열 정렬 부분
    - '메소드 체이닝' 가능
    - 코틀린의 CharArray 는 자바와 달리 sorted() 메소드를 지원하기 때문
  - 키에 해당하는 리스트 삽입 부분
    - getOrPut() 메소드
- [차이점] sort() vs. sorted()
  - sort()
    - 원본을 직접 정렬함
  - sorted()
    - 원본은 그대로 냅두고, 정렬된 새로운 컬렉션을 반환함
- [차이점] joinToString() vs. toString()
  - joinToString()
    - 구분자(separator)를 포함해 prefix, postfix, limit, truncated, transform 등, 더 섬세하게 문자열로 join 시킬 수 있음
    - 자바의 String.valueOf() 와 동일한 결과 반환 (ex. "aet")
  - toString()
    - 섬세한 조작 불가
    - 자바의 Arrays.toString() 와 동일한 결과 반환 (ex. "[a, e, t]")
- mutable/immutable 에 주의
 */

class GroupAnagramsK {
  fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val result: MutableMap<String, MutableList<String>> = mutableMapOf()

    for (s in strs) {
      // 문자열 정렬 부분
      val key = s.toCharArray().sorted().joinToString("")    // "aet"
      //val keyWrong = s.toCharArray().sorted().toString()            // "[a, e, t]"

      // 키에 해당하는 리스트 삽입 부분
      result.getOrPut(key) { mutableListOf() }
      result[key]!!.add(s)
    }

    // 문제에서 요구하는 출력값의 형태로 리턴
    return ArrayList<List<String>>(result.values)
  }
}
