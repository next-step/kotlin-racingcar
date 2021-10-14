package calculator.domain.vo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("식(Expression)")
class ExpressionTest {
    private val one = Term(1)
    private val two = Term(2)

    @Test
    fun `덧셈을 한다`() {
        val expected = Term(3)
        assertThat(
            Expression(
                left = one,
                operator = Operator.PLUS,
                right = two
            ).calculate()
        ).isEqualTo(expected)
    }

    @Test
    fun `뺄셈을 한다`() {
        val expected = Term(-1)
        assertThat(
            Expression(
                left = one,
                operator = Operator.MINUS,
                right = two
            ).calculate()
        ).isEqualTo(expected)
    }

    @Test
    fun `곱셈을 한다`() {
        val expected = Term(2)
        assertThat(
            Expression(
                left = one,
                operator = Operator.TIMES,
                right = two
            ).calculate()
        ).isEqualTo(expected)
    }

    @Test
    fun `나눗셈을 한다`() {
        val expected = Term(0.5)
        assertThat(
            Expression(
                left = one,
                operator = Operator.DIVIDE,
                right = two
            ).calculate()
        ).isEqualTo(expected)
    }
}
