package calculator.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class OperatorTest {

    @ParameterizedTest
    @CsvSource("1, 2, 3", "3, 4, 7", "5, 6, 11")
    fun `덧셈을 할 수 있다`(left: Double, right: Double, result: Double) {
        assertThat(Operator.PLUS.apply(left, right)).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource("1, 2, -1", "3, 4, -1", "5, 6, -1")
    fun `뺼샘을 할 수 있다`(left: Double, right: Double, result: Double) {
        assertThat(Operator.MINUS.apply(left, right)).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource("1, 2, 2", "3, 4, 12", "5, 6, 30")
    fun `곱셈을 할 수 있다`(left: Double, right: Double, result: Double) {
        assertThat(Operator.TIMES.apply(left, right)).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource("1, 2, 0.5", "3, 4, 0.75", "5, 5, 1.0")
    fun `나눗셈을 할 수 있다`(left: Double, right: Double, result: Double) {
        assertThat(Operator.DIVIDE.apply(left, right)).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource("1, 0", "3, 0", "5, 0")
    fun `0으로 나누는 경우 예외를 발생시킨다`(left: Double, right: Double) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Operator.DIVIDE.apply(left, right) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["&", "$", "#", "!"])
    fun `사칙연산이 아닌 기호는 연산자가 아니다`(symbol: String) {
        assertThat(Operator.isOperator(symbol)).isFalse
    }

    @ParameterizedTest
    @ValueSource(strings = ["&", "$", "#", "!"])
    fun `사칙연산 기호가 아닌 문자열을 연산자로 변환할 경우 예외를 발생시킨다`(symbol: String) {
        assertThatExceptionOfType(UnsupportedOperationException::class.java)
            .isThrownBy { Operator.of(symbol) }
    }
}
