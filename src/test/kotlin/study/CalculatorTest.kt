package study

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource

internal class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = ["1 + 2, 3", "1 + 2 + 3, 6"])
    fun `주어진 문자의 수를 더할 수 있다`(givenText: String?, answer: Int) {
        // when
        val calculator = Calculator(givenText)

        // then
        assertThat(calculator.result()).isEqualTo(answer)
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `주어진 문자가 공백이면 예외를 던진다`(givenText: String?) {
        assertThatCode { Calculator(givenText) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @CsvSource(value = ["3 - 2, 1", "5 - 3 - 1, 1"])
    fun `주어진 문자의 수를 뺄 수 있다`(givenText: String?, answer: Int) {
        // when
        val calculator = Calculator(givenText)

        // then
        assertThat(calculator.result()).isEqualTo(answer)
    }
}
