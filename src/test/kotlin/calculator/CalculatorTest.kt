package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalculatorTest {

    @Test
    fun `계산기 정상 확인`() {
        val expression = "9 + 8 - 7 * 6 / 5"
        assertThat(Calculator().calculate(expression)).isEqualTo(12.0)
    }

    @Test
    fun `계산기 비정상 확인 (빈 문자열)`() {
        val expression = ""
        assertThrows<IllegalArgumentException> {
            Calculator().calculate(expression)
        }
    }

    @Test
    fun `계산기 비정상 확인 (이상한 기호)`() {
        val expression = "1 % 2"
        assertThrows<IllegalArgumentException> {
            Calculator().calculate(expression)
        }
    }
}
