package calculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = ["2:3:^", "3:5:&", "1:3:|"], delimiter = ':')
    fun `사칙연산 기호가 아닌 경우 예외를 던진다`(currentResult: Int, nextValue: Int, operator: String) {
        Assertions.assertThatThrownBy {
            // when
            StringCalculator.applyOperation(currentResult, nextValue, operator)
        }
            // then
            .isInstanceOf(IllegalArgumentException::class.java)
            .message().isEqualTo(ErrorMessage.UNSUPPORTED_OPERATOR_MSG.message)
    }

    @ParameterizedTest
    @CsvSource(value = ["2:3:+:5", "3:5:-:-2", "1:3:*:3", "3:5:/:0"], delimiter = ':')
    fun `덧셈, 뺄셈, 곱셈, 나눗셈`(currentResult: Int, nextValue: Int, operator: String, expect: Int) {
        // when
        val actual = StringCalculator.applyOperation(currentResult, nextValue, operator)

        // then
        assertThat(actual).isEqualTo(expect)
    }
}
