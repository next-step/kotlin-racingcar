package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class OperandsTest {

    @Test
    fun `피연산자를 추가해야 합니다`() {
        val operands = Operands()
        operands.add("1")
        operands.add("2")

        val operandA = operands.removeFirst()
        val operandB = operands.removeFirst()

        assertThat(operandA).isEqualTo(1)
        assertThat(operandB).isEqualTo(2)
    }

    @Test
    fun `피연산자 상태가 계산 가능한지 반환합니다`() {
        val operands = Operands()
        operands.add("1")
        operands.add("2")

        val calculable = operands.isCalculable()

        assertThat(calculable).isTrue
    }

    @Test
    fun `유효하지 않은 입력값인 경우 예외를 던집니다`() {
        val operands = Operands()

        assertThatThrownBy { operands.add("*") }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy {
            operands.add("1")
            operands.add("3")
            operands.add("4")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
