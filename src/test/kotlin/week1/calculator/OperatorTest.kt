package week1.calculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.EnumSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class OperatorTest {

    @ParameterizedTest
    @EnumSource(Operator::class)
    fun `연산자 검증`(operator: Operator) {
        Assertions.assertThatCode {
            Operator.from(operator.value)
        }
    }

    @ParameterizedTest
    @MethodSource
    fun `연산을 한다`(operator: Operator, a: Int, b: Int, expected: Int) {
        val actual = operator.execute(a, b)
        assertThat(actual).isEqualTo(actual)
    }

    @ParameterizedTest
    @ValueSource(strings = ["_", "@", "#", "+-", "++"])
    fun `유효하지 않은 연산자`(invalidOperator: String) {
        assertThat(Operator.isOperatorSymbol(invalidOperator)).isFalse()
    }

    @ParameterizedTest
    @ValueSource(strings = ["+", "-", "*", "/"])
    fun `유효한 연산자`(invalidOperator: String) {
        assertThat(Operator.isOperatorSymbol(invalidOperator)).isTrue()
    }

    companion object {
        @JvmStatic
        fun `연산을 한다`() = listOf(
            Arguments.of(Operator.ADD, 1, 2, 3),
            Arguments.of(Operator.ADD, 123000, 456, 123456),
            Arguments.of(Operator.SUBTRACT, 1, 2, -1),
            Arguments.of(Operator.SUBTRACT, 10, 2, 8),
            Arguments.of(Operator.MULTIPLY, 1, 2, 2),
            Arguments.of(Operator.MULTIPLY, 123, 456, 56088),
            Arguments.of(Operator.DIVIDE, 1, 2, 0),
            Arguments.of(Operator.DIVIDE, 100, 9, 11),
        )
    }
}
