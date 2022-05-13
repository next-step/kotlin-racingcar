package calculator.study

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class OperandTest : AnnotationSpec() {

    @Test
    fun `정수값을 가지는 피연산자 객체를 생성`() {
        // given
        val n = 5

        // when
        val operand = Operand(n)

        // then
        operand shouldBe Operand(5)
    }

    @Test
    fun `두 피연산자 간의 덧셈 연산시 덧셈 결괏값을 검증`() {
        // given
        val left = Operand(5)
        val right = Operand(10)

        // when
        val result = left + right

        // then
        result shouldBe Operand(15)
    }

    @Test
    fun `두 피연산자 간의 뺄셈 연산시 뺄셈 결괏값을 검증`() {
        // given
        val left = Operand(5)
        val right = Operand(10)

        // when
        val result = left - right

        // then
        result shouldBe Operand(-5)
    }

    @Test
    fun `두 피연산자 간의 곱셈 연산시 곱셈 결괏값을 검증`() {
        // given
        val left = Operand(5)
        val right = Operand(10)

        // when
        val result = left * right

        // then
        result shouldBe Operand(50)
    }

    @Test
    fun `두 피연산자 간의 나눗셈 연산시 나눗셈 결괏값을 검증`() {
        // given
        val left = Operand(10)
        val right = Operand(5)

        // when
        val result = left / right

        // then
        result shouldBe Operand(2)
    }

    @Test
    fun `0으로 나눗셈 연산시 예외 처리`() {
        // given
        val left = Operand(10)
        val right = Operand(0)

        // when
        val throwableAction = {
            left / right
        }

        // then
        shouldThrow<ArithmeticException>(throwableAction)
    }
}
