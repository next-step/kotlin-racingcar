package step2

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    @ParameterizedTest
    @CsvSource(
        "1+2+3+4,10",
        "2+3*4/2,10",
        "1 + 2 + 3 + 4, 10",
        "2 + 3 * 4 / 2, 10",
        "2      +  3      *   4      /   2 ,10",
        "2,2",
    )
    fun `문자열에 대한 연산 결과가 정상동작한다`(string: String, result: Double) {
        assertThat(Calculator.calculate(string)).isEqualTo(result)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "  "])
    fun `입력값이 빈 값일 경우에 대한 예외처리`(string: String) {
        Assertions.assertThatThrownBy {
            Calculator.calculate(string)
        }.hasMessageContaining(Calculator.blankErrorMessage)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 + 2a", "1 x 3  ", "1 + 2..2", "1 + 3.2.1  "])
    fun `입력값이 잘못된 경우에 대한 예외처리`(string: String) {
        Assertions.assertThatThrownBy {
            Calculator.calculate(string)
        }.hasMessageContaining(StringParser.NumberFormatExceptionErrorMessage)
    }
}
