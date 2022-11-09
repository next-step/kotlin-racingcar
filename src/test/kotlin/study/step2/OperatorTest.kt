package study.step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OperatorTest {
    @Test
    fun `덧셈`() {
        val operator = Operator.PLUS
        val result = operator.operate(4, 7)

        assertThat(result).isEqualTo(11)
    }

    @Test
    fun `뺄셈`() {
        val operator = Operator.MINUS
        val result = operator.operate(7, 4)

        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `곱셈`() {
        val operator = Operator.MULTIPLY
        val result = operator.operate(3, 4)

        assertThat(result).isEqualTo(12)
    }

    @Test
    fun `나눗셈`() {
        val operator = Operator.DIVIDE
        val result = operator.operate(4, 2)

        assertThat(result).isEqualTo(2)
    }
}
