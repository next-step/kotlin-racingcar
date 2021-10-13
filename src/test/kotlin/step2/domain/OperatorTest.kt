package step2.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class OperatorTest {

    @DisplayName("Operator values() 기능 테스트")
    @ParameterizedTest(name = "연산자 : {0}, 결과 enum : {1}")
    @MethodSource("calculateArgument")
    fun values_test(sign: String, operator: Operator) {
        // given and when
        val actual = Operator.values(sign)

        // then
        assertThat(actual).isEqualTo(operator)
    }

    @DisplayName("Operator calculate() 기능 테스트")
    @ParameterizedTest(name = "x 피연산자 : {0}, y 피연산자 : {1}, 결과 : {2}, 연산 enum : {3}")
    @MethodSource("operateArgument")
    fun calculate_test(x: Int, y: String, expected: Int, operator: Operator) {
        // given and when
        val actual = operator.calculate(x, y)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun calculateArgument() = listOf(
            Arguments.of("+", Operator.PLUS),
            Arguments.of("-", Operator.MINUS),
            Arguments.of("*", Operator.MULTIPLICATION),
            Arguments.of("/", Operator.DIVISION),
            Arguments.of("%", Operator.REMAINDER)
        )

        @JvmStatic
        fun operateArgument() = listOf(
            Arguments.of(1, "1", 2, Operator.PLUS),
            Arguments.of(1, "1", 0, Operator.MINUS),
            Arguments.of(1, "1", 1, Operator.MULTIPLICATION),
            Arguments.of(1, "1", 1, Operator.DIVISION),
            Arguments.of(1, "1", 0, Operator.REMAINDER)
        )
    }
}
