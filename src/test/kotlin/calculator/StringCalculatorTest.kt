package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal

class StringCalculatorTest {

    private val stringCalculator = StringCalculator()

    @Test
    fun `입력 값이 null 이거나 공백일 경우`() {
        val input = null
        assertThrows<IllegalArgumentException> { stringCalculator.calculateString(input) }
    }

    @Test
    fun `사칙연산 기호가 아닌 경우`() {
        val input = "( 1 + 2 - 3 ) * 4 / 5"
        assertThrows<IllegalArgumentException> { stringCalculator.calculateString(input) }
    }

    @Test
    fun `연산자로 시작하는 경우`() {
        val input = "- -1 + 2 - 3 * 4 / 5"
        assertThrows<IllegalArgumentException> { stringCalculator.calculateString(input) }
    }

    @Test
    fun `연산자로 끝나는 경우`() {
        val input = "-1 + 2 - 3 * 4 / 5 -"
        assertThrows<IllegalArgumentException> { stringCalculator.calculateString(input) }
    }

    @Test
    fun `더하기`() {
        val input = "100 + 200"
        assertThat(stringCalculator.calculateString(input)).isEqualTo(BigDecimal("300"))
    }

    @Test
    fun `빼기`() {
        val input = "100 - 200"
        assertThat(stringCalculator.calculateString(input)).isEqualTo(BigDecimal("-100"))
    }

    @Test
    fun `곱하기`() {
        val input = "10 * 20"
        assertThat(stringCalculator.calculateString(input)).isEqualTo(BigDecimal("200"))
    }

    @Test
    fun `나누기`() {
        val input = "100 / 200"
        assertThat(stringCalculator.calculateString(input)).isEqualTo(BigDecimal("0.5"))
    }

    @Test
    fun `모든 연산자 사용`() {
        val input = "2 + 3 * 4 / 2 - 3"
        assertThat(stringCalculator.calculateString(input)).isEqualTo(BigDecimal("7"))
    }
}
