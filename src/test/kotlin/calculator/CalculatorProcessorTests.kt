package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class CalculatorProcessorTests {
    @Nested
    @DisplayName("CalculatorProcessor 를 이용하여 연산")
    inner class CalculatorProcessorTest {
        @Test
        fun `사칙 연산 계산 성공`() {
            // 2 + 3 * 4 / 2 = 10
            val operators = listOf(Operator.PLUS, Operator.TIMES, Operator.DIVIDE)
            val operands = listOf(2.0, 3.0, 4.0, 2.0)

            val result = CalculatorProcessor.calculate(operators, operands)
            assertThat(result).isEqualTo(10.0)
        }
    }
}
