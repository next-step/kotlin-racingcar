package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class OperandTest {

    @Test
    fun `덧셈 결과 테스트`() {
        // given
        val operand1 = Operand(1.0)
        val operand2 = Operand(2.0)

        // then
        assertThat(operand1.add(operand2)).isEqualTo(Operand(3.0))
    }

    @Test
    fun `뺄셈 결과 테스트`() {
        // given
        val operand1 = Operand(2.0)
        val operand2 = Operand(1.0)

        // then
        assertThat(operand1.minus(operand2)).isEqualTo(Operand(1.0))
    }

    @Test
    fun `곱셈 결과 테스트`() {
        // given
        val operand1 = Operand(3.0)
        val operand2 = Operand(2.0)

        // then
        assertThat(operand1.multiply(operand2)).isEqualTo(Operand(6.0))
    }

    @Test
    fun `나눗셈 결과 테스트`() {
        // given
        val operand1 = Operand(4.0)
        val operand2 = Operand(2.0)

        // then
        assertThat(operand1.divide(operand2)).isEqualTo(Operand(2.0))
    }

    @Test
    fun `0으로 나눌 시 Exception`() {
        // given
        val operand1 = Operand(4.0)
        val operand2 = Operand(0.0)

        // then
        assertThatThrownBy { operand1.divide(operand2) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("0으로는 나눌 수 없습니다.")
    }
}
