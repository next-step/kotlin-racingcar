package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class OperatorTest {
    @Test
    fun 더하기() {
        val result = Operator.PLUS.calculate(1.0, 2.0)
        Assertions.assertThat(result).isEqualTo(3.0)
    }

    @Test
    fun 곱하기() {
        val result = Operator.MULTIPLY.calculate(1.0, 2.0)
        Assertions.assertThat(result).isEqualTo(2.0)
    }

    @Test
    fun 빼기() {
        val result = Operator.MINUS.calculate(1.0, 2.0)
        Assertions.assertThat(result).isEqualTo(-1.0)
    }

    @Test
    fun 나누기() {
        val result = Operator.DIVIDE.calculate(1.0, 2.0)
        Assertions.assertThat(result).isEqualTo(0.5)
    }
}
