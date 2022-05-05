package study

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class OperandTest : AnnotationSpec() {

    @Test
    fun createOperand() {
        // given
        val n = 5

        // when
        val operand = Operand(n)

        // then
        operand shouldBe Operand(5)
    }
}
