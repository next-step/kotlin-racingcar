package calculator

import calculator.StringCalculator.Companion.calculate
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class StringCalculatorTest {
    @Test
    fun `입력 값이 null 또는 빈 문자열`() {
        assertThatThrownBy { calculate(null) }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { calculate("") }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { calculate(" ") }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `계산`() {
        assertThat(calculate("4 / 2 + 3 * 2 - 5")).isEqualTo(5)
    }
}
