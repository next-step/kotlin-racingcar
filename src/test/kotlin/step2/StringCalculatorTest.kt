package step2

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = ["2 + 3:5", "3 + 5:8", "1 + 3:4"], delimiter = ':')
    fun `덧셈`(input: String, expect: Int) {
        // when
        val actual = StringCalculator.calculate(input)

        // then
        assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["2 - 3:-1", "3 - 5:-2", "1 - 3:-2"], delimiter = ':')
    fun `뺄셈`(input: String, expect: Int) {
        // when
        val actual = StringCalculator.calculate(input)

        // then
        assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["2 * 3:6", "3 * 5:15", "1 * 3:3"], delimiter = ':')
    fun `곱셈`(input: String, expect: Int) {
        // when
        val actual = StringCalculator.calculate(input)

        // then
        assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["2 / 3:0", "3 / 5:0", "1 / 3:0"], delimiter = ':')
    fun `나눗셈`(input: String, expect: Int) {
        // when
        val actual = StringCalculator.calculate(input)

        // then
        assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `입력값이 빈 공백 문자일 경우 IllegalArgumentException throw`(input: String) {
        Assertions.assertThatThrownBy {
            // when
            StringCalculator.calculate(input)
        }
            // then
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `입력값이 null일 경우 IllegalArgumentException throw`() {
        Assertions.assertThatThrownBy {
            // when
            StringCalculator.calculate(null)
        }
            // then
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 ^ 3", "3 ^ 5", "1 ^ 3"])
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw`(input: String) {
        Assertions.assertThatThrownBy {
            // when
            StringCalculator.calculate(input)
        }
            // then
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
