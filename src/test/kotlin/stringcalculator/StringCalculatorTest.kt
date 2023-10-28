package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import util.KnownException

class StringCalculatorTest {

    @Test
    fun 덧셈() {
        // given
        val input = "2 + 3"
        // when
        val result = StringCalculator().execute(input)
        // then
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun 뺄셈() {
        // given
        val input = "10 - 3"
        // when
        val result = StringCalculator().execute(input)
        // then
        assertThat(result).isEqualTo(7)
    }

    @Test
    fun 곱셈() {
        // given
        val input = "2 * 3"
        // when
        val result = StringCalculator().execute(input)
        // then
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun 나눗셈() {
        // given
        val input = "10 / 5"
        // when
        val result = StringCalculator().execute(input)
        // then
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun 사칙연산() {
        // given
        val input = "10 - 2 + 3 * 4 / 2"
        // when
        val result = StringCalculator().execute(input)
        // then
        assertThat(result).isEqualTo(22)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "  "])
    fun isBlank_ShouldReturnTrueForNullOrBlankStrings(input: String) {
        assertThatThrownBy {
            StringCalculator().execute(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(KnownException.INVALID_INPUT.message)
    }
}