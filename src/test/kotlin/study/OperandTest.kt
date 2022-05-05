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

    @Test
    fun addOperand() {
        // given
        val left = Operand(5)
        val right = Operand(10)

        // when
        val result = left.add(right)

        // then
        result shouldBe Operand(15)
    }

    @Test
    fun subOperand() {
        // given
        val left = Operand(5)
        val right = Operand(10)

        // when
        val result = left.sub(right)

        // then
        result shouldBe Operand(-5)
    }
}
