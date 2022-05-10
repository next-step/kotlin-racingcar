package expressioncalculator.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculationTest {
    @Test
    fun `기존 숫자에 PLUS calculation이 잘 적용되는지 확인한다`() {
        val calculation = Calculation(
            operator = Operator.PLUS,
            number = 10.0
        )
        val result = 100.0 compensates calculation
        assertThat(result).isEqualTo(100.0 + 10.0)
    }

    @Test
    fun `기존 숫자에 MINUS calculation이 잘 적용되는지 확인한다`() {
        val calculation = Calculation(
            operator = Operator.MINUS,
            number = 10.0
        )
        val result = 100.0 compensates calculation
        assertThat(result).isEqualTo(100.0 - 10.0)
    }

    @Test
    fun `기존 숫자에 MULTIPLY calculation이 잘 적용되는지 확인한다`() {
        val calculation = Calculation(
            operator = Operator.MULTIPLY,
            number = 10.0
        )
        val result = 100.0 compensates calculation
        assertThat(result).isEqualTo(100.0 * 10.0)
    }

    @Test
    fun `기존 숫자에 DIVIDE calculation이 잘 적용되는지 확인한다`() {
        val calculation = Calculation(
            operator = Operator.DIVIDE,
            number = 10.0
        )
        val result = 100.0 compensates calculation
        assertThat(result).isEqualTo(100.0 / 10.0)
    }
}
