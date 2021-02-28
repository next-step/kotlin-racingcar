package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class OperatorTest {

    private val num1 = Number.of("6")
    private val num2 = Number.of("3")

    @Test
    fun `사칙연산 기호가 아닌 것을 넣으면 예외를 반환한다`() {
        assertThatThrownBy {
            Operator.of("=")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("the value not Operator")
    }

    @ParameterizedTest
    @MethodSource("provideOperatorArguments")
    fun `operate 를 실행하면 기대값을 반환한다`(operator: Operator, expected: Number) {
        val result = operator.operate(num1, num2)
        assertThat(result).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun provideOperatorArguments(): List<Arguments> {
            return listOf(
                Arguments.of(Operator.PLUS, Number.of("9")),
                Arguments.of(Operator.MINUS, Number.of("3")),
                Arguments.of(Operator.TIMES, Number.of("18")),
                Arguments.of(Operator.DIVIDE, Number.of("2"))
            )
        }
    }
}
