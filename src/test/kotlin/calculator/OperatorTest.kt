package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class OperatorTest {

    @Test
    fun `더하기`() {
        assertThat(Operator.PLUS.apply(1, 2)).isEqualTo(3)
    }

    @Test
    fun `빼기`() {
        assertThat(Operator.MINUS.apply(1, 2)).isEqualTo(-1)
    }

    @Test
    fun `곱하기`() {
        assertThat(Operator.MULTIPLY.apply(1, 2)).isEqualTo(2)
    }

    @Test
    fun `나누기`() {
        assertThat(Operator.SUBTRACT.apply(2, 1)).isEqualTo(2)
    }

    @Test
    fun `0으로 나눈 경우`() {
        assertThrows<IllegalArgumentException> { Operator.SUBTRACT.apply(1, 0) }
    }
}
