package step2.expression

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OperandTest {

    @Test
    fun `더하기`() {
        val a = Operand("1")
        val b = Operand("2")
        assertThat(a + b).isEqualTo(Operand("3"))
    }

    @Test
    fun `빼기`() {
        val a = Operand("1")
        val b = Operand("2")
        assertThat(a - b).isEqualTo(Operand("-1"))
    }

    @Test
    fun `곱하기`() {
        val a = Operand("1")
        val b = Operand("2")
        assertThat(a * b).isEqualTo(Operand("2"))
    }

    @Test
    fun `나누기 - 소수점 첫째 자리에서 반올림`() {
        val a = Operand("1")
        val b = Operand("2")
        assertThat(a / b).isEqualTo(Operand("0"))
    }
}
