package calculator.application

import calculator.domain.Expression
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CalculatorTests {

    private val calculator = Calculator()

    @ParameterizedTest
    @MethodSource("expressionsAndResult")
    fun `계산기는 식을 계산할 수 있다`(expression: Expression, result: Double) {
        assertThat(calculator.calculate(expression)).isEqualTo(result)
    }

    @Test
    fun `계산기는 0으로 나누는 연산이 포함된 식을 계산하면 예외를 발생시킨다`() {
        val zeroContainedExpression = Expression.of("10/0")
        assertThrows<IllegalArgumentException> { calculator.calculate(zeroContainedExpression) }
    }

    companion object {
        @JvmStatic
        fun expressionsAndResult(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Expression.of("1+2-3*4"), 0.0),
                Arguments.of(Expression.of("100*10-5"), 995),
                Arguments.of(Expression.of("15-10*10/2"), 25)
            )
        }
    }
}
