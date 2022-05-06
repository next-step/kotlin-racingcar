package study

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class StringOperatorTest {

    @Test
    fun addOperator() {
        // given
        val lhs = Operand(20)
        val rhs = Operand(10)

        // when
        val result = StringOperator.PLUS.apply(lhs, rhs)

        // then
        result shouldBe Operand(30)
    }

    @Test
    fun minusOperator() {
        // given
        val lhs = Operand(20)
        val rhs = Operand(10)

        // when
        val result = StringOperator.MINUS.apply(lhs, rhs)

        // then
        result shouldBe Operand(10)
    }

    @Test
    fun timesOperator() {
        // given
        val lhs = Operand(20)
        val rhs = Operand(10)

        // when
        val result = StringOperator.TIMES.apply(lhs, rhs)

        // then
        result shouldBe Operand(200)
    }

    @Test
    fun divOperator() {
        // given
        val lhs = Operand(20)
        val rhs = Operand(10)

        // when
        val result = StringOperator.DIV.apply(lhs, rhs)

        // then
        result shouldBe Operand(2)
    }
}
