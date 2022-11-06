package step2

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {
    @DisplayName("연속된 입력에 대한 연산 테스트")
    @Test
    fun `연속된 입력에 대한 연산 테스트`() {
        assertThat(StringCalculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10)
    }

    @DisplayName("빈 문자열에 대한 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `빈 문자열에 대한 예외처리 테스트`(input: String) {
        Assertions.assertThatThrownBy { StringCalculator(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("연산 테스트")
    @ParameterizedTest
    @CsvSource(value = ["1 + 2:3", "1 - 2:-1", "1 * 2:2", "1 / 2:0"], delimiter = ':')
    fun `연산 테스트`(input: String, output: Int) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(output)
    }

    @DisplayName("연산자 예외처리 테스트")
    @ParameterizedTest
    @CsvSource(value = ["1 & 2", "1 ^ 2"])
    fun `연산자 예외처리 테스트`(input: String) {
        Assertions.assertThatThrownBy { StringCalculator.calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("정수 검증 테스트")
    @Test
    fun `정수 검증 테스트`() {
        Assertions.assertThatThrownBy { StringCalculator.validateOperand("ABC") }
            .isInstanceOf(NumberFormatException::class.java)
    }

    @DisplayName("덧셈 연산 테스트")
    @ParameterizedTest
    @CsvSource(value = ["1:2", "0:9", "0:-1", "0:0", "21:17"], delimiter = ':')
    fun `덧셈 연산 테스트`(operand1: Int, operand2: Int) {
        assertThat(StringCalculator.add(operand1, operand2)).isEqualTo(operand1 + operand2)
    }

    @DisplayName("뺄셈 연산 테스트")
    @ParameterizedTest
    @CsvSource(value = ["1:2", "0:9", "9:0", "9:9", "0:0"], delimiter = ':')
    fun `뺄셈 연산 테스트`(operand1: Int, operand2: Int) {
        assertThat(StringCalculator.subtract(operand1, operand2)).isEqualTo(operand1 - operand2)
    }

    @DisplayName("곱셈 연산 테스트")
    @ParameterizedTest
    @CsvSource(value = ["1:2", "0:9", "0:-1", "0:0", "21:17"], delimiter = ':')
    fun `곱셈 연산 테스트`(operand1: Int, operand2: Int) {
        assertThat(StringCalculator.multiply(operand1, operand2)).isEqualTo(operand1 * operand2)
    }

    @DisplayName("나눗셈 연산 테스트")
    @ParameterizedTest
    @CsvSource(value = ["1:2", "0:9", "9:9"], delimiter = ':')
    fun `나눗셈 연산 테스트`(operand1: Int, operand2: Int) {
        assertThat(StringCalculator.divide(operand1, operand2)).isEqualTo(operand1 / operand2)
    }

    @DisplayName("나눗셈 연산 예외처리 테스트")
    @ParameterizedTest
    @CsvSource(value = ["9:0", "0:0"], delimiter = ':')
    fun `나눗셈 연산 예외처리 테스트`(operand1: Int, operand2: Int) {
        Assertions.assertThatThrownBy { StringCalculator.divide(operand1, operand2) }
            .isInstanceOf(ArithmeticException::class.java)
    }
}