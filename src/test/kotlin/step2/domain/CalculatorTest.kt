package step2.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import step2.StringCalculator

class CalculatorTest {
    @DisplayName("연산자 예외처리 테스트")
    @ParameterizedTest
    @CsvSource(value = ["1 & 2", "1 ^ 2"])
    fun `연산자 예외처리 테스트`(input: String) {
        assertThatThrownBy { StringCalculator.calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("덧셈 연산 테스트")
    @ParameterizedTest
    @CsvSource(value = ["1:2", "0:9", "0:0", "21:17"], delimiter = ':')
    fun `덧셈 연산 테스트`(operand1: Int, operand2: Int) {
        assertThat(Calculator.calculate("+", operand1, operand2)).isEqualTo(operand1 + operand2)
    }

    @DisplayName("뺄셈 연산 테스트")
    @ParameterizedTest
    @CsvSource(value = ["1:2", "0:9", "9:0", "9:9", "0:0"], delimiter = ':')
    fun `뺄셈 연산 테스트`(operand1: Int, operand2: Int) {
        assertThat(Calculator.calculate("-", operand1, operand2)).isEqualTo(operand1 - operand2)
    }

    @DisplayName("곱셈 연산 테스트")
    @ParameterizedTest
    @CsvSource(value = ["1:2", "0:9", "0:0", "21:17"], delimiter = ':')
    fun `곱셈 연산 테스트`(operand1: Int, operand2: Int) {
        assertThat(Calculator.calculate("*", operand1, operand2)).isEqualTo(operand1 * operand2)
    }

    @DisplayName("나눗셈 연산 테스트")
    @ParameterizedTest
    @CsvSource(value = ["1:2", "0:9", "9:9"], delimiter = ':')
    fun `나눗셈 연산 테스트`(operand1: Int, operand2: Int) {
        assertThat(Calculator.calculate("/", operand1, operand2)).isEqualTo(operand1 / operand2)
    }

    @DisplayName("나눗셈 연산 예외처리 테스트")
    @ParameterizedTest
    @CsvSource(value = ["9:0", "0:0"], delimiter = ':')
    fun `나눗셈 연산 예외처리 테스트`(operand1: Int, operand2: Int) {
        assertThatThrownBy { Calculator.calculate("/", operand1, operand2) }
            .isInstanceOf(ArithmeticException::class.java)
    }
}
