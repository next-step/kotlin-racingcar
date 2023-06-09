package step2.strategy

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step2.expression.Operand
import step2.expression.Operator

internal class CalculatorStrategyTest {
    @Test
    internal fun `우선 순위 없는 연산 수행`() {
        val sut = CalculatorStrategy()
        val expressionItems = listOf(
            Operand("1"),
            Operator.of("+"),
            Operand("2"),
            Operator.of("*"),
            Operand("3")
        )
        val actual = sut.apply(expressionItems)
        assertThat(actual).isEqualTo("9")
    }
}
