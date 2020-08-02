package calculator.calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class OperatorTest {
    @Test
    fun `Plus 연산자 테스트`() {
        val left = Node.Number(1.0)
        val right = Node.Number(2.0)
        val operator = Node.Operator.Plus
        assertThat(operator.operate(left, right)).isEqualTo(Node.Number(3.0))
    }

    @Test
    fun `Minus 연산자 테스트`() {
        val left = Node.Number(1.0)
        val right = Node.Number(2.0)
        val operator = Node.Operator.Minus
        assertThat(operator.operate(left, right)).isEqualTo(Node.Number(-1.0))
    }

    @Test
    fun `Multiply 연산자 테스트`() {
        val left = Node.Number(1.0)
        val right = Node.Number(2.0)
        val operator = Node.Operator.Multiply
        assertThat(operator.operate(left, right)).isEqualTo(Node.Number(2.0))
    }

    @Test
    fun `Divide 연산자 테스트`() {
        val left = Node.Number(1.0)
        val right = Node.Number(2.0)
        val operator = Node.Operator.Divide
        assertThat(operator.operate(left, right)).isEqualTo(Node.Number(0.5))
    }

    @Test
    fun `Divide 연산자 0으로 나눌 때 Exception 테스트`() {
        val left = Node.Number(1.0)
        val right = Node.Number(0.0)
        val operator = Node.Operator.Divide
        assertThatThrownBy {
            assertThat(operator.operate(left, right))
        }.isInstanceOf(Node.Operator.Divide.DivideByZeroException::class.java)
    }
}
