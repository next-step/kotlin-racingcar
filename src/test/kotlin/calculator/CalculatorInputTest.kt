@file:Suppress("NonAsciiCharacters")

package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test

class CalculatorInputTest {
    @Test
    fun `init - 피연산자의 수가 연산자의 수 + 1이 아니면 IllegalArgumentException을 던진다`() {
        val operands = listOf(1.0, 2.0)
        val operators = listOf(Operator.PLUS, Operator.MINUS)

        val result = catchThrowable {
            CalculatorInput(operands, operators)
        }

        assertThat(result).isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Number of operands should be one more than number of operators.")
    }
}
