package calculator.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.util.Lists
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName

internal class ExpressionTest {

    @Test
    @DisplayName("올바르지 않은 식의 tokenList를 넣으면 Exception")
    fun invalidExpression() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { Expression(Lists.newArrayList("1", "+")) }
    }

    @Test
    @DisplayName("연산자나 피연산자를 올바른 순서로 넣지 않고 식을 계산하면 Exception")
    fun invalidOperatorAndOperand() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { Expression(Lists.newArrayList("+", "1", "-")).execute() }
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { Expression(Lists.newArrayList("1", "1", "-")).execute() }
    }

    @Test
    @DisplayName("올바른 순서의 expressionList를 넣었을 때 계산에 성공한다")
    fun calculateExpression() {
        val expression = Expression(Lists.newArrayList("1", "+", "1"))
        val execute = expression.execute()
        assertThat(execute).isEqualTo(Operand(2.0))
    }
}
