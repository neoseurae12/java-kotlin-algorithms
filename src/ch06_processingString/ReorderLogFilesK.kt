package ch06_processingString

/* Trial 2
- Trial 1에 대한 코틀린 풀이

- fun <T> MutableList<T>.sortWith(comparator: Comparator<in T>)
- fun <T> Collection<T>.toTypedArray(): Array<T>
 */

class ReorderLogFilesK {
  fun reorderLogFiles(logs: Array<String>): Array<String> {
    val letterLogs = mutableListOf<String>()
    val digitLogs = mutableListOf<String>()

    for (log in logs) {
      if (Character.isDigit(log.split(" ")[1][0])) {
        digitLogs.add(log)
      } else {
        letterLogs.add(log)
      }
    }

    letterLogs.sortWith { s1: String, s2: String ->
      val s1x = s1.split(" ", limit = 2)
      val s2x = s2.split(" ", limit = 2)

      val compared = s1x[1].compareTo(s2x[1])
      if (compared == 0) {
        s1x[0].compareTo(s2x[0])
      } else {
        compared
      }
    }

    letterLogs.addAll(digitLogs)

    return letterLogs.toTypedArray()
  }
}