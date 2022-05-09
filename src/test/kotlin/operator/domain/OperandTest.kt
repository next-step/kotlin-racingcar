package operator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OperandTest {

    @Test
    fun `연산자 오버로딩 plus 테스트`() {
        val operand1 = Operand(1.0);
        val operand2 = Operand(1.0);

        val result = operand1 + operand2

        assertThat(result.num).isEqualTo(2.0)
    }

    @Test
    fun `연산자 오버로딩 minus 테스트`() {
        val operand1 = Operand(1.0);
        val operand2 = Operand(1.0);

        val result = operand1 - operand2

        assertThat(result).isEqualTo(Operand(0.0))
    }

    @Test
    fun `연산자 오버로딩 times 테스트`() {
        val operand1 = Operand(1.0);
        val operand2 = Operand(51.0);

        val result = operand1 * operand2

        assertThat(result).isEqualTo(Operand(51.0))
    }

    @Test
    fun `연산자 오버로딩 div 테스트`() {
        val operand1 = Operand(6.0);
        val operand2 = Operand(3.0);

        val result = operand1 / operand2

        assertThat(result).isEqualTo(Operand(2.0))
    }

    @Test
    fun `연산자 오버로딩 vo test`() {
        val operand1 = Operand(1.0);
        val operand2 = Operand(1.0);

        val result = operand1 + operand2

        assertThat(result).isEqualTo(Operand(2.0))
    }
}
