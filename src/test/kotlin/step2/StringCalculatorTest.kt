package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {
    private val calculator = StringCalculator()

    @ParameterizedTest
    @ValueSource(strings = ["", "  "])
    fun `입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException이 발생한다`(input: String) {
        assertThatThrownBy { calculator.execute(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["3 % 4", "5 , 3"])
    fun `사칙 연산 기호가 아닌 경우 IllegalArgumentException이 발생한다`(input: String) {
        assertThatThrownBy { calculator.execute(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `덧셈이 가능하다`() {
        val input = "5 + 3"
        val actual = calculator.execute(input)
        val expected = 8.0
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `뺄셈이 가능하다`() {
        val input = "5 - 3"
        val expected = 2.0
        val actual = calculator.execute(input)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `곱셈이 가능하다`() {
        val input = "5 * 3"
        val expected = 15.0
        val actual = calculator.execute(input)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `나눗셈이 가능하다`() {
        val input = "4 / 2"
        val expected = 2.0
        val actual = calculator.execute(input)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `사칙 연산이 모두 가능하다`() {
        val input = "2 + 3 * 4 / 2"
        val actual = calculator.execute(input)
        val expected = 10.0
        assertThat(actual).isEqualTo(expected)
    }
}
