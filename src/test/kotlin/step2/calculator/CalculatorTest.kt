package step2.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun `연산 테스트`() {
        val testString1 = "2 + 5"
        val testString2 = "2 - 5"
        val testString3 = "2 * 5"
        val calculator = Calculator()

        assertThat(calculator.calculate(testString1)).isEqualTo(7)
        assertThat(calculator.calculate(testString2)).isEqualTo(-3)
        assertThat(calculator.calculate(testString3)).isEqualTo(10)
    }
}