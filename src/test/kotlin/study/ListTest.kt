package study

import calculator.isNumeric
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class ListTest : AnnotationSpec() {
    @Test
    fun `List의 GroupBy`() {
        val list = listOf("1", "+", "2", "-", "3")

        val result = list.groupBy { isNumeric(it) }

        result[true]?.size shouldBe 3
        result[true]?.get(0) shouldBe "1"

        result[false]?.size shouldBe 2
        result[false]?.get(0) shouldBe "+"
    }
}
