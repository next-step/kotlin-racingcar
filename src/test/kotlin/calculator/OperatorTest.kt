package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OperatorTest {
    @Test
    fun `덧셈 테스트`() {
        val cal = Operator.PLUS.calculate(1, 2)
        assertThat(cal.intValueExact()).isEqualTo(3)
    }

    @Test
    fun `뺄셈 테스트`() {
        val cal = Operator.MINUS.calculate(2, 2)
        assertThat(cal.intValueExact()).isEqualTo(0)
    }

    @Test
    fun `곱셈 테스트`() {
        val cal = Operator.MULTI.calculate(1, 2)
        assertThat(cal.intValueExact()).isEqualTo(2)
    }

    @Test
    fun `나눗셈 테스트`() {
        val cal = Operator.DIVIDE.calculate(1, 2)
        assertThat(cal.toDouble()).isEqualTo(0.5)
    }
}
