package study

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource

internal class CalculatorTest {

    @Test
    fun `주어진 문자의 두 수를 더할 수 있다`() {
        // given
        val givenText = "2 + 3"

        // when
        val calculator = Calculator(givenText)

        // then
        assertThat(calculator.result()).isEqualTo(5)
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `주어진 문자가 공백이면 예외를 던진다`(givenText: String?) {
        assertThatCode { Calculator(givenText) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `주어진 문자의 두 수를 뺄 수 있다`() {
        // given
        val givenText = "3 - 2"

        // when
        val calculator = Calculator(givenText)

        // then
        assertThat(calculator.result()).isEqualTo(1)
    }
}
