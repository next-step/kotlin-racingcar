package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class OperationTest {

    @ParameterizedTest
    @CsvSource(value = ["+:PLUS", "-:MINUS", "*:MULTIPLY", "/:DIVIDE"], delimiter = ':')
    fun `사칙 연산이면 Operation 객체를 반환한다`(input: String, expect: Operation) {
        // when
        val actual = Operation.fromString(input)

        // then
        assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "b", "c", "d", "^", "&"])
    fun `사칙 연산이 아니면 IllegalArgumentException을 반환한다`(input: String) {
        // when, then
        assertThatThrownBy { Operation.fromString(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .message().isEqualTo(ErrorMessage.UNSUPPORTED_OPERATOR_MSG.message)
    }

    @ParameterizedTest
    @CsvSource(value = ["2:3:PLUS:5", "3:5:MINUS:-2", "1:3:MULTIPLY:3", "3:5:DIVIDE:0"], delimiter = ':')
    fun `덧셈, 뺄셈, 곱셈, 나눗셈`(currentResult: Int, nextValue: Int, operator: Operation, expect: Int) {
        // when
        val actual = operator.calculate(currentResult, nextValue)

        // then
        assertThat(actual).isEqualTo(expect)
    }
}
