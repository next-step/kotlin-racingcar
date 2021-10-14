package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource

internal class TextCalculatorTest {

    private lateinit var textCalculator: TextCalculator

    @BeforeEach
    internal fun setUp() {
        textCalculator = TextCalculator()
    }

    @ParameterizedTest
    @CsvSource(value = ["1 + 2, 3", "1 + 2 + 3, 6"])
    fun `주어진 문자의 수를 더할 수 있다`(givenText: String?, answer: Int) {
        // then
        assertThat(textCalculator.calculate(givenText)).isEqualTo(answer)
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `주어진 문자가 공백이면 예외를 던진다`(givenText: String?) {
        assertThatCode { textCalculator.calculate(givenText) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @CsvSource(value = ["3 - 2, 1", "5 - 3 - 1, 1"])
    fun `주어진 문자의 수를 뺄 수 있다`(givenText: String?, answer: Int) {
        // then
        assertThat(textCalculator.calculate(givenText)).isEqualTo(answer)
    }

    @ParameterizedTest
    @CsvSource(value = ["3 * 2, 6", "5 * 3 * 2, 30"])
    fun `주어진 문자의 수를 곱할 수 있다`(givenText: String?, answer: Int) {
        // then
        assertThat(textCalculator.calculate(givenText)).isEqualTo(answer)
    }

    @ParameterizedTest
    @CsvSource(value = ["6 / 2, 3", "10 / 2 / 5, 1"])
    fun `주어진 문자의 수를 나눌 수 있다`(givenText: String?, answer: Int) {
        // then
        assertThat(textCalculator.calculate(givenText)).isEqualTo(answer)
    }

    @Test
    fun `주어진 문자의 수를 계산할 수 있다`() {
        // given
        val givenText = "2 + 3 * 4 / 2"

        // then
        assertThat(textCalculator.calculate(givenText)).isEqualTo(10)
    }

    @Test
    fun `수식이 아닌 문자가 들어가면 예외를 던진다`() {
        val givenText = "2 ? 3"
        // when
        assertThatCode { textCalculator.calculate(givenText) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
