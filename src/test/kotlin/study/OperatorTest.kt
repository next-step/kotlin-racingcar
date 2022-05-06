package study

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class OperatorTest {

    @Test
    fun addOperator() {
        // given
        val lhs = Operand(20)
        val rhs = Operand(10)

        // when
        val result = Operator.PLUS.apply(lhs, rhs)

        // then
        result shouldBe Operand(30)
    }

    @Test
    fun minusOperator() {
        // given
        val lhs = Operand(20)
        val rhs = Operand(10)

        // when
        val result = Operator.MINUS.apply(lhs, rhs)

        // then
        result shouldBe Operand(10)
    }

    @Test
    fun timesOperator() {
        // given
        val lhs = Operand(20)
        val rhs = Operand(10)

        // when
        val result = Operator.TIMES.apply(lhs, rhs)

        // then
        result shouldBe Operand(200)
    }

    @Test
    fun divOperator() {
        // given
        val lhs = Operand(20)
        val rhs = Operand(10)

        // when
        val result = Operator.DIV.apply(lhs, rhs)

        // then
        result shouldBe Operand(2)
    }
}
