package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "7,         7",
            "3+5,       8",
            "1+2+3/3,   2.0",
            "27/5,      5.4",
            "27  /   5, 5.4"
        ]
    )
    fun `수식 문자열이 들어오면, 계산한 결과결과를 리턴한다`(string: String, expect: Float) {
        assertThat(Calculator.calculate(string)).isEqualTo(expect)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "    ", "수식이 아니다", "No", "1++2**3"])
    fun `수식이 아닌 문자열이 들어오면, IllegalArgumentException 예외가 발생한다`(string: String) {
        assertThrows<IllegalArgumentException> {
            Calculator.calculate(string)
        }
    }
}
