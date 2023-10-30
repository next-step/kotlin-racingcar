package calculator.enums

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OperatorTest {

    @Test
    fun `성공 - 숫자 더하기`() {
        assertThat(Operator.PLUS.operation(1, 2)).isEqualTo(3)
    }

    @Test
    fun `성공 - 숫자 빼기`() {
        assertThat(Operator.MINUS.operation(1, 2)).isEqualTo(-1)
    }

    @Test
    fun `성공 - 숫자 나누기`() {
        assertThat(Operator.DIVIDE.operation(1, 2)).isEqualTo(0)
        assertThat(Operator.DIVIDE.operation(4, 2)).isEqualTo(2)
    }

    @Test
    fun `성공 - 숫자 곱하기`() {
        assertThat(Operator.MULTIPLY.operation(2, 2)).isEqualTo(4)
    }
}
