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
}
