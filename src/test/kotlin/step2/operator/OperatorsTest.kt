package step2.operator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import step2.number.Number
import step2.number.Numbers
import java.lang.IllegalArgumentException

internal class OperatorsTest {

    @Test
    fun `계산 테스트`() {
        // given
        val numbers = Numbers(listOf(Number(1), Number(2)))
        val operators = Operators(listOf(Operator.PLUS))

        // when
        val result = operators.calculate(numbers)

        // then
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `연산자의 갯수가 피연산자의 갯수보다 1개 작아야만 한다`() {
        // given
        val numbers = Numbers(listOf(Number(1), Number(2)))
        val operators = Operators(listOf(Operator.PLUS, Operator.PLUS))

        // when

        // then
        assertThatThrownBy { operators.calculate(numbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("피연산자의 갯수(${numbers.size()})가 연산자의 갯수(2)보다 1개 더 많아야 합니다.")
    }
}
