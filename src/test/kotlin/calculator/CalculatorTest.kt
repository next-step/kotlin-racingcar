package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun `더하기`() {
        val calculator = Calculator()
        val actual = calculator.add(1, 2)
        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun `빼기`() {
        val calculator = Calculator()
        val actual = calculator.sub(1, 2)
        assertThat(actual).isEqualTo(-1)
    }

    @Test
    fun `곱하기`() {
        val calculator = Calculator()
        val actual = calculator.multiply(2, 4)
        assertThat(actual).isEqualTo(8)
    }

    @Test
    fun `나누기`() {
        val calculator = Calculator()
        val actual = calculator.divide(4, 2)
        assertThat(actual).isEqualTo(2)
    }
}
