package study

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class StreamTest : AnnotationSpec() {
    @Test
    fun split() {
        val string = "1 + 2"

        val result = string.split(" ")

        result shouldBe listOf("1", "+", "2")
    }

    @Test
    fun firstOrNull() {
        val list = emptyList<Int>()

        val result = list.firstOrNull() ?: 0

        result shouldBe 0
    }

    @Test
    fun drop() {
        val list = listOf(1, 2)

        val result = list.drop(1)

        result shouldBe listOf(2)
    }

    @Test
    fun fold() {
        val list = listOf(1, 2, 3, 4)

        val result = list.fold(10) {
            acc, i ->
            acc + i
        }

        result shouldBe 20
    }
}
