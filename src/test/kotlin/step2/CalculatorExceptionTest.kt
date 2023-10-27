package step2

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorExceptionTest {
    @Test
    fun null체크() {
        Assertions.assertThatThrownBy {
            Calculator.calculate(null)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @CsvSource(
        value = ["*13+4", "%20+5"],
    )
    fun 문자열이_맨앞으로_올_때(input: String) {
        Assertions.assertThatThrownBy {
            Calculator.calculate(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @CsvSource(
        value = ["3$4", "6!2"],
    )
    fun 사칙연산이_아닐_때(input: String) {
        Assertions.assertThatThrownBy {
            Calculator.calculate(input)
        }.isInstanceOf(IllegalStateException::class.java)
    }

    @Test
    fun Zero로_나누기() {
        Assertions.assertThatThrownBy {
            Calculator.calculate("2+3/0*4")
        }.isInstanceOf(IllegalStateException::class.java)
    }
}
