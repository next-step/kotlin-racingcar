package study

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class ArrayDequeTest {

    @Test
    fun test() {
        val deque = ArrayDeque<Int>()
        deque.add(10)
        deque.contains(10) shouldBe true

        val value = deque.removeFirst()
        value shouldBe 10
        deque.contains(10) shouldBe false
        deque.isEmpty() shouldBe true
    }
}
