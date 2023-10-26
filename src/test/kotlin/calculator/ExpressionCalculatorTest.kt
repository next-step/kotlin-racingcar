package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class ExpressionCalculatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["2 ^ 3", "3 & 5", "1 | 3"])
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw`(input: String) {
        Assertions.assertThatThrownBy {
            // when
            ExpressionCalculator.calculate(input)
        }
            // then
            .isInstanceOf(IllegalArgumentException::class.java)
            .message().isEqualTo(ErrorMessage.UNSUPPORTED_OPERATOR_MSG.message)
    }

    @ParameterizedTest
    @CsvSource(value = ["2 + 3 * 4 / 2:10", "-2 + 3 * 4:4", "3 * -5 - 7:-22", "1 + 3 / 5:0"], delimiter = ':')
    fun `덧셈, 뺄셈, 곱셈, 나눗셈 혼합`(input: String, expect: Int) {
        // when
        val actual = ExpressionCalculator.calculate(input)

        // then
        Assertions.assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @ValueSource(strings = ["a + b", "! + 4", "a + 4", "2 + b", "2 + 3 + b", "2 + 3 + 4 + b", "2 + 3 + 4 + 5 + b"])
    fun `값의 위치에 수자 아닐 때 IllegalArgumentException throw`(input: String) {
        Assertions.assertThatThrownBy {
            // when
            ExpressionCalculator.calculate(input)
        }
            // then
            .isInstanceOf(NumberFormatException::class.java)
    }

    @ParameterizedTest
    @CsvSource(value = ["2 + 3 +", "3 + 5 + 44 55", "1 + 3 + 4 *", "1 + 3 + 4 /"])
    fun `문자 파싱 후 길이가 짝수일 경우 IllegalArgumentException throw`(input: String) {
        Assertions.assertThatThrownBy {
            // when
            ExpressionCalculator.calculate(input)
        }
            // then
            .isInstanceOf(IllegalArgumentException::class.java)
            .message().isEqualTo(ErrorMessage.ODD_SIZE_REQUIREMENT_MSG.message)
    }

    @ParameterizedTest
    @CsvSource(value = ["2 +", "3", "1 +"])
    fun `길이가 3보다 작을 경우 IllegalArgumentException throw`(input: String) {
        Assertions.assertThatThrownBy {
            // when
            ExpressionCalculator.calculate(input)
        }
            // then
            .isInstanceOf(IllegalArgumentException::class.java)
            .message().isEqualTo(ErrorMessage.MINIMUM_SIZE_REQUIREMENT_MSG.message)
    }
}
