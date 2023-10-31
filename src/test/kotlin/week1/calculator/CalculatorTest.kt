package week1.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {

    private val calculator = Calculator

    @Test
    fun `식 계산`() {
        assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10)
        assertThat(calculator.calculate("1 + 2 + 3 + 4 + 5")).isEqualTo(15)
    }
}