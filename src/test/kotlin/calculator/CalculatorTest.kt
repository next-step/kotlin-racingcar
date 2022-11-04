package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun `2 더하기 3 곱하기 4 나누기 2 = 10 이다`() {
        var calculator = Calculator()
        calculator.pressButton("2 + 3 * 4 / 2")
        assertThat(calculator.calculate()).isEqualTo(10)
    }
}
