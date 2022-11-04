package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.util.*

class LinkedListTest : StringSpec() {
    init {
        "LinkedList의 메서드 테스트" {
            val queue: Queue<Int> = LinkedList()

            queue.offer(1)
            queue.offer(2)

            queue.poll() shouldBe 1
            queue.poll() shouldBe 2
        }
    }
}
