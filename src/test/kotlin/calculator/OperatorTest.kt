package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OperatorTest {
    @Test
    fun 덧셈() {
        val first = 1.0
        val second = 2.0
        assertThat(Operator.PLUS.calculate(first, second)).isEqualTo(3.0)
    }

    @Test
    fun 뺄셈() {
        val first = 1.0
        val second = 2.0
        assertThat(Operator.SUBTRACT.calculate(first, second)).isEqualTo(-1.0)
    }

    @Test
    fun 곱셈() {
        val first = 10.0
        val second = 2.0
        assertThat(Operator.MULTIPLY.calculate(first, second)).isEqualTo(20.0)
    }

    @Test
    fun 나눗셈() {
        val first = 30.0
        val second = 3.0
        assertThat(Operator.DIVIDE.calculate(first, second)).isEqualTo(10.0)
    }
}
