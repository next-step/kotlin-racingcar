package study

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class OperatorTest {

    @Test
    fun addOperator() {
        // given
        val lhs = Operand(20)
        val rhs = Operand(10)

        // when
        val result = Operator.PLUS.calc(lhs, rhs)

        // then
        result shouldBe Operand(30)
    }

    @Test
    fun minusOperator() {
        // given
        val lhs = Operand(20)
        val rhs = Operand(10)

        // when
        val result = Operator.MINUS.calc(lhs, rhs)

        // then
        result shouldBe Operand(10)
    }

    @Test
    fun timesOperator() {
        // given
        val lhs = Operand(20)
        val rhs = Operand(10)

        // when
        val result = Operator.TIMES.calc(lhs, rhs)

        // then
        result shouldBe Operand(200)
    }

    @Test
    fun divOperator() {
        // given
        val lhs = Operand(20)
        val rhs = Operand(10)

        // when
        val result = Operator.DIV.calc(lhs, rhs)

        // then
        result shouldBe Operand(2)
    }
}
