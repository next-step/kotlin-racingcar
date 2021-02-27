package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OperatorTest {

    private val operator = Operator()

    @Test
    fun 더하기() {
        assertThat(operator.plus(3, 5)).isEqualTo(8)
        assertThat(operator.plus(999, 2)).isEqualTo(1001)
        assertThat(operator.plus(10000000, 100000000)).isEqualTo(110000000)
    }

    @Test
    fun 빼기() {
        assertThat(operator.minus(5, 5)).isEqualTo(0)
        assertThat(operator.minus(5, 10)).isEqualTo(-5)
        assertThat(operator.minus(1000, 300000)).isEqualTo(-299000)
    }

    @Test
    fun 곱하기() {
        assertThat(operator.multiply(5, 5)).isEqualTo(25)
        assertThat(operator.multiply(1000000, 5)).isEqualTo(5000000)
    }

    @Test
    fun 나누기() {
        assertThat(operator.divide(5, 5)).isEqualTo(1)
        assertThat(operator.divide(10, 5)).isEqualTo(2)
        assertThat(operator.divide(1, 5)).isEqualTo(0)
    }

    @Test
    fun 계산하기() {
        assertThat(operator.operate(5, 5, "+")).isEqualTo(10)
        assertThat(operator.operate(5, 5, "*")).isEqualTo(25)
        assertThat(operator.operate(5, 5, "-")).isEqualTo(0)
        assertThat(operator.operate(5, 5, "/")).isEqualTo(1)
    }
}