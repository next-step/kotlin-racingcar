package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OperatorTest {
    @Test
    internal fun `Plus 생성`() {
        val sut = Operator.of("+")
        assertThat(sut).isInstanceOf(Operator.Plus::class.java)
    }

    @Test
    internal fun `Minus 생성`() {
        val sut = Operator.of("-")
        assertThat(sut).isInstanceOf(Operator.Minus::class.java)
    }

    @Test
    internal fun `Multiply 생성`() {
        val sut = Operator.of("*")
        assertThat(sut).isInstanceOf(Operator.Multiply::class.java)
    }

    @Test
    internal fun `Divide 생성`() {
        val sut = Operator.of("/")
        assertThat(sut).isInstanceOf(Operator.Divide::class.java)
    }

    @Test
    internal fun `Plus 연산`() {
        val sut = Operator.of("+")
        val actual: Operand = sut.operate(Operand("1"), Operand("2"))
        assertThat(actual).isEqualTo(Operand("3"))
    }

    @Test
    internal fun `Minus 연산`() {
        val sut = Operator.of("-")
        val actual: Operand = sut.operate(Operand("1"), Operand("2"))
        assertThat(actual).isEqualTo(Operand("-1"))
    }

    @Test
    internal fun `Multiply 연산`() {
        val sut = Operator.of("*")
        val actual: Operand = sut.operate(Operand("1"), Operand("2"))
        assertThat(actual).isEqualTo(Operand("2"))
    }

    @Test
    internal fun `Divde 연산`() {
        val sut = Operator.of("/")
        val actual: Operand = sut.operate(Operand("1"), Operand("2"))
        assertThat(actual).isEqualTo(Operand("0.5"))
    }
}
