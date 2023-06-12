package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class OperatorTest {
    @Test
    fun `더한다`() {
        val result = Operator.PLUS.operation.invoke(5, 3)
        assertThat(result).isEqualTo(8)
    }

    @Test
    fun `뺀다`() {
        val result = Operator.MINUS.operation.invoke(10, 4)
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun `곱한다`() {
        val result = Operator.TIMES.operation.invoke(7, 2)
        assertThat(result).isEqualTo(14)
    }

    @Test
    fun `나눈다`() {
        val result = Operator.DIVIDE.operation.invoke(10, 2)
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun `0으로 나누면 IllegalArgumentException 발생`() {
        assertThatIllegalArgumentException().isThrownBy { Operator.DIVIDE.operation.invoke(10, 0) }
    }
}