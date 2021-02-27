package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CalculatorTest {

    @Test
    fun `계산기 정상동작`() {
        // given
        val operands = listOf("1", "2", "4", "5")
        val operators = listOf("+", "-", "*")
        val calculator = Calculator(operands, operators)

        val expected = -5

        // when
        val result = calculator.calculate()

        // then
        assertThat(result).isEqualTo(expected)
    }
}
