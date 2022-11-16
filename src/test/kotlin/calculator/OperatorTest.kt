package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OperatorTest {
    @Test
    fun `덧셈 연산을 한다`() {
        // given
        val operator = Operator.find('+')

        // when
        val result = operator.operate(1, 2)

        // then
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `뺄셈 연산을 한다`() {
        // given
        val operator = Operator.find('-')

        // when

        val result = operator.operate(11, 1)

        // then
        assertThat(result).isEqualTo(10)
    }

    @Test
    fun `곱셈 연산을 한다`() {
        // given
        val operator = Operator.find('*')

        // when
        val result = operator.operate(2, 3)

        // then
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun `나눗셈 연산을 한다`() {
        // given
        val operator = Operator.find('/')

        // when
        val result = operator.operate(10, 2)

        // then
        assertThat(result).isEqualTo(5)
    }
}
