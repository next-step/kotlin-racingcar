package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CalculatorTest {

    @Test
    fun `피연산자 개수가 연산자 개수보다 1개 더 많은 경우 정상 동작한다`() {
        // given
        val operands = listOf(Number(1), Number(2), Number(4), Number(5))
        val operators = listOf(Operator.PLUS, Operator.MINUS, Operator.MULTIPLE)
        val calculator = Calculator(operands, operators)

        val expected = Number(-5)

        // when
        val result = calculator.calculate()

        // then
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `피연산자 개수가 연산자 개수와 같은 경우 예외를 반환한다`() {
        val operands = listOf(Number(1), Number(2), Number(4))
        val operators = listOf(Operator.PLUS, Operator.MINUS, Operator.MULTIPLE)

        val result = assertThrows<IllegalArgumentException> { Calculator(operands, operators) }
        assertThat(result.message).isEqualTo("숫자는 연산자보다 갯수가 1개 더 많아야 합니다")
    }
}
