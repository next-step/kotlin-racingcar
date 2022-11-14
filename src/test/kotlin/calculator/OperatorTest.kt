package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OperatorTest {
    @Test
    fun `덧셈 연산을 할 수 있다`() {
        // given
        val operator = Operator()

        // when
        operator.find("1 + 2")
        val result = operator.operate(1, 2)

        // then
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `뺄셈 연산을 할 수 있다`() {
        // given
        val operator = Operator()

        // when
        operator.find("11 - 1")
        val result = operator.operate(11, 1)

        // then
        assertThat(result).isEqualTo(10)
    }

    @Test
    fun `곱셈 연산을 할 수 있다`() {
        // given
        val operator = Operator()

        // when
        operator.find("2 * 3")
        val result = operator.operate(2, 3)

        // then
        assertThat(result).isEqualTo(6)
    }
}
