package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class OperatorTest {

    @Test
    fun `덧셈`() {
        // given
        val left = 2
        val right = 1

        // when
        val result = Operator.ADDITION.calculate(left, right)

        // then
        assertThat(result).isEqualTo(left + right)
    }

    @Test
    fun `뺄셈`() {
        // given
        val left = 2
        val right = 1

        // when
        val result = Operator.SUBTRACTION.calculate(left, right)

        // then
        assertThat(result).isEqualTo(left - right)
    }

    @Test
    fun `곱셈`() {
        // given
        val left = 2
        val right = 1

        // when
        val result = Operator.MULTIPLICATION.calculate(left, right)

        // then
        assertThat(result).isEqualTo(left * right)
    }

    @Test
    fun `나눗셈`() {
        // given
        val left = 2
        val right = 1

        // when
        val result = Operator.DIVISION.calculate(left, right)

        // then
        assertThat(result).isEqualTo(left / right)
    }

    @Test
    fun `나눗셈을 하는 경우 0으로 나누는 경우 예외`() {
        // given
        val left = 2
        val right = 0

        // expect
        assertThrows<IllegalArgumentException> { Operator.DIVISION.calculate(left, right) }
    }
}
