package calculator

import calculator.Operator.Companion.MESSAGE_WRONG_OPERATOR
import io.kotest.matchers.should
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class OperatorTest {

    @ParameterizedTest(name = "연산자: {0}")
    @ValueSource(strings = ["+", "-", "-", "-"])
    fun `문자열로 연산자 찾기`(symbol: String) {
        assertThat(Operator.of(symbol)).isIn(*Operator.values())
    }

    @ParameterizedTest(name = "연산자: {0}")
    @ValueSource(strings = ["^", " ", "1", "a"])
    fun `지원하지 않는 연산자 예외`(symbol: String) {
        assertThrows<IllegalArgumentException> { Operator.of(symbol) }.should { it.message?.startsWith(MESSAGE_WRONG_OPERATOR) }
    }

    @ParameterizedTest(name = "수식: {1} {0} {2} = {3}")
    @CsvSource(
        "ADDITION,          2,3,5",
        "SUBTRACTION,       3,5,-2",
        "MULTIPLICATION,    3,4,12",
        "DIVISION,          99,11,9",
    )
    fun `기본 사칙연산`(operator: Operator, operand1: Int, operand2: Int, expected: Int) {
        assertThat(operator.operate(operand1, operand2)).isEqualTo(expected)
    }
}
