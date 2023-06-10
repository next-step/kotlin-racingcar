package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun `계산식을 받아 계산한다`() {
        val calculator = Calculator()
        assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10)
    }
}
