package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class CalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = [" ", "   ", "\t", "\n"])
    fun `입력값이 null이거나 빈 공백문자인 경우 예외를 던진다`(text: String?) {
        val calculator = Calculator()

        assertThatThrownBy { calculator.calculate(text) }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["+", "1 + 2 *", "1 2 3", "1 / / 2"])
    fun `값이 잘 안 들어간 경우 예외를 던진다`(candidate: String) {
        val calculator = Calculator()

        assertThatThrownBy { calculator.calculate(candidate) }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `더하기`() {
        val calculator = Calculator()

        assertThat(calculator.calculate("1 + 2")).isEqualTo(3)
    }

    @Test
    fun `빼기`() {
        val calculator = Calculator()

        assertThat(calculator.calculate("1 - 2")).isEqualTo(-1)
    }

    @Test
    fun `곱하기`() {
        val calculator = Calculator()

        assertThat(calculator.calculate("12 * 4")).isEqualTo(48)
    }

    @Test
    fun `나누기`() {
        val calculator = Calculator()

        assertThat(calculator.calculate("12 / 4")).isEqualTo(3)
    }

    @Test
    fun `복잡한 식`() {
        val calculator = Calculator()

        assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10)
        assertThat(calculator.calculate("2 * 3 * 4 / 2 - 1")).isEqualTo(11)
        assertThat(calculator.calculate("2 + 3 * 4 / 2 - 1")).isEqualTo(9)
    }
}
