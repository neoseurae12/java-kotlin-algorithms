package ch06_processingString

/* Trial 2
- Trial 1에 대한 코틀린 풀이

- 전환 (String[] -> Set<String>) 필요 없음
  - 코틀린 => '모든 것이 객체'
  - Array<String> 에서도 '비교 메소드' 제공함
- 가장 흔하게 등장하는 단어 찾기
  - 더 간결
  - fun Array<out T>.maxByOrNull(selector: (T) -> R): T?
- 정규식
  - fun String.toRegex(): Regex
    - 코틀린에서는 정규식 표현을 '정규식 객체'로 만들어줘야 정규식으로 인지함
- 데이터 클렌징
  - 공백 제거
    - fun String.trim(): String
- split() 메소드의 동작 차이 in Java & Kotlin
  - Java 의 split()
    - Trailing empty strings are not included in the resulting array.
  - Kotlin 의 split()
    - Trailing empty strings are also included
      - cf. "... proceeds from the beginning to the "end" of this string ..."
- String 에서의 대체(replace) 관련 메소드의 차이 in Java & Kotlin
  - Java
    - [공통점] replace() & replaceAll()
      - 대체 하고 싶은 '모든' substring 들을 대체 텍스트로 바꿔줌
    - [차이점] 대체 하고 싶은 substring 을
      - '텍스트' 로 표현할 시 => replace(CharSequence target, CharSequence replacement)
      - '정규표현식' 으로 표현할 시 => replaceAll(String regex, String replacement)
  - Kotlin
    - replace()
      - 대체 하고 싶은 '모든' substring 들을 '텍스트' 또는 '정규표현식'의 대체 텍스트로 바꿔줌
    - replaceAll()
      - 지원 안 함 + 불필요
 */

class MostCommonWordK {
  fun mostCommonWord(paragraph: String, banned: Array<String>): String {
    val counts: MutableMap<String, Int> = mutableMapOf()

    val words = paragraph.replace("\\W+".toRegex(), " ").lowercase().trim().split(" ")

    // 자세히 알아보기: trim() & split()
    val beforeSplitWithNoTrim = paragraph.replace("\\W+".toRegex(), " ").lowercase() // trim() 안 함
    val beforeSplitWithTrim = paragraph.replace("\\W+".toRegex(), " ").lowercase().trim()
    val wordsWithNoTrim = beforeSplitWithNoTrim.split(" ")  // trim() 안 함
    val wordsWithTrim = beforeSplitWithTrim.split(" ")

    println(beforeSplitWithNoTrim)  // " 4me to good you to good "
    println(beforeSplitWithTrim)    // "4me to good you to good"
    println(wordsWithNoTrim)        // [, 4me, to, good, you, to, good, ]   // Java 와의 차이 발생 지점
    println(wordsWithTrim)          // [4me, to, good, you, to, good]
    // 끝 -------

    for (word in words) {
      if (!banned.contains(word)) {
        counts[word] = counts.getOrDefault(word, 0) + 1 // put() 메소드의 또다른 표현 in Kotlin
      }
    }

    return counts.maxByOrNull { it.value }!!.key  // 문제의 제약 조건에 따라 널이 아님이 확실 => !! 로 처리
  }
}

fun main() {
  MostCommonWordK().mostCommonWord(",/%4me to good ^you to **good*", arrayOf("to"))
}