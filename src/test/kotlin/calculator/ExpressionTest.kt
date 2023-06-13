package calculator

import calculator.exception.IllegalExpressionException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ExpressionTest {
    @Test
    fun `숫자는 기호보다 정확히 1개 많아야 한다`() {
        val numbers = listOf(1F)
        val operators = listOf<Operator>()
        assertDoesNotThrow { Expression(numbers, operators) }
    }

    @ParameterizedTest
    @MethodSource("generateTestData")
    fun `숫자는 기호보다 정확히 1개 많아야 한다 그렇지 않으면 에러가 발생한다`(numbers: List<Float>, operators: List<Operator>) {
        assertThrows<IllegalExpressionException> { Expression(numbers, operators) }
    }

    @Test
    fun `기본 예제 테스트`() {
        val numbers = listOf(2F, 3F, 4F, 2F)
        val operators = listOf(Operator.ADD, Operator.MULTIPLY, Operator.DIVIDE)
        val expression = Expression(numbers, operators)

        assertThat(expression.sum()).isEqualTo(10F)
    }

    @Test
    fun `모든 사칙연산 기호를 포함하는 경우 테스트`() {
        val numbers = listOf(2F, 3F, 4F, 2F, 5F)
        val operators = listOf(Operator.ADD, Operator.MULTIPLY, Operator.DIVIDE, Operator.SUBTRACT)
        val expression = Expression(numbers, operators)

        assertThat(expression.sum()).isEqualTo(5F)
    }

    companion object {
        @JvmStatic
        fun generateTestData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1F, 2F, 3F), listOf(Operator.ADD, Operator.ADD, Operator.ADD)),
                Arguments.of(listOf(1F, 2F, 3F), listOf(Operator.ADD, Operator.ADD, Operator.ADD, Operator.ADD)),
                Arguments.of(listOf(1F, 2F, 3F), listOf(Operator.ADD)),
            )
        }
    }
}
