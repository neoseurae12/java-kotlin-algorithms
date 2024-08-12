package ch09_stack_queue

/* Trial 2

- Trial 1에 대한 코틀린 풀이
- Kotlin의 `IntArray(5)` == Java의 `new int[5];`
 */

import java.util.ArrayDeque
import java.util.Deque

class DailyTemperaturesK {
  fun dailyTemperatures(temperatures: IntArray): IntArray {
    val result = IntArray(temperatures.size)
    val stack: Deque<Int> = ArrayDeque()

    for (i in temperatures.indices) {
      while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        val last = stack.pop()

        result[last] = i - last
      }

      stack.push(i)
    }

    return result
  }
}