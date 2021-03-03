package study.calculation

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(
        "2 + 3 * 4 / 2, 10",
        "5 - 3 / 2 * 5, 5",
        "10 / 2 + 3 - 8, 0"
    )
    fun `문자열 식 계산`(expression: String, expected: Int) {
        val stringCalculator = StringCalculator(CalculateTokenizer())

        assertThat(stringCalculator.calculate(expression)).isEqualTo(expected)
    }
}
