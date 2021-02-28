package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import step2.data.Operand
import step2.util.Const.Companion.NOTICE_NOT_DIVIDE_ZERO

class OperandTest {

    @Test
    fun `더하기`() {
        val operand1 = Operand(3.0)
        val operand2 = Operand(3.0)

        assertThat(operand1.add(operand2)).isEqualTo(Operand(6.0))
    }

    @Test
    fun `빼기`() {
        val operand1 = Operand(2.0)
        val operand2 = Operand(2.0)

        assertThat(operand1.minus(operand2)).isEqualTo(Operand(0.0))
    }

    @Test
    fun `곱하기`() {
        val operand1 = Operand(3.0)
        val operand2 = Operand(7.0)

        assertThat(operand1.multiply(operand2)).isEqualTo(Operand(21.0))
    }

    @Test
    fun `나누기`() {
        val operand1 = Operand(3.0)
        val operand2 = Operand(2.0)

        assertThat(operand1.divide(operand2)).isEqualTo(Operand(1.5))
    }

    @Test
    fun `나누기 0`() {
        val operand1 = Operand(3.0)
        val operand2 = Operand(0.0)

        assertThatThrownBy { operand1.divide(operand2) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(NOTICE_NOT_DIVIDE_ZERO)
    }
}
