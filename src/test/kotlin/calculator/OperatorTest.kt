package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import calculator.Operator.Companion.convertToOperator
import calculator.CalculatorException.IS_NOT_ARITHMETIC_SYMBOL_EXCEPTION

class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["+", "-", "*", "/"])
    fun `사칙연산 기호 테스트`(op: String) {
        assertThat(convertToOperator(op))
    }

    @ParameterizedTest
    @ValueSource(strings = ["%", "^", "&"])
    fun `지원하지 않는 기호 테스트`(op: String) {
        assertThatThrownBy { convertToOperator(op) }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(IS_NOT_ARITHMETIC_SYMBOL_EXCEPTION)
    }

    @ParameterizedTest(name = "Test {index}: input1 == {0}, input2 == {1}, result == {2}")
    @CsvSource(value = ["1, 3, 4", "6, 10, 16", "20, 100, 120", "123, 456, 579"])
    fun `덧셈 테스트`(input1: Int, input2: Int, result: Int) {
        assertThat(convertToOperator("+").calculate(input1, input2)).isEqualTo(result)
    }

    @ParameterizedTest(name = "Test {index}: input1 == {0}, input2 == {1}, result == {2}")
    @CsvSource(value = ["3, 1, 2", "1, 3, -2", "15, 10, 5", "123, 456, -333"])
    fun `뺼셈 테스트`(input1: Int, input2: Int, result: Int) {
        assertThat(convertToOperator("-").calculate(input1, input2)).isEqualTo(result)
    }

    @ParameterizedTest(name = "Test {index}: input1 == {0}, input2 == {1}, result == {2}")
    @CsvSource(value = ["3, 1, 3", "1, 3, 3", "15, 10, 150", "100, 45, 4500"])
    fun `곱셈 테스트`(input1: Int, input2: Int, result: Int) {
        assertThat(convertToOperator("*").calculate(input1, input2)).isEqualTo(result)
    }

    @ParameterizedTest(name = "Test {index}: input1 == {0}, input2 == {1}, result == {2}")
    @CsvSource(value = ["3, 1, 3", "1, 3, 0", "220, 4, 55", "100, 50, 2"])
    fun `나눗셈 테스트`(input1: Int, input2: Int, result: Int) {
        assertThat(convertToOperator("/").calculate(input1, input2)).isEqualTo(result)
    }

    @ParameterizedTest(name = "Test {index}: {0} / {1}")
    @CsvSource(value = ["2, 0", "40, 0", "100, 0"])
    fun `0으로 나누기 테스트`(value: Int, zero: Int) {
        assertThatThrownBy { convertToOperator("/").calculate(value, zero) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(
                CalculatorException.CANT_DIVIDE_ZERO_EXCEPTION
            )
    }
}
