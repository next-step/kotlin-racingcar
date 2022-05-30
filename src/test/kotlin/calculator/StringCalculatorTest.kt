package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {
    private val calculator = StringCalculator()

    @ParameterizedTest
    @CsvSource(value = ["1,2,+,3", "1,2,*,2", "1,2,-,-1", "1,2,/,0.5"])
    fun 사칙연산문자확인(a: Double, b: Double, operator: String, expected: Double) {
        StringCalculator.calculate(a, b, operator)
    }

    @ParameterizedTest
    @CsvSource(value = ["1 + 2 * 3 / 3 * 4,12", "3 + 2 / 5 + 6 * 3,21"])
    fun `문자열 계산기 테스트`(source: String, expected: Double) {
        val result = calculator.calculate(source)
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `빈 공백 문자열이나 null이 들어올 경우 예외 발생`() {
        assertThatThrownBy { calculator.calculate(" ") }
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 예외 발생`() {
        assertThatThrownBy { calculator.calculate("1 a 2 b 3") }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 2 2 + 3", "1 + + 2 + 3"])
    fun `숫자나 사칙연산이 연속으로 오는 경우 예외 발생`(source: String) {
        assertThatThrownBy { calculator.calculate(source) }
    }
}
