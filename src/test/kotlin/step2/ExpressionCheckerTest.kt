package step2

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class ExpressionCheckerTest {

    @Test
    fun `number or operator is empty`() {
        Assertions.assertThat(ExpressionChecker.isEmpty(listOf(1, 2), emptyList())).isEqualTo(true)
        Assertions.assertThat(ExpressionChecker.isEmpty(emptyList(), listOf(Operator.MUL))).isEqualTo(true)
        Assertions.assertThat(ExpressionChecker.isEmpty(emptyList(), emptyList())).isEqualTo(true)
    }

    @Test
    fun `valid expression size`() {
        Assertions.assertThat(ExpressionChecker.isValidExpressionSize(listOf(1, 2), listOf(Operator.MUL)))
            .isEqualTo(true)
    }

    @Test
    fun `invalid expression size`() {
        Assertions.assertThat(ExpressionChecker.isValidExpressionSize(listOf(1, 2), listOf(Operator.MUL, Operator.ADD)))
            .isEqualTo(false)
        Assertions.assertThat(ExpressionChecker.isValidExpressionSize(listOf(1, 2, 4, 5), listOf(Operator.MUL)))
            .isEqualTo(false)
    }

}