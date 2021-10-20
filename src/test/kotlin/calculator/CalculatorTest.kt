package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CalculatorTest {
    private val calculator = Calculator(Parser(" "))

    @Test
    fun `계산 정상 테스트`() {
        assertThat(calculator.calculate("1 + 2 - 3")).isEqualTo(0.0)
        assertThat(calculator.calculate("1 + 1 * 5")).isEqualTo(10.0)
        assertThat(calculator.calculate("1 + 1 * 5 / 5")).isEqualTo(2.0)
    }
}
