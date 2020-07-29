package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ExpressionCheckerTest {

    @Test
    fun `number or operator is empty`() {
        assertThat(ExpressionChecker.isEmpty(listOf(1, 2), emptyList())).isEqualTo(true)
        assertThat(ExpressionChecker.isEmpty(emptyList(), listOf(Operator.MUL))).isEqualTo(true)
        assertThat(ExpressionChecker.isEmpty(emptyList(), emptyList())).isEqualTo(true)
    }

    @Test
    fun `valid expression size`() {
        assertThat(ExpressionChecker.isValidExpressionSize(listOf(1, 2), listOf(Operator.MUL)))
            .isEqualTo(true)
    }

    @Test
    fun `invalid expression size`() {
        assertThat(ExpressionChecker.isValidExpressionSize(listOf(1, 2), listOf(Operator.MUL, Operator.ADD)))
            .isEqualTo(false)
        assertThat(ExpressionChecker.isValidExpressionSize(listOf(1, 2, 4, 5), listOf(Operator.MUL)))
            .isEqualTo(false)
    }
}
