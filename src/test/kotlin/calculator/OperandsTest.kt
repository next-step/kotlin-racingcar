package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OperandsTest {

    @Test
    fun `피연산자를 추가해야 합니다`() {
        val operands = Operands()
        operands.add("1")
        operands.add("2")
        Assertions.assertThat(operands.getOperand()).isEqualTo(1)
        Assertions.assertThat(operands.getOperand()).isEqualTo(2)
    }
    @Test
    fun `피연산자 상태가 계산 가능한지 반환합니다`() {
        val operands = Operands()
        operands.add("1")
        operands.add("2")
        Assertions.assertThat(operands.isCalculable()).isTrue()
    }

    @Test
    fun `유효하지 않은 입력값인 경우 예외를 던집니다`() {
        val operands = Operands()
        Assertions.assertThatThrownBy { operands.add("*") }.isInstanceOf(IllegalArgumentException::class.java)
        Assertions.assertThatThrownBy {
            operands.add("1")
            operands.add("3")
            operands.add("4")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }


}
