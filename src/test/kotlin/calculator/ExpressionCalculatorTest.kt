package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ExpressionCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = ["2 + 3 * 4 / 2:10", "-2 + 3 * 4:4", "3 * -5 - 7:-22", "1 + 3 / 5:0"], delimiter = ':')
    fun `덧셈, 뺄셈, 곱셈, 나눗셈 혼합`(input: String, expect: Int) {
        // when
        val actual = ExpressionCalculator.calculate(input)

        // then
        Assertions.assertThat(actual).isEqualTo(expect)
    }
}
