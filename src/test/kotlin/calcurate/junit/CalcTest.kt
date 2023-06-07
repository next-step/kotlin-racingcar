package calcurate.junit

import calcurate.ErrorCode
import calcurate.expression.Expression
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.IllegalArgumentException

class CalcTest {
    /**
     * Success Case
     */
    @Test
    fun `덧셈 성공`() {
        val expression = Expression("3 + 2 + 5")

        Assertions.assertThat(expression.calculation()).isEqualTo(10.0)
    }

    @Test
    fun `뺄셈 성공`() {
        val expression = Expression("20 - 5 - 2")

        Assertions.assertThat(expression.calculation()).isEqualTo(13.0)
    }

    @Test
    fun `곱셈 성공`() {
        val expression = Expression("50 * 2 * 3")

        Assertions.assertThat(expression.calculation()).isEqualTo(300.0)
    }

    @Test
    fun `나눗셈 성공`() {
        val expression = Expression("1000 / 100 / 5")

        Assertions.assertThat(expression.calculation()).isEqualTo(2.0)
    }

    /**
     * Fail Case
     */
    @Test
    fun `나누는 값이 0`() {
        val invalidValue = 0.0
        val expression = Expression("1000 / 100 / $invalidValue")

        assertThrows<IllegalArgumentException>(ErrorCode.INVALID_DIVIDE_VALUE.msg) { expression.calculation() }
    }

    @Test
    fun `expression 이 null 혹은 빈 공백 문자`() {
        val nullExpressionParam = null
        val emptyExpressionParam = " "

        assertThrows<IllegalArgumentException>(ErrorCode.INVALID_EXPRESSION.msg) { Expression(nullExpressionParam) }
        assertThrows<IllegalArgumentException>(ErrorCode.INVALID_EXPRESSION.msg) { Expression(emptyExpressionParam) }
    }

    @Test
    fun `사칙 연산 기호가 아닌 경우`() {
        val invalidCalcSymbol = "?"

        assertThrows<IllegalArgumentException>(ErrorCode.INVALID_CALC_SYMBOL.msg) { Expression("10 + 20 $invalidCalcSymbol 1") }
    }
}
