package calculator.domain

import calculator.domain.Operator.DIVIDE
import calculator.domain.Operator.MINUS
import calculator.domain.Operator.PLUS
import calculator.domain.Operator.TIMES
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class OperatorTests {

    @ParameterizedTest
    @CsvSource("1, 2", "3, 4", "-1, -5")
    fun `덧셈 연산자는 입력받은 두 피연산자를 더할 수 있다`(left: Int, right: Int) {
        assertThat(PLUS.operation(Operand(left), Operand(right))).isEqualTo(Operand(left + right))
    }

    @ParameterizedTest
    @CsvSource("1, 2", "3, 4", "-1, -5")
    fun `뺄셈 연산자는 입력받은 두 피연산자를 뺼 수 있다`(left: Int, right: Int) {
        assertThat(MINUS.operation(Operand(left), Operand(right))).isEqualTo(Operand(left - right))
    }

    @ParameterizedTest
    @CsvSource("1, 2", "3, 4", "-1, -5")
    fun `곱셈 연산자는 입력받은 두 피연산자를 곱할 수 있다`(left: Int, right: Int) {
        assertThat(TIMES.operation(Operand(left), Operand(right))).isEqualTo(Operand(left * right))
    }

    @ParameterizedTest
    @CsvSource("1, 2", "3, 4", "-1, -5")
    fun `나눗셈 연산자는 입력받은 두 피연산자를 나눌 수 있다`(left: Int, right: Int) {
        assertThat(DIVIDE.operation(Operand(left), Operand(right))).isEqualTo(Operand(left / right.toDouble()))
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "&", "#"])
    fun `유효하지 않은 연산자인 경우 예외를 발생시킨다`(symbol: String) {
        Assertions.assertThatThrownBy { Operator.of(symbol) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("사칙 연산이 아닌 연산자는 지원하지 않습니다")
    }
}
