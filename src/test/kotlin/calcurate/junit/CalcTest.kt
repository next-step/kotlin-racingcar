package calcurate.junit

import calcurate.ErrorCode
import calcurate.expression.Expression
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import kotlin.IllegalArgumentException

class CalcTest {
    /**
     * Success Case
     */
    @ParameterizedTest
    @CsvSource(value = ["3 + 2 + 5 = 10.0", "2 + 7 + 2 = 11.0"], delimiterString = " = ")
    fun `덧셈 성공`(expressionStr: String, expect: Double) {
        val expression = Expression(expressionStr)

        Assertions.assertThat(expression.calculation()).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["20 - 5 - 2 = 13.0", "13 - 2 - 5 = 6.0"], delimiterString = " = ")
    fun `뺄셈 성공`(expressionStr: String, expect: Double) {
        val expression = Expression(expressionStr)

        Assertions.assertThat(expression.calculation()).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["50 * 2 * 3 = 300.0", "3 * 2 * 5 = 30.0"], delimiterString = " = ")
    fun `곱셈 성공`(expressionStr: String, expect: Double) {
        val expression = Expression(expressionStr)

        Assertions.assertThat(expression.calculation()).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["1000 / 100 / 5 = 2.0", "20 / 2 / 10 = 1.0"], delimiterString = " = ")
    fun `나눗셈 성공`(expressionStr: String, expect: Double) {
        val expression = Expression(expressionStr)

        Assertions.assertThat(expression.calculation()).isEqualTo(expect)
    }

    /**
     * Fail Case
     */
    @ParameterizedTest
    @CsvSource(value = ["1000 / 100 / 0 = 0.0", "30 / 0 / 2 = 3.0"], delimiterString = " = ")
    fun `나누는 값이 0이면 예외가 발생`(expressionStr: String, expect: Double) {
        val expression = Expression(expressionStr)

        assertThrows<IllegalArgumentException>(ErrorCode.INVALID_DIVIDE_VALUE.msg) { expression.calculation() }
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `expression 이 null 혹은 빈 공백 문자인 경우 예외가 발생`(expressionStr: String?) {
        assertThrows<IllegalArgumentException>(ErrorCode.INVALID_EXPRESSION.msg) { Expression(expressionStr) }
    }

    @ParameterizedTest
    @CsvSource(value = ["10 ? 20 / 1 = 0.0", "30 $ 2 @ 1 = 3.0"], delimiterString = " = ")
    fun `사칙 연산 기호가 아닌 경우 예외가 발생`(expressionStr: String) {
        assertThrows<IllegalArgumentException>(ErrorCode.INVALID_CALC_SYMBOL.msg) { Expression(expressionStr) }
    }
}
