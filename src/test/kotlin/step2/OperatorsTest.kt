package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class OperatorsTest {
    @ParameterizedTest
    @CsvSource("1,2,3", "2,3,5", "4.2,5.3,9.5")
    fun `덧셈 연산 결과`(a: Double, b: Double, expected: Double) {
        assertThat(Operator.PLUS.operate(a, b)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("2,3,-1", "5,3,2", "9.5,4.2,5.3")
    fun `뺄셈 연산 결과`(a: Double, b: Double, expected: Double) {
        assertThat(Operator.SUBTRACT.operate(a, b)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("1,2,2", "2,3,6", "4.2,5.3,22.26")
    fun `곱셈 연산 결과`(a: Double, b: Double, expected: Double) {
        assertThat(Operator.MULTIPLY.operate(a, b)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("2,2,1", "6,3,2", "23,2.5,9.2")
    fun `나눗셈 연산 결과`(a: Double, b: Double, expected: Double) {
        assertThat(Operator.DIVISION.operate(a, b)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("2,0")
    fun `0으로 나눗셈 연산시 예외처리`(a: Double, b: Double) {
        assertThatThrownBy { Operator.DIVISION.operate(a, b) }.hasMessageContaining(division0ErrorMessage)
    }
}
