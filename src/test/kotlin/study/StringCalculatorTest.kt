package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StringCalculatorTest {
    @Test
    fun 더하기() {
        val result = Operator.PLUS.calculate(1.0, 2.0)
        assertThat(result).isEqualTo(3.0)
    }

    @Test
    fun 곱하기() {
        val result = Operator.MULTIPLY.calculate(1.0, 2.0)
        assertThat(result).isEqualTo(2.0)
    }

    @Test
    fun 빼기() {
        val result = Operator.MINUS.calculate(1.0, 2.0)
        assertThat(result).isEqualTo(-1.0)
    }

    @Test
    fun 나누기() {
        val result = Operator.DIVIDE.calculate(1.0, 2.0)
        assertThat(result).isEqualTo(0.5)
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2,+,3", "1,2,*,2", "1,2,-,-1", "1,2,/,0.5"])
    fun 사칙연산문자확인(a: Double, b: Double, operator: String, expected: Double) {
        StringCalculator.calculate(a, b, operator)
    }
}
