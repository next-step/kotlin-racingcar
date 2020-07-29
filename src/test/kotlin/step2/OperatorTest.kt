package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class OperatorTest {

    @Test
    fun `Symbol addiction test`() {
        assertThat(Operator.ADD.symbol).isEqualTo("+")
        assertThat(Operator.ADD.symbol).isNotEqualTo('+')
    }

    @Test
    fun `Symbol subtraction test`() {
        assertThat(Operator.SUB.symbol).isEqualTo("-")
        assertThat(Operator.SUB.symbol).isNotEqualTo('-')
    }

    @Test
    fun `Symbol multiply test`() {
        assertThat(Operator.MUL.symbol).isEqualTo("*")
        assertThat(Operator.MUL.symbol).isNotEqualTo('*')
    }

    @Test
    fun `Symbol divide test`() {
        assertThat(Operator.DIV.symbol).isEqualTo("/")
        assertThat(Operator.DIV.symbol).isNotEqualTo('/')
    }

    @Test
    fun `Addiction test`() {
        assertThat(Operator.ADD.invoke(3, 36)).isEqualTo(39)
    }

    @Test
    fun `Subtraction test`() {
        assertThat(Operator.SUB.invoke(10, 3)).isEqualTo(7)
        assertThat(Operator.SUB.invoke(3, 3)).isEqualTo(0)
        assertThat(Operator.SUB.invoke(3, -10)).isEqualTo(13)
        assertThat(Operator.SUB.invoke(3, 10)).isEqualTo(-7)
    }

    @Test
    fun `Multiply test`() {
        assertThat(Operator.MUL.invoke(10, 3)).isEqualTo(30)
        assertThat(Operator.MUL.invoke(-10, 3)).isEqualTo(-30)
        assertThat(Operator.MUL.invoke(10, -3)).isEqualTo(-30)
        assertThat(Operator.MUL.invoke(10, 0)).isEqualTo(0)
        assertThat(Operator.MUL.invoke(0, 0)).isEqualTo(0)
    }

    @Test
    fun `Divide test`() {
        assertThatThrownBy { Operator.DIV.invoke(10, 0) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Can't be divided by zero.")

        assertThatThrownBy { Operator.DIV.invoke(0, 0) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Can't be divided by zero.")
    }
}
