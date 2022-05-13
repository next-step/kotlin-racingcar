package calculator.study

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class StringOperatorTest {

    @Test
    fun `두 피연산자에 대한 덧셈 연산자의 결괏값 검증`() {
        // given
        val lhs = Operand(20)
        val rhs = Operand(10)

        // when
        val result = StringOperator.PLUS.apply(lhs, rhs)

        // then
        result shouldBe Operand(30)
    }

    @Test
    fun `두 피연산자에 대한 뺄셈 연산자의 결괏값 검증`() {
        // given
        val lhs = Operand(20)
        val rhs = Operand(10)

        // when
        val result = StringOperator.MINUS.apply(lhs, rhs)

        // then
        result shouldBe Operand(10)
    }

    @Test
    fun `두 피연산자에 대한 곱셈 연산자의 결괏값 검증`() {
        // given
        val lhs = Operand(20)
        val rhs = Operand(10)

        // when
        val result = StringOperator.TIMES.apply(lhs, rhs)

        // then
        result shouldBe Operand(200)
    }

    @Test
    fun `두 피연산자에 대한 나눗셈 연산자의 결괏값 검증`() {
        // given
        val lhs = Operand(20)
        val rhs = Operand(10)

        // when
        val result = StringOperator.DIV.apply(lhs, rhs)

        // then
        result shouldBe Operand(2)
    }
}
