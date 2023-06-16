package calculrate

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource

class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    fun `입력값이 Null 이거나 빈 공백 문자일 경우 IllegalArgumentException throw`(input: String?) {
        Assertions.assertThatThrownBy {
            Calculator.calculate(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw`() {
        Assertions.assertThatThrownBy {
            Operator.of("!")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @CsvSource("2 + 3,5", "2 + 3 + 3,8", "2 + 3 + 10,15")
    fun `덧셈`(input: String, expected: Int?) {
        val actual = Calculator.calculate(input)
        assertThat(actual).isEqualTo(expected)
    }
}
