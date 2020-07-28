package step2

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class OperatorTest {

    @Test
    fun `Symbol addiction test`() {
        Assertions.assertThat(Operator.ADD.symbol).isEqualTo("+")
        Assertions.assertThat(Operator.ADD.symbol).isNotEqualTo('+')
    }

    @Test
    fun `Symbol subtraction test`() {
        Assertions.assertThat(Operator.SUB.symbol).isEqualTo("-")
        Assertions.assertThat(Operator.SUB.symbol).isNotEqualTo('-')
    }

    @Test
    fun `Symbol multiply test`() {
        Assertions.assertThat(Operator.MUL.symbol).isEqualTo("*")
        Assertions.assertThat(Operator.MUL.symbol).isNotEqualTo('*')
    }

    @Test
    fun `Symbol divide test`() {
        Assertions.assertThat(Operator.DIV.symbol).isEqualTo("/")
        Assertions.assertThat(Operator.DIV.symbol).isNotEqualTo('/')
    }

    @Test
    fun `Addiction test`() {
        Assertions.assertThat(Operator.ADD.invoke(3, 36)).isEqualTo(39)
    }

    @Test
    fun `Subtraction test`() {
        Assertions.assertThat(Operator.SUB.invoke(10, 3)).isEqualTo(7)
        Assertions.assertThat(Operator.SUB.invoke(3, 3)).isEqualTo(0)
        Assertions.assertThat(Operator.SUB.invoke(3, -10)).isEqualTo(13)
        Assertions.assertThat(Operator.SUB.invoke(3, 10)).isEqualTo(-7)
    }

    @Test
    fun `Multiply test`() {
        Assertions.assertThat(Operator.MUL.invoke(10, 3)).isEqualTo(30)
        Assertions.assertThat(Operator.MUL.invoke(-10, 3)).isEqualTo(-30)
        Assertions.assertThat(Operator.MUL.invoke(10, -3)).isEqualTo(-30)
        Assertions.assertThat(Operator.MUL.invoke(10, 0)).isEqualTo(0)
        Assertions.assertThat(Operator.MUL.invoke(0, 0)).isEqualTo(0)
    }

    @Test
    fun `Divide test`() {
        Assertions.assertThatThrownBy { Operator.DIV.invoke(10, 0) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Can't be divided by zero.")

        Assertions.assertThatThrownBy { Operator.DIV.invoke(0, 0) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Can't be divided by zero.")
    }


}