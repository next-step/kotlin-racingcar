package calculator.calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class OperatorTest {
    @Test
    fun `Plus 연산자 테스트`() {
        val left = Number(1.0)
        val right = Number(2.0)
        val operator = Operator.PLUS
        assertThat(operator.operate(left, right)).isEqualTo(Number(3.0))
    }

    @Test
    fun `Minus 연산자 테스트`() {
        val left = Number(1.0)
        val right = Number(2.0)
        val operator = Operator.MINUS
        assertThat(operator.operate(left, right)).isEqualTo(Number(-1.0))
    }

    @Test
    fun `Multiply 연산자 테스트`() {
        val left = Number(1.0)
        val right = Number(2.0)
        val operator = Operator.MULTIPLY
        assertThat(operator.operate(left, right)).isEqualTo(Number(2.0))
    }

    @Test
    fun `Divide 연산자 테스트`() {
        val left = Number(1.0)
        val right = Number(2.0)
        val operator = Operator.DIVIDE
        assertThat(operator.operate(left, right)).isEqualTo(Number(0.5))
    }

    @Test
    fun `Divide 연산자 0으로 나눌 때 Exception 테스트`() {
        val left = Number(1.0)
        val right = Number(0.0)
        val operator = Operator.DIVIDE
        assertThatThrownBy {
            assertThat(operator.operate(left, right))
        }.isInstanceOf(Operator.DivideByZeroException::class.java)
    }
}
