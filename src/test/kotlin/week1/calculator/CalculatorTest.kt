package week1.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {

    private val calculator = Calculator

    @Test
    fun `식 계산`() {
        assertThat(calculator.process("2 + 3 * 4 / 2")).isEqualTo(10)
        assertThat(calculator.process("1 + 2 + 3 + 4 + 5")).isEqualTo(15)
    }
}