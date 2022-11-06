package step2

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StringCalculatorTest {
    @DisplayName("덧셈 연산")
    @ParameterizedTest
    @CsvSource(value = ["1:2", "0:9", "0:-1", "0:0", "21:17"], delimiter = ':')
    fun addTest(operand1: Int, operand2: Int) {
        assertThat(StringCalculator.add(operand1, operand2)).isEqualTo(operand1 + operand2)
    }

    @DisplayName("뺄셈 연산")
    @ParameterizedTest
    @CsvSource(value = ["1:2", "0:9", "9:0", "9:9", "0:0"], delimiter = ':')
    fun subtractTest(operand1: Int, operand2: Int) {
        assertThat(StringCalculator.subtract(operand1, operand2)).isEqualTo(operand1 - operand2)
    }

    @DisplayName("곱셈 연산")
    @ParameterizedTest
    @CsvSource(value = ["1:2", "0:9", "0:-1", "0:0", "21:17"], delimiter = ':')
    fun multiplyTest(operand1: Int, operand2: Int) {
        assertThat(StringCalculator.multiply(operand1, operand2)).isEqualTo(operand1 * operand2)
    }

    @DisplayName("나눗셈 연산")
    @ParameterizedTest
    @CsvSource(value = ["1:2", "0:9", "9:9"], delimiter = ':')
    fun divideTest(operand1: Int, operand2: Int) {
        assertThat(StringCalculator.divide(operand1, operand2)).isEqualTo(operand1 / operand2)
    }

    @DisplayName("나눗셈 연산 - by zero")
    @ParameterizedTest
    @CsvSource(value = ["9:0", "0:0"], delimiter = ':')
    fun divideByZeroTest(operand1: Int, operand2: Int) {
        Assertions.assertThatThrownBy { StringCalculator.divide(operand1, operand2) }
            .isInstanceOf(ArithmeticException::class.java)
    }
}