package week1.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun calculate() {
    }

    @Test
    fun `더하기`() {
        assertThat(calculator.add(1, 2)).isEqualTo(3)
        assertThat(calculator.add(123000, 456)).isEqualTo(123456)
    }

    @Test
    fun `빼기`() {
        assertThat(calculator.subtract(1, 2)).isEqualTo(-1)
        assertThat(calculator.subtract(10, 2)).isEqualTo(8)
    }

    @Test
    fun `곱하기`() {
        assertThat(calculator.multiply(1, 2)).isEqualTo(2)
        assertThat(calculator.multiply(123, 456)).isEqualTo(56088)
    }

    @Test
    fun `나누기`() {
        assertThat(calculator.divide(1, 2)).isEqualTo(0)
        assertThat(calculator.divide(100, 9)).isEqualTo(11)
    }
}