package step2

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = [" ", "\t", "\n"])
    fun `null 또는 whitespace 문자가 주어질 경우 IllegalArgumentException 이 발생한다`(input: String) {
        assertThatIllegalArgumentException().isThrownBy { Calculator.calculate(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 % 1", "2 + 2 @ 2", "3 ^ 3", "4 ++"])
    fun `사칙연산 기호가 아닌 문자가 주어질 경우 IllegalArgumentException 이 발생한다`(input: String) {
        assertThatIllegalArgumentException().isThrownBy { Calculator.calculate(input) }
            .withMessage("")
    }

    @ParameterizedTest
    @ValueSource(strings = ["a + b", "1,1 * 2"])
    fun `숫자가 아닌 문자가 주어질 경우 IllegalArgumentException 이 발생한다`(input: String) {
        assertThatIllegalArgumentException().isThrownBy { Calculator.calculate(input) }
            .withMessage("")
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 +", "- 2", "3 * / 3", "4 4 - 4", "5+5"])
    fun `잘못된 식이 주어질 경우 IllegalArgumentException 이 발생한다`(input: String) {
        assertThatIllegalArgumentException().isThrownBy { Calculator.calculate(input) }
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
        #EXPRESSION             #RESULT
        12 + 34,                46
        5 + 4 + 3 + 2 + 1 + 0,  15
        7428934 + 189248,       7618182
        -1 + -2,                -3
    """) fun `사칙연산 - 덧셈`(expression: String, result: Int) {
        assertEquals(Calculator.calculate(expression), result)
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
        #EXPRESSION             #RESULT
        10 - 0 - 4 - 2,         4
        45 - 90,                -45
        -1 - -2,                1
        28348 - 3747,           24601
    """) fun `사칙연산 - 뺄셈`(expression: String, result: Int) {
        assertEquals(Calculator.calculate(expression), result)
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
        #EXPRESSION             #RESULT
        12 * 34 * 56,           22848
        5 * 0,                  0
        25 * -2,                -50
        -20 * -30,              600
    """) fun `사칙연산 - 곱셈`(expression: String, result: Int) {
        assertEquals(Calculator.calculate(expression), result)
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
        #EXPRESSION             #RESULT
        4 / 2,                  2
        15 / -5,                -3
        100 / 2 / 5 / 2,        5
    """) fun `사칙연산 - 나눗셈`(expression: String, result: Int) {
        assertEquals(Calculator.calculate(expression), result)
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
        #EXPRESSION             #RESULT
        1 + 5 / 2 * 8 - 1,      23
        88 * 10 / 8 + 4,        114
        -3 * 4 - 90 + 44,       -58
    """) fun `사칙연산 - 덧셈, 뺄셈, 곱셈, 나눗셈 모두 포함`(expression: String, result: Int) {
        assertEquals(Calculator.calculate(expression), result)
    }
}
