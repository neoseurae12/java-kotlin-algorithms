package ch09_stack_queue

/* Trial 2

- Trial 1에 대한 코틀린 풀이
 */

import java.util.*

class ImplementStackUsingQueuesK {
  val queue: Queue<Int> = LinkedList()

  fun push(x: Int) {
    queue.add(x)
    for (i in 1 until queue.size)
      queue.add(queue.remove())
  }

  fun pop(): Int {
    return queue.remove()
  }

  fun top(): Int {
    return queue.peek()
  }

  fun empty(): Boolean {
    return queue.isEmpty()
  }
}